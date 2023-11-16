package com.example.appcontroledeputado.view;

import static com.example.appcontroledeputado.utils.Globais.listaDeputados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.appcontroledeputado.R;
import com.example.appcontroledeputado.controller.DeputadoController;
import com.example.appcontroledeputado.dto.DadosDeputado;
import com.example.appcontroledeputado.dto.DeputadoDto;
import com.example.appcontroledeputado.utils.Globais;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btDespesas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btDespesas = findViewById(R.id.btDespesas);
        btDespesas.setOnClickListener(v -> abrirActivity());
        DeputadoController.getDeputadoDto(this, new DeputadoController.DeputadoCallback() {
            @Override
            public void onDeputadoDtoReceived(DeputadoDto deputadoDto) {
                // Utilize o deputadoDto retornado aqui

                //List<DadosDeputado> dadosDeputadoList = new ArrayList<>();

                //dadosDeputadoList.addAll(deputadoDto.getDados());

                listaDeputados = new ArrayList<>();

                listaDeputados.addAll(deputadoDto.getDados());

                System.out.println("DeputadoDto. Email do deputado: " + listaDeputados.get(1).getEmail());
            }

            @Override
            public void onDeputadoError(String errorMessage) {
                // Lide com o erro aqui
                Log.e("DeputadoError", errorMessage);
            }
        });
    }

    public void abrirActivity(){
        Intent intent = new Intent(this, ListaDeputadoActivity.class);
        startActivity(intent);
    }

}