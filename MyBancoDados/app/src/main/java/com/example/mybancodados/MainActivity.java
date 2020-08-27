package com.example.mybancodados;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String NOME_BANCO_DADOS = "empresa.db";
    EditText txtNome, txtPrecos;
    Spinner Generos;
    Button idAdicione, idVisualizar;
    SQLiteDatabase meuBancoDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = findViewById(R.id.txtNome);
        txtPrecos = findViewById(R.id.txtPrecos);
        idAdicione = findViewById(R.id.idAdicione);
        idAdicione.setOnClickListener(this);
        idVisualizar.setOnClickListener(this);
        meuBancoDados = openOrCreateDatabase(NOME_BANCO_DADOS, MODE_PRIVATE, null);
        criarTabelaLivros();
        Toast.makeText(getApplicationContext(), "Livro adicionado com exito", Toast.LENGTH_SHORT);
    }

        private void criarTabelaLivros(){
        meuBancoDados.execSQL(
            "CREATE TABLE IF NOT EXISTS livros("+
                    "id integer PRIMARY KEY AUTOINCREMENT,"+
                    "nome varchar(150)NOT NULL,"+
                    "genero varchar(150)NOT NULL,"+
                    "dataEntrada datetime NOT NULL,"+
                    "preco double NOT NULL);"
    );
        }


    @Override
    public void onClick(View v) {
    }}



