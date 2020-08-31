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
    Button Adicione, idVisualizar;
    SQLiteDatabase meuBancoDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = findViewById(R.id.txtNome);
        txtPrecos = findViewById(R.id.txtPrecos);
        Adicione = findViewById(R.id.Adicione);
        Adicione.setOnClickListener(this);
        idVisualizar.setOnClickListener(this);
        meuBancoDados = openOrCreateDatabase(NOME_BANCO_DADOS, MODE_PRIVATE, null);
        criarTabelaLivros();
        Toast.makeText(getApplicationContext(), "Livro adicionado com exito", Toast.LENGTH_SHORT);

    }private boolean verificarEntrada(String nome, String preco) {
        if(nome.isEmpty()){
            txtEditarLivro.setError("Nome está vazio!");
            txtEditarLivro.requestFocus();
            return false;
        }

        if(preco.isEmpty()){
            txtEditarPreco.setErro("Esta sem preço");
            txtEditarPreco.requestFocus();
            return false;
        }
        return true;
    }
    private void adiconarLivros(){

        String nomeLiv = txtNomeLivro.getText().toString().trim();
        String precoLiv = txtPrecos.getText().toString().trim();
        String generoLiv = Generos.getSelectedItem().toString();

        // obtendo o horário atual para data de inclusão

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String dataEntrada = simpleDateFormat.format(calendar.getTime());
        if (verificarEntrada(nomeEmpr, salarioEmpr)) {

            String insertSQL = "INSERT INTO funcionarios (" +
                    "nome, " +
                    "genero, " +
                    "dataEntrada," +
                    "preco)" +
                    "VALUES(?, ?, ?, ?);";


            meuBancoDeDados.execSQL(insertSQL, new String[]{nomeLiv, generoLiv, dataEntrada, precoLiv});

            Toast.makeText(getApplicationContext(), "Livro adiconado com exito!!!", Toast.LENGTH_SHORT).show();
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
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.Adicione:
                    adicioneLivros();
                    break;
                case R.id.Visualizar:
                    startActivity(new Intent(getApplicationContext(), Funcionarios_Activity.class));
                    break;
            }

        }
    }