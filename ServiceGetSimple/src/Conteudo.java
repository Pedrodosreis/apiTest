import java.util.Date;

public class Conteudo {

    private String titulo;
    private String urlImage;
    private String imageDate;
    public Conteudo(String titulo, String urlImagem) {
        this.titulo = titulo;
        this.urlImage = urlImagem;
        this.imageDate = new Date().toString();
    }

    public Conteudo(String titulo, String urlImagem, String imageDate) {
        this.titulo = titulo;
        this.urlImage = urlImagem;
        this.imageDate = imageDate != null && !imageDate.isEmpty() ? imageDate : new Date().toString();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getImageDate() {
        return imageDate;
    }
}