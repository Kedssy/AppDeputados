package com.example.appcontroledeputado.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appcontroledeputado.R;
import com.example.appcontroledeputado.adapter.DeputadoAdapter;
import com.example.appcontroledeputado.adapter.DespesaAdapter;
import com.example.appcontroledeputado.dto.DadosDeputado;
import com.example.appcontroledeputado.dto.DadosDespesa;
import com.example.appcontroledeputado.utils.Globais;

import java.util.ArrayList;

public class ListaDespesaActivity extends AppCompatActivity {
    private ListView lvDespesas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_despesa);

        lvDespesas = findViewById(R.id.lvDespesas);

        atualizaLista(Globais.listaDespesas);

        lvDespesas.setOnItemClickListener(null);
    }

    private void atualizaLista(ArrayList<DadosDespesa> lista){
        DespesaAdapter adapter =
                new DespesaAdapter(this, lista);
        lvDespesas.setAdapter(adapter);


    }
}