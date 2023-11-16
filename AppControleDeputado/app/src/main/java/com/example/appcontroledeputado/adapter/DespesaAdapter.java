package com.example.appcontroledeputado.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appcontroledeputado.R;
import com.example.appcontroledeputado.dto.DadosDespesa;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DespesaAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<DadosDespesa> lista;

    public DespesaAdapter(Context context, ArrayList<DadosDespesa> lista) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_lista_despesa, parent, false);
        }
        DadosDespesa dadosDespesa = lista.get(position);
        TextView tvTipoDespesa = convertView.findViewById(R.id.tvTipoDespesa);
        TextView tvValorDocumento = convertView.findViewById(R.id.tvValorDocumento);
        TextView tvNomeFornecedor = convertView.findViewById(R.id.tvNomeFornecedor);
        TextView tvDataDocumento = convertView.findViewById(R.id.tvDataDocumento);

        tvDataDocumento.setText(dadosDespesa.getDataDocumento());
        tvTipoDespesa.setText(dadosDespesa.getTipoDespesa());
        tvNomeFornecedor.setText(dadosDespesa.getNomeFornecedor());
        tvValorDocumento.setText(String.valueOf("R$"+dadosDespesa.getValorDocumento()));

        return convertView;

    }
}
