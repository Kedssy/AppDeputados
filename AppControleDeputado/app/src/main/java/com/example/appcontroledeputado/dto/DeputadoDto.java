package com.example.appcontroledeputado.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class DeputadoDto {

    @JsonProperty("dados")
    private ArrayList<DadosDeputado> dados;

    @JsonProperty("links")
    private List<Links> links;

    public List<Links> getLinks() {
        return links;
    }

    public void setLinks(List<Links> links) {
        this.links = links;
    }

    public DeputadoDto() {
    }

    public DeputadoDto(ArrayList<DadosDeputado> dados) {
        this.dados = dados;
    }

    public ArrayList<DadosDeputado> getDados() {
        return dados;
    }

    public void setDados(ArrayList<DadosDeputado> dados) {
        this.dados = dados;
    }
}
