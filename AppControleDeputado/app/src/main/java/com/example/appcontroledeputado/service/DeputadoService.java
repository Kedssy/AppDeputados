package com.example.appcontroledeputado.service;

import com.example.appcontroledeputado.dto.DeputadoDto;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DeputadoService {
    @GET("deputados")
    Call<DeputadoDto> deputados();
}