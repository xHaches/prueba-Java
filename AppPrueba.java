import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.util.Scanner;

public class AppPrueba {
    public static void main(String[] args) {
        try {

            System.out.println(".... Iniciando .....");
            int offset = 0;
            String urlString = "https://gateway.marvel.com/v1/public/characters?offset="+offset+"&limit=1&ts=1&apikey=144534be448beb03d2c4571b70f8b4e0&hash=e748cdfa0d54795c9a535ae375041f58";

            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "*/*");
            con.connect();
            System.out.println("Leyendo respuesta.... ");
            String respuestaRandomUserAPI = "";

            InputStream inputStream = null;
            inputStream = con.getInputStream();
            Scanner s = new Scanner(inputStream).useDelimiter("\\A");
            respuestaRandomUserAPI = s.hasNext() ? s.next() : "";
            con.disconnect();
            inputStream.close();

            System.out.println(":::RESPUESTA DEL API OBTENIDA:::");
            System.out.println(respuestaRandomUserAPI);
            System.out.println(".... FIN ....");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}