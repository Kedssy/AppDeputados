package com.example.appcontroledeputado.service;

import com.example.appcontroledeputado.dto.DeputadoDto;
import com.example.appcontroledeputado.dto.DespesaDto;
import com.example.appcontroledeputado.dto.PartidoCompleteDto;
import com.example.appcontroledeputado.dto.PartidoDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PartidoService {
    @GET("partidos")
    Call<PartidoDto> partidos();

    @GET("partidos/{id}")
    Call<PartidoCompleteDto> partidoPorId(@Path("id") long id);
}
