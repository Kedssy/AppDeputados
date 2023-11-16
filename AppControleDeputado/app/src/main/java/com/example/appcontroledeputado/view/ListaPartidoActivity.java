package com.example.appcontroledeputado.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.appcontroledeputado.R;
import com.example.appcontroledeputado.adapter.DeputadoAdapter;
import com.example.appcontroledeputado.adapter.PartidoAdapter;
import com.example.appcontroledeputado.dto.DadosDeputado;
import com.example.appcontroledeputado.dto.DadosPartido;
import com.example.appcontroledeputado.utils.Globais;

import java.util.ArrayList;

public class ListaPartidoActivity extends AppCompatActivity {

    ListView lvPartidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_partido);
        lvPartidos = findViewById(R.id.lvPartidos);

        atualizaLista(Globais.listaPartidos);

    }

    private void atualizaLista(ArrayList<DadosPartido> lista) {
        PartidoAdapter adapter = new PartidoAdapter(this, lista);
        lvPartidos.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}