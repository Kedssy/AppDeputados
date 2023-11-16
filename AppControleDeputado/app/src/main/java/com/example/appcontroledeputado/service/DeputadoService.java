package com.example.appcontroledeputado.service;

import com.example.appcontroledeputado.dto.DeputadoDto;
import com.example.appcontroledeputado.dto.DespesaDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DeputadoService {
    @GET("deputados")
    Call<DeputadoDto> deputados();

    @GET("deputados/{id}/despesas")
    Call<DespesaDto> despesasPorDeputadoId(@Path("id") long id);
}