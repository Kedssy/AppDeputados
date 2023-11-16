package com.example.appcontroledeputado.controller;

import android.content.Context;

import com.example.appcontroledeputado.dto.DeputadoDto;
import com.example.appcontroledeputado.dto.DespesaDto;
import com.example.appcontroledeputado.dto.PartidoCompleteDto;
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

    public interface PartidoCompleteCallback {
        void onPartidoDtoReceived(PartidoCompleteDto partidoCompleteDto);
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

    public static void getPartidoById(long idPartido, Context ctx, final PartidoController.PartidoCompleteCallback callback) {
        try {
            Call<PartidoCompleteDto> call = new RetrofitConfig().partidoService().partidoPorId(idPartido);

            call.enqueue(new Callback<PartidoCompleteDto>() {
                @Override
                public void onResponse(Call<PartidoCompleteDto> call, Response<PartidoCompleteDto> response) {
                    PartidoCompleteDto dto = response.body();
                    callback.onPartidoDtoReceived(dto);
                }

                @Override
                public void onFailure(Call<PartidoCompleteDto> call, Throwable t) {
                    callback.onPartidoError(t.getMessage());

                }
            });

        } catch (Exception ex) {
            callback.onPartidoError(ex.getMessage());
        }
    }
}
