public enum API {

    NASA("https://api.nasa.gov/planetary/apod?api_key=" + "vepILoRSPVsdd7sMjtWKtkR04lBmRRLgPQtqNzZ1" + "&count=5", new ExtratorDeConteudoDaNasa());

    private String url;
    private ExtratorDeConteudo extrator;
    private static String NASA_KEY = "vepILoRSPVsdd7sMjtWKtkR04lBmRRLgPQtqNzZ1";

    API(String url, ExtratorDeConteudo extrator) {
        this.url = url;
        this.extrator = extrator;
    }

    public String getUrl() {
        return url;
    }

    public ExtratorDeConteudo getExtrator() {
        return extrator;
    }
}