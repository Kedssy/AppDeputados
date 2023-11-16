package com.example.appcontroledeputado.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DadosPartidoComplete {
    private long id;
    private String sigla;
    private String nome;
    private String uri;
    private int numeroEleitoral;
    private String urlWebSite;
    private String urlFacebook;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getNumeroEleitoral() {
        return numeroEleitoral;
    }

    public void setNumeroEleitoral(int numeroEleitoral) {
        this.numeroEleitoral = numeroEleitoral;
    }

    public String getUrlWebSite() {
        return urlWebSite;
    }

    public void setUrlWebSite(String urlWebSite) {
        this.urlWebSite = urlWebSite;
    }

    public String getUrlFacebook() {
        return urlFacebook;
    }

    public void setUrlFacebook(String urlFacebook) {
        this.urlFacebook = urlFacebook;
    }

    private String urlLogo;

    @JsonProperty("status")
    private DadosStatus status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public DadosStatus getStatus() {
        return status;
    }

    public void setStatus(DadosStatus status) {
        this.status = status;
    }

    public DadosPartidoComplete() {
    }

    public DadosPartidoComplete(long id, String sigla, String nome, String urlLogo, DadosStatus status) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
        this.urlLogo = urlLogo;
        this.status = status;
    }
}
