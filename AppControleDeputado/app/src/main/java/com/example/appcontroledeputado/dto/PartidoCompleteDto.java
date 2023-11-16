package com.example.appcontroledeputado.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PartidoCompleteDto {
    @JsonProperty("dados")
    private DadosPartidoComplete dados;

    @JsonProperty("links")
    private List<Links> links;


    public PartidoCompleteDto() {
    }

    public DadosPartidoComplete getDados() {
        return dados;
    }

    public void setDados(DadosPartidoComplete dados) {
        this.dados = dados;
    }

    public List<Links> getLinks() {
        return links;
    }

    public void setLinks(List<Links> links) {
        this.links = links;
    }
}
