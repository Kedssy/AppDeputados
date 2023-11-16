package com.example.appcontroledeputado.service;

import com.example.appcontroledeputado.dto.DeputadoDto;
import com.example.appcontroledeputado.dto.PartidoDto;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PartidoService {
    @GET("partidos")
    Call<PartidoDto> partidos();
}
