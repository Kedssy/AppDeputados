package com.example.appcontroledeputado.view;

import static com.example.appcontroledeputado.utils.Globais.listaDeputados;
import static com.example.appcontroledeputado.utils.Globais.listaPartidos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.appcontroledeputado.R;
import com.example.appcontroledeputado.controller.DeputadoController;
import com.example.appcontroledeputado.controller.PartidoController;
import com.example.appcontroledeputado.dto.DadosDespesa;
import com.example.appcontroledeputado.dto.DeputadoDto;
import com.example.appcontroledeputado.dto.PartidoDto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btDespesas;
    private Button btPartidos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btDespesas = findViewById(R.id.btDespesas);
        btPartidos = findViewById(R.id.btPartidos);
        btDespesas.setOnClickListener(v -> abrirActivity());
        btPartidos.setOnClickListener(v -> abrirActivityPartidos());

        DeputadoController.getDeputadoDto(this, new DeputadoController.DeputadoCallback() {
            @Override
            public void onDeputadoDtoReceived(DeputadoDto deputadoDto) {

                listaDeputados = new ArrayList<>();

                listaDeputados.addAll(deputadoDto.getDados());
            }

            @Override
            public void onDeputadoError(String errorMessage) {
                Log.e("Deputado Error", errorMessage);
            }
        });

        PartidoController.getPartidos(this, new PartidoController.PartidoCallback() {
            @Override
            public void onPartidoDtoReceived(PartidoDto partidoDto) {
                listaPartidos = new ArrayList<>();
                listaPartidos.addAll(partidoDto.getDados());
            }

            @Override
            public void onPartidoError(String errorMessage) {
                Log.e("Partidos Error", errorMessage);
            }
        });

    }



    public void abrirActivity(){
        Intent intent = new Intent(this, ListaDeputadoActivity.class);
        startActivity(intent);
    }

    public void abrirActivityPartidos(){
        Intent intent = new Intent(this, ListaPartidoActivity.class);
        startActivity(intent);
    }

}