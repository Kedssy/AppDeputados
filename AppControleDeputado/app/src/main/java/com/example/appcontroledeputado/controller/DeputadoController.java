package com.example.appcontroledeputado.controller;

import android.content.Context;
import android.util.Log;

import com.example.appcontroledeputado.dto.DadosDeputado;
import com.example.appcontroledeputado.dto.DeputadoDto;
import com.example.appcontroledeputado.dto.DespesaDto;
import com.example.appcontroledeputado.retrofit.RetrofitConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeputadoController {

    public interface DeputadoCallback {
        void onDeputadoDtoReceived(DeputadoDto deputadoDto);
        void onDeputadoError(String errorMessage);
    }

    public interface DespesaCallback {
        void onDespesaDtoReceived(DespesaDto despesaDto);
        void onDespesaDtoError(String errorMessage);
    }

    public static void getDeputados(Context ctx, final DeputadoCallback callback) {
        try {
            Call<DeputadoDto> call = new RetrofitConfig().deputadoService().deputados();

            call.enqueue(new Callback<DeputadoDto>() {
                @Override
                public void onResponse(Call<DeputadoDto> call, Response<DeputadoDto> response) {
                        DeputadoDto dto = response.body();
                        callback.onDeputadoDtoReceived(dto);
                }

                @Override
                public void onFailure(Call<DeputadoDto> call, Throwable t) {
                    callback.onDeputadoError(t.getMessage());

                }
            });

        } catch (Exception ex) {
            callback.onDeputadoError(ex.getMessage());
        }
    }

    public static void getDespesas(long idDeputado, Context ctx, final DespesaCallback callback) {
        try {
            Call<DespesaDto> call = new RetrofitConfig().deputadoService().despesasPorDeputadoId(idDeputado);

            call.enqueue(new Callback<DespesaDto>() {
                @Override
                public void onResponse(Call<DespesaDto> call, Response<DespesaDto> response) {
                    DespesaDto dto = response.body();
                    callback.onDespesaDtoReceived(dto);
                }

                @Override
                public void onFailure(Call<DespesaDto> call, Throwable t) {
                    callback.onDespesaDtoError(t.getMessage());

                }
            });

        } catch (Exception ex) {
            callback.onDespesaDtoError(ex.getMessage());
        }
    }

    public static DeputadoDto getDeputadoDto(Context ctx, final DeputadoCallback callback) {
        final DeputadoDto[] returnedDto = {null}; // Array para armazenar o DTO

        getDeputados(ctx, new DeputadoCallback() {
            @Override
            public void onDeputadoDtoReceived(DeputadoDto deputadoDto) {
                returnedDto[0] = deputadoDto; // Armazena o DTO retornado
                callback.onDeputadoDtoReceived(deputadoDto); // Chama o callback
            }

            @Override
            public void onDeputadoError(String errorMessage) {
                callback.onDeputadoError(errorMessage); // Chama o callback de erro
            }
        });

        return returnedDto[0];
    }
}
