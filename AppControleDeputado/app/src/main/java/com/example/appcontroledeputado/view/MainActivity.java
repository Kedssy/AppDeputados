package com.example.appcontroledeputado.view;

import static com.example.appcontroledeputado.utils.Globais.listaDeputados;
import static com.example.appcontroledeputado.utils.Globais.listaDespesas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.appcontroledeputado.R;
import com.example.appcontroledeputado.controller.DeputadoController;
import com.example.appcontroledeputado.dto.DadosDespesa;
import com.example.appcontroledeputado.dto.DeputadoDto;
import com.example.appcontroledeputado.dto.DespesaDto;

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

                listaDeputados = new ArrayList<>();
                listaDespesas = new ArrayList<>();

                listaDeputados.addAll(deputadoDto.getDados());

                System.out.println("DeputadoDto. Email do deputado: " + listaDeputados.get(1).getEmail());
                getDespesasByDeputadoId(listaDeputados.get(1).getId());
            }

            @Override
            public void onDeputadoError(String errorMessage) {
                Log.e("DeputadoError", errorMessage);
            }
        });


    }



    public void abrirActivity(){
        Intent intent = new Intent(this, ListaDeputadoActivity.class);
        startActivity(intent);
    }

    public void getDespesasByDeputadoId(long id){
        DeputadoController.getDespesas(id, this, new DeputadoController.DespesaCallback() {
            @Override
            public void onDespesaDtoReceived(DespesaDto despesaDto) {
                listaDespesas.addAll(despesaDto.getDados());
                System.out.println("LISTA DE DESPESA, NOME DO FORNECEDOR: " + listaDespesas.get(1).getNomeFornecedor());
            }

            @Override
            public void onDespesaDtoError(String errorMessage) {
                Log.e("DespesaError", errorMessage);
            }


        });
    }

}