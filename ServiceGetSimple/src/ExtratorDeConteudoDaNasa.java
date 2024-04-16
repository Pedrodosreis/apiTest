import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {

    public List<Conteudo> extraiConteudos(String json) {

        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

//        return listaDeAtributos.stream()
//                .map(atributos -> new Conteudo(atributos.get("title"), atributos.get("url")))
//                .toList();

        List<Conteudo> conteudoList = new ArrayList<>(listaDeAtributos.size());
        for (Map<String,String> conteudo: listaDeAtributos) {
            conteudoList.add(new Conteudo(conteudo.get("title"), conteudo.get("url"), conteudo.get("date")));
        }
        return conteudoList;
    }
}