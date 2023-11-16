package com.example.appcontroledeputado.retrofit;

import com.example.appcontroledeputado.service.DeputadoService;
import com.example.appcontroledeputado.service.PartidoService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    //url de conexão

    private static String BASE_URL = "https://dadosabertos.camara.leg.br/api/v2/";

    OkHttpClient okHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(JacksonConverterFactory
                        .create()).build();
    }

    public DeputadoService deputadoService() {
        return this.retrofit.create(DeputadoService.class);
    }

    public PartidoService partidoService() {
        return this.retrofit.create(PartidoService.class);
    }

}
