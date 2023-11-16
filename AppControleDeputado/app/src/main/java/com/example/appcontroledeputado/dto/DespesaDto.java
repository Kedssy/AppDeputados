package com.example.appcontroledeputado.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class DespesaDto {

    @JsonProperty("dados")
    private ArrayList<DadosDespesa> dados;

    @JsonProperty("links")
    private List<Links> links;


    public DespesaDto() {
    }

    public ArrayList<DadosDespesa> getDados() {
        return dados;
    }

    public void setDados(ArrayList<DadosDespesa> dados) {
        this.dados = dados;
    }

    public List<Links> getLinks() {
        return links;
    }

    public void setLinks(List<Links> links) {
        this.links = links;
    }
}
