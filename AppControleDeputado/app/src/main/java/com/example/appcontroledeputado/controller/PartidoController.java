package com.example.appcontroledeputado.controller;

import android.content.Context;

import com.example.appcontroledeputado.dto.DeputadoDto;
import com.example.appcontroledeputado.dto.PartidoDto;
import com.example.appcontroledeputado.retrofit.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PartidoController {
    public interface PartidoCallback {
        void onPartidoDtoReceived(PartidoDto partidoDto);
        void onPartidoError(String errorMessage);
    }

    public static void getPartidos(Context ctx, final PartidoController.PartidoCallback callback) {
        try {
            Call<PartidoDto> call = new RetrofitConfig().partidoService().partidos();

            call.enqueue(new Callback<PartidoDto>() {
                @Override
                public void onResponse(Call<PartidoDto> call, Response<PartidoDto> response) {
                    PartidoDto dto = response.body();
                    callback.onPartidoDtoReceived(dto);
                }

                @Override
                public void onFailure(Call<PartidoDto> call, Throwable t) {
                    callback.onPartidoError(t.getMessage());

                }
            });

        } catch (Exception ex) {
            callback.onPartidoError(ex.getMessage());
        }
    }
}
