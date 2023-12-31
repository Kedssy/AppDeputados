package com.example.appcontroledeputado.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.appcontroledeputado.R;
import com.example.appcontroledeputado.dto.DadosDeputado;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class DeputadoAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<DadosDeputado> lista;

    public Context getContext() {
        return context;
    }

    public ArrayList<DadosDeputado> getLista() {
        return lista;
    }

    public DeputadoAdapter(Context context, ArrayList<DadosDeputado> lista) {
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
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_lista_deputado, parent, false);
        }

        DadosDeputado dadosDeputado = lista.get(position);
        TextView tvNomeDeputado = convertView.findViewById(R.id.tvNomeDeputado);
        TextView tvPartido = convertView.findViewById(R.id.tvPartido);
        TextView tvIdDeputado = convertView.findViewById(R.id.tvIdDeputado);
        CircleImageView avatarImageView = convertView.findViewById(R.id.avatarImageView);

        tvNomeDeputado.setText(dadosDeputado.getNome());
        tvPartido.setText(dadosDeputado.getSiglaPartido());
        tvIdDeputado.setText(String.valueOf(dadosDeputado.getId()));
        Glide.with(getContext().getApplicationContext())
                .load(dadosDeputado.getUrlFoto())
                .placeholder(R.drawable.default_avatar)
                .error(R.drawable.default_avatar)
                .into(avatarImageView);


        return convertView;

    }
}
