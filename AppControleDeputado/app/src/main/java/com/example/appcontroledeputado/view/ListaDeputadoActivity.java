package com.example.appcontroledeputado.view;

import static com.example.appcontroledeputado.utils.Globais.listaDespesas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toolbar;

import com.example.appcontroledeputado.R;
import com.example.appcontroledeputado.adapter.DeputadoAdapter;
import com.example.appcontroledeputado.controller.DeputadoController;
import com.example.appcontroledeputado.dto.DadosDeputado;
import com.example.appcontroledeputado.dto.DespesaDto;
import com.example.appcontroledeputado.utils.Globais;

import java.util.ArrayList;

public class ListaDeputadoActivity extends AppCompatActivity {

    ListView lvDeputados;
    private Handler handler = new Handler(Looper.getMainLooper());

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_deputado);

        lvDeputados = findViewById(R.id.lvDeputados);

        atualizaLista(Globais.listaDeputados);

        lvDeputados.setOnItemClickListener((parent, view, position, id) -> {
            DadosDeputado dadosDeputado = (DadosDeputado) lvDeputados.getItemAtPosition(position);
            exibirDespesaDeputado(dadosDeputado.getId());
        });
    }

    private void exibirDespesaDeputado(long id) {
        DeputadoController.getDespesas(id, this, new DeputadoController.DespesaCallback() {
            @Override
            public void onDespesaDtoReceived(DespesaDto despesaDto) {
                listaDespesas = new ArrayList<>();
                listaDespesas.addAll(despesaDto.getDados());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        abrirActivity();
                    }
                });
            }

            @Override
            public void onDespesaDtoError(String errorMessage) {
                Log.e("DespesaError", errorMessage);
            }
        });
    }

    private void atualizaLista(ArrayList<DadosDeputado> lista) {
        DeputadoAdapter adapter = new DeputadoAdapter(this, lista);
        lvDeputados.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void abrirActivity() {
        Intent intent = new Intent(this, ListaDespesaActivity.class);
        startActivity(intent);
    }
}
