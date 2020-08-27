package com.example.mybancodados;

public class Livros {
    private String id;
    private String Nome;
    private String Genero;
    private String dataEntrada;
    private Integer Preco;

    public Livros(){
    }

    public Livros(String id, String nome, String genero, String dataEntrada, Integer preco) {
        this.id = id;
        Nome = nome;
        Genero = genero;
        this.dataEntrada = dataEntrada;
        Preco = preco;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Integer getPreco() {
        return Preco;
    }

    public void setPreco(Integer preco) {
        Preco = preco;
    }
}
