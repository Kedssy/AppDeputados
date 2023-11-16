package com.example.appcontroledeputado.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.appcontroledeputado.R;
import com.example.appcontroledeputado.adapter.DespesaAdapter;
import com.example.appcontroledeputado.adapter.PartidoCompleteAdapter;
import com.example.appcontroledeputado.dto.DadosDespesa;
import com.example.appcontroledeputado.dto.DadosPartidoComplete;
import com.example.appcontroledeputado.utils.Globais;

import java.util.ArrayList;

public class PartidoCompleteActivity extends AppCompatActivity {

    ListView lvComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partido_complete);

        lvComplete = findViewById(R.id.lvComplete);

        atualizaTela(Globais.dadosPartidoComplete);

    }

    private void atualizaTela(DadosPartidoComplete dadosPartidoComplete){
        PartidoCompleteAdapter adapter =
                new PartidoCompleteAdapter(this, dadosPartidoComplete);
        lvComplete.setAdapter(adapter);

    }
}