package com.example.appcontroledeputado.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PartidoDto {
    @JsonProperty("dados")
    private ArrayList<DadosPartido> dados;

    @JsonProperty("links")
    private List<Links> links;


    public PartidoDto() {
    }

    public Collection<? extends DadosPartido> getDados() {
        return dados;
    }

    public void setDados(ArrayList<DadosPartido> dados) {
        this.dados = dados;
    }

    public List<Links> getLinks() {
        return links;
    }

    public void setLinks(List<Links> links) {
        this.links = links;
    }
}
