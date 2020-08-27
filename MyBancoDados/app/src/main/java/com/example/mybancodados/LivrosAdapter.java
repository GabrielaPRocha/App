package com.example.mybancodados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class LivrosAdapter extends BaseAdapter {
    Context mCtx;
    int listaLayoutRes;
    List<Livros> listaLivros;
    SQLiteDatabase meuBancoDados;

    public LivrosAdapter(Context mCtx, List<Livros> listaLivros, SQLiteDatabase meuBancoDados) {
        this.mCtx = mCtx;
        this.listaLivros = listaLivros;
        this.meuBancoDados = meuBancoDados;
    }
    public LivrosAdapter(int position,@NonNull View convertView,@NonNull ViewGroup parent) {
        super(context,resource);
        this.mCtx = mCtx;
        this.listaLayoutRes = listaLayoutRes;
        this.listaLivros = listaLivros;
        this.meuBancoDados = meuBancoDados;
    }

    @NonNull
    @Override
    public View getView(int position,@NonNull View convertView,@NonNull ViewGroup parent){
        LayoutInflater inflater =LayoutInflater.from(mCtx);
        View view = inflater.inflate(listaLayoutRes, null);
        final Livros livros=listaLivros.get(position);
        TextView textViewidSebo=view.findViewById(R.id.idSebo);
        TextView textViewtxtNome=view.findViewById(R.id.txtNome);
        TextView textViewtxtPreco=view.findViewById(R.id.txtPrecos);
        TextView textViewdataEntrada=view.findViewById(R.id.dataEntrada);

    }


    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
