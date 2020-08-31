package com.example.mybancodados;

import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Livros_Activity extends AppCompatActivity  {
    List<Livros>livrosList;
    LivrosAdapter livrosAdapter;
    SQLiteDatabase meuBancoDados;
   // listView listViewLivros;

    @Override
    protected void onCreate(Budle savedIdnstanceState){
        super.onCreate(savedIdnstanceState);
        setContentView(R.layout.livros_layout);

        listViewLivros= findViewById(R.id.listarLivrosView);
        livrosList = new ArrayList<>();
        meuBancoDados=openOrCreateDatabase(MainActivity.NOME_BANCO_DE_DADOS.null);

        visualizarLivrosDatabase();
    }
    private void visualizarLivrosDatabase(){

        Cursor cursorLivros = meuBancoDados.rawQuery("SELECT * FROM livros",null);

        if(cursorLivros.moveToFirst()){
            do{
                livrosList.add(new Livros(
                        cursorLivros.getInt(0),
                        cursorLivros.getString(1),
                        cursorLivros.getString(2),
                        cursorLivros.getString(3),
                        cursorLivros.getDouble(4)
                ));
            } while (cursorLivros.moveText());
        }
        cursorLivros.close();
        livrosAdapter = new LivrosAdapter(this,R.layout.list_view_livros,livrosList,meuBancoDados);
                listViewLivros.setAdapter(livrosAdapter);
    }

}