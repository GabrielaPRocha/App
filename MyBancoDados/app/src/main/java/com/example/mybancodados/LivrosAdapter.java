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

public class LivrosAdapter extends ArrayAdapter<livros> {
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
        TextView textViewtxtNomedosLivros=view.findViewById(R.id.txtNomedosLivros);
        TextView textViewtxtNome=view.findViewById(R.id.txtNome);
        TextView textViewtxtPreco=view.findViewById(R.id.txtPrecos);
        TextView textViewdataEntrada=view.findViewById(R.id.dataEntrada);

        txtViewidSebo.setText(livros.getidSebo());
        textViewtxtPrecos.setText(livros.gettxtPrecos());
        textViewtxtNome.setText(livros.gettxtNome());
        textViewdataEntrada.setText(livros.getDataEntrada());

        Button btnExcluir=view.findViewbyId(R.id.Excluir());
        Button btnEditar=view.findViewbyId(R.id.Editar());

        btnEditar.setOnClickListener((view) {alterarLivros(livros);});
        btnExcluir.setOnClickListener((view){
            AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);
            builder.setTitle("Deseja excluir?");
            builder.setIcon(android.R.drawable.ic_delete);
            builder.setPositiveButton("Sim", new DialogInterface.onClickListner(){
                public void onCLick(DialogInterface dialogInterface,int i) {
                    String sql = "DELETE FROM livros WHERE id=?";
                    meuBancoDados.execSQL(sql, new Integer[]{livros.getId()});
                    recarregarLivrosDB();
                }
            });
            builder.setNegativeButton("Cancelar",(dialogInterface,i)) {
            public void onCLick(DialogInterface dialogInterface,int i){

            }
        });
            AlertDialog dialog=builder.create();
            dialog.show();
        }
    });
        return view;
}
    public void alterarlivro(final Livros livros) {
    final AlertDialog.Builder builder = new AlertDialog

        LayoutInflater inflater =LayoutInflater.from(mCtx);

    View view = inflater.inflater(R.layout.caixa_alterar_livro,null);
    builder.setView(View);
    final EditText txtEditarLivro = view.findViewById(R.id.txtEditarLivro);
    final EditText txtEditarPreco = view.findViewById(R.id.txtEditarPreco);
    final Spinenr Generos=view.findViewById(R.id.Generos);

    txtEditarLivro.setText(livros.getNome());
    txtEditarPreco.setText(String.valuetOf(livros.getPreco()));

    final AlertDialog dialog = builder.create();
    dialog.show();

        view.findViewById(R.id.btnAlteraLivro).setOnClickListener((view){
            String nome= txtEditarLivro.getText().toString().trim();
            String preco= txtEditarPreco.getText().toString().trim();
        String genero= Generos.getSelectedItem().toString().trim();

            if(nome.isEmpty()){
                txtEditarLivro.setError("Nome está vazio!");
                txtEditarLivro.requestFocus();
            }
            if(preco.isEmpty()){
                txtEditarPreco.setErro("Esta sem preço");
                txtEditarPreco.requestFocus();
                return;
            }
            String sql ="UPDATE livros SET nome=?, genero=?, preco =? ";
            meuBancoDados.execSQL(sql,
            new String[]{nome,genero,preco, String.valueOf(livros.getId()Toast.makeText(mCtx,"Livro alterado com exito",Toast.LENGTH_LONG).show();

                    recarregarLivrosDB();
                dialog.dismiss();
                });
        }
        public void recaregarLivrosDB(){
            Cursor cursosLivros= meuBancoDados.rawQuery("SELECT * FROM livros", null )
            if (cursorLivros.moveToFirst()) {
                listaLivros.clear();
                do {
                    listaLivros.add(new Livros(
                            cursorLivros.getInt(0),
                            cursorLivros.getString(1),
                            cursorLivros.getString(2),
                            cursorLivros.getString(3),
                            cursorLivros.getDouble(4)
                    ));
                } while (cursorLivros.moveToNext());
            }
            cursorlivros.close();
            notifyDataSetChanged();
        }
    }