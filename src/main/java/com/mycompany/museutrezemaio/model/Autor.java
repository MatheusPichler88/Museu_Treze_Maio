package com.mycompany.museutrezemaio.model;

import java.sql.Date;

public class Autor {
    private int idAutor;
    private String nome;
    private String nacionalidade;
    private Date dataNascimento;
    
    public Autor() {}
    
    public Autor(int idAutor, String nome, String nacionalidade, Date dataNascimento) {
        this.idAutor = idAutor;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
    }
    
    public Autor(String nome, String nacionalidade, Date dataNascimento) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    

    
    @Override
    public String toString() {
        return nome + " - " + nacionalidade;
    }
}