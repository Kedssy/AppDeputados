package com.example.appcontroledeputado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.appcontroledeputado.controller.DeputadoController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DeputadoController.executarAPI(null);
    }
}