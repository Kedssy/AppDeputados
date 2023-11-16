package com.example.appcontroledeputado.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.appcontroledeputado.R;
import com.example.appcontroledeputado.dto.DadosPartidoComplete;

public class PartidoCompleteAdapter extends BaseAdapter {

    private Context context;
    private DadosPartidoComplete dadosPartidoComplete;

    public PartidoCompleteAdapter(Context context, DadosPartidoComplete dadosPartidoComplete) {
        this.context = context;
        this.dadosPartidoComplete = dadosPartidoComplete;
    }

    @Override
    public int getCount() {
        return dadosPartidoComplete != null ? 1 : 0;
    }

    @Override
    public Object getItem(int position) {
        return dadosPartidoComplete;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_complete_partido, parent, false);
        }

        DadosPartidoComplete dadosComplete = dadosPartidoComplete;
        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView tvSigla = convertView.findViewById(R.id.tvSigla);
        TextView tvNomePartido = convertView.findViewById(R.id.tvNomePartido);
        TextView tvTotalMembros = convertView.findViewById(R.id.tvTotalMembros);
        TextView tvNomeLider = convertView.findViewById(R.id.tvNomeLider);
        ImageView imageLider = convertView.findViewById(R.id.imageLider);

        tvSigla.setText("Sigla: "+dadosComplete.getSigla());
        tvNomePartido.setText("Nome: "+dadosComplete.getNome());
        tvTotalMembros.setText("Total de membros: "+dadosComplete.getStatus().getTotalMembros());
        tvNomeLider.setText("Nome: "+dadosComplete.getStatus().getLider().getNome());

        // Carrega a imagem do partido
        Glide.with(context.getApplicationContext())
                .load(dadosPartidoComplete.getUrlLogo())
                .placeholder(R.drawable.default_avatar)
                .error(R.drawable.default_avatar)
                .into(imageView);

        // Carrega a imagem do líder
        Glide.with(context.getApplicationContext())
                .load(dadosPartidoComplete.getStatus().getLider().getUrlFoto())
                .placeholder(R.drawable.default_avatar)
                .error(R.drawable.default_avatar)
                .into(imageLider);

        return convertView;
    }
}
