package com.example.appcontroledeputado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.appcontroledeputado.controller.DeputadoController;
import com.example.appcontroledeputado.dto.DadosDeputado;
import com.example.appcontroledeputado.dto.DeputadoDto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DeputadoController.getDeputadoDto(this, new DeputadoController.DeputadoCallback() {
            @Override
            public void onDeputadoDtoReceived(DeputadoDto deputadoDto) {
                // Utilize o deputadoDto retornado aqui

                List<DadosDeputado> dadosDeputadoList = new ArrayList<>();

                dadosDeputadoList.addAll(deputadoDto.getDados());

                System.out.println("DeputadoDto. Email do deputado: " + dadosDeputadoList.get(1).getEmail());
            }

            @Override
            public void onDeputadoError(String errorMessage) {
                // Lide com o erro aqui
                Log.e("DeputadoError", errorMessage);
            }
        });
    }
}