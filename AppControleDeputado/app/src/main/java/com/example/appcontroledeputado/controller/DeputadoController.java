package com.example.appcontroledeputado.controller;

import android.content.Context;
import android.util.Log;

import com.example.appcontroledeputado.dto.DadosDeputado;
import com.example.appcontroledeputado.dto.DeputadoDto;
import com.example.appcontroledeputado.retrofit.RetrofitConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeputadoController {


    public static void executarAPI(Context ctx) {
        try {
            Call<DeputadoDto> call = new RetrofitConfig().deputadoService().deputados();


            call.enqueue(new Callback<DeputadoDto>() {

                @Override
                public void onResponse(Call<DeputadoDto> call,
                                       Response<DeputadoDto> response) {
                    DeputadoDto dto = response.body();
                    System.out.println(dto.toString());
                }

                @Override
                public void onFailure(Call<DeputadoDto> call, Throwable t) {
                    Log.e("ERRO",
                            "Erro ao comunicar com a API: " + t.getMessage());
                }
            });

        } catch (Exception ex) {

        }
    }
}
