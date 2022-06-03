require('isomorphic-fetch');

const characters = async (offset = 0) => {
    const baseUrl = 'https://gateway.marvel.com/v1/public/characters?offset="+offset+"&limit=100&ts=1&apikey=144534be448beb03d2c4571b70f8b4e0&hash=e748cdfa0d54795c9a535ae375041f58'
    const charactersStream = await fetch(baseUrl)
    const characters = await charactersStream.json();
    formattedCharacters = characters.data.results.map((character) => {
        return {
            id: character.id,
            name: character.name
        }
    });
    console.log(characters.data.total)
    console.log(formattedCharacters)
}

characters();