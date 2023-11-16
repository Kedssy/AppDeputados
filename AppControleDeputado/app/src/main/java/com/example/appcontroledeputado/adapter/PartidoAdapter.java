package com.example.appcontroledeputado.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appcontroledeputado.R;
import com.example.appcontroledeputado.dto.DadosPartido;

import java.util.ArrayList;

public class PartidoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<DadosPartido> lista;

    public PartidoAdapter(Context context, ArrayList<DadosPartido> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_lista_partido, parent, false);
        }

        DadosPartido dadosPartido = lista.get(position);
        TextView tvNomePartido = convertView.findViewById(R.id.tvNomePartido);
        TextView tvSigla = convertView.findViewById(R.id.tvSigla);

        tvNomePartido.setText("Nome: "+dadosPartido.getNome());
        tvSigla.setText("Sigla: "+dadosPartido.getSigla());

        return convertView;
    }
}
