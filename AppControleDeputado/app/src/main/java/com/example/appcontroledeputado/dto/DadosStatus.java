package com.example.appcontroledeputado.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DadosStatus {
    private String data;
    private String idLegislatura;
    private String situacao;
    private String totalMembros;
    private String totalPosse;
    private String uriMembros;

    public String getTotalPosse() {
        return totalPosse;
    }

    public void setTotalPosse(String totalPosse) {
        this.totalPosse = totalPosse;
    }

    public String getUriMembros() {
        return uriMembros;
    }

    public void setUriMembros(String uriMembros) {
        this.uriMembros = uriMembros;
    }

    @JsonProperty("lider")
    private DadosLider lider;

    public DadosStatus(String data, String idLegislatura, String situacao, String totalMembros, String urlLogo, DadosLider lider) {
        this.data = data;
        this.idLegislatura = idLegislatura;
        this.situacao = situacao;
        this.totalMembros = totalMembros;
        this.lider = lider;
    }

    public DadosStatus() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getIdLegislatura() {
        return idLegislatura;
    }

    public void setIdLegislatura(String idLegislatura) {
        this.idLegislatura = idLegislatura;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getTotalMembros() {
        return totalMembros;
    }

    public void setTotalMembros(String totalMembros) {
        this.totalMembros = totalMembros;
    }

    public DadosLider getLider() {
        return lider;
    }

    public void setLider(DadosLider lider) {
        this.lider = lider;
    }
}
