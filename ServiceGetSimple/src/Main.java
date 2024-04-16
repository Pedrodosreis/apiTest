import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
public class Main {

    private static String NASA_KEY = "vepILoRSPVsdd7sMjtWKtkR04lBmRRLgPQtqNzZ1";
    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar imagens da API da Nasa
        String url = "https://api.nasa.gov/planetary/apod?api_key=" + NASA_KEY + "&count=5";
        URI end = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(end).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extrair só os dados que interessam (titulo, url imagem, data)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir os dados
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("url"));
            System.out.println(filme.get("date"));
            System.out.println();
        }
    }
}