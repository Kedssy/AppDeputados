package com.example.appcontroledeputado.service;

import com.example.appcontroledeputado.dto.DeputadoDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DeputadoService {
    @GET("deputados")
    Call<DeputadoDto> deputados();

    @GET("deputado/{id}/despesas")
    Call<List<DeputadoDto>> despesasPorDeputadoId(@Path("id") int id);
}