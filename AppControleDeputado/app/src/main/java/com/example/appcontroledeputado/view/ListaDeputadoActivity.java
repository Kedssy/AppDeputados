package com.example.appcontroledeputado.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.appcontroledeputado.R;
import com.example.appcontroledeputado.adapter.DeputadoAdapter;
import com.example.appcontroledeputado.dto.DadosDeputado;
import com.example.appcontroledeputado.utils.Globais;

import java.util.ArrayList;

public class ListaDeputadoActivity extends AppCompatActivity {

    ListView lvDeputados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_deputado);

        lvDeputados = findViewById(R.id.lvDeputados);

        atualizaLista(Globais.listaDeputados);


    }

    private void atualizaLista(ArrayList<DadosDeputado> lista){
        DeputadoAdapter adapter =
                new DeputadoAdapter(this, lista);
        lvDeputados.setAdapter(adapter);
    }
}