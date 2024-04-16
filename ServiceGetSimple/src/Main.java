import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
public class Main {


    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar imagens da API da Nasa
        API api = API.NASA;
        ClientHttp clientHttp = new ClientHttp();
        String body = clientHttp.buscaDados(api.getUrl());

        List<Conteudo> conteudoList = api.getExtrator().extraiConteudos(body);
        var editor = new ImageEditor();

        // exibir os dados
        for (Conteudo conteudo : conteudoList) {
            System.out.println(conteudo.getTitulo());

            System.out.println(conteudo.getUrlImage());
            InputStream inputStream = new URL(conteudo.getUrlImage()).openStream();
            if(!conteudo.getUrlImage().contains("youtube") && !conteudo.getUrlImage().contains("gif")) {
                editor.cria(inputStream, "Saida/" + conteudo.getTitulo() + ".png");
            }

            System.out.println(conteudo.getImageDate());
            System.out.println();
        }
    }
}