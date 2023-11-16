package com.example.appcontroledeputado.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.appcontroledeputado.R;
import com.example.appcontroledeputado.adapter.PartidoAdapter;
import com.example.appcontroledeputado.controller.PartidoController;
import com.example.appcontroledeputado.dto.DadosPartido;
import com.example.appcontroledeputado.dto.DadosPartidoComplete;
import com.example.appcontroledeputado.dto.PartidoCompleteDto;
import com.example.appcontroledeputado.utils.Globais;

import java.util.ArrayList;

public class ListaPartidoActivity extends AppCompatActivity {

    ListView lvPartidos;
    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_partido);
        lvPartidos = findViewById(R.id.lvPartidos);

        atualizaLista(Globais.listaPartidos);

        lvPartidos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DadosPartido dadosPartido = (DadosPartido) lvPartidos.getItemAtPosition(position);
                exibirPartido(dadosPartido.getId());
            }
        });

    }

    private void exibirPartido(long id) {
        PartidoController.getPartidoById(id, this, new PartidoController.PartidoCompleteCallback() {
            @Override
            public void onPartidoDtoReceived(PartidoCompleteDto partidoCompleteDto) {
                Globais.dadosPartidoComplete = new DadosPartidoComplete();

                Globais.dadosPartidoComplete.setNome(partidoCompleteDto.getDados().getNome());
                Globais.dadosPartidoComplete.setSigla(partidoCompleteDto.getDados().getSigla());
                Globais.dadosPartidoComplete.setId(partidoCompleteDto.getDados().getId());
                Globais.dadosPartidoComplete.setUrlLogo(partidoCompleteDto.getDados().getUrlLogo());
                Globais.dadosPartidoComplete.setStatus(partidoCompleteDto.getDados().getStatus());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        abrirActivity();
                    }
                });
            }

            @Override
            public void onPartidoError(String errorMessage) {
                Log.e("DespesaError", errorMessage);
            }
        });
    }

    public void abrirActivity() {
        Intent intent = new Intent(this, PartidoCompleteActivity.class);
        startActivity(intent);
    }

    private void atualizaLista(ArrayList<DadosPartido> lista) {
        PartidoAdapter adapter = new PartidoAdapter(this, lista);
        lvPartidos.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}