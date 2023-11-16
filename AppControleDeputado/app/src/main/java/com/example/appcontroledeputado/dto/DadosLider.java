package com.example.appcontroledeputado.dto;

public class DadosLider {
    private String nome;
    private String urlFoto;
    private long id;
    private String uri;
    private String siglaPartido;
    private String uf;
    private String uriPartido;
    private int idLegislatura;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getSiglaPartido() {
        return siglaPartido;
    }

    public void setSiglaPartido(String siglaPartido) {
        this.siglaPartido = siglaPartido;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getUriPartido() {
        return uriPartido;
    }

    public void setUriPartido(String uriPartido) {
        this.uriPartido = uriPartido;
    }

    public int getIdLegislatura() {
        return idLegislatura;
    }

    public void setIdLegislatura(int idLegislatura) {
        this.idLegislatura = idLegislatura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public DadosLider(String nome, String urlFoto) {
        this.nome = nome;
        this.urlFoto = urlFoto;
    }

    public DadosLider() {
    }
}
