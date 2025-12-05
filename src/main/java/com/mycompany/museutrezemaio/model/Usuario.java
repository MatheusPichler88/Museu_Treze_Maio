package com.mycompany.museutrezemaio.model;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String tipo;
    private String telefone;
    private String email;
    private String endereco;
    
    public Usuario() {}
    
    public Usuario(int idUsuario, String nome, String tipo, String telefone, String email, String endereco) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.tipo = tipo;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }
    
    public Usuario(String nome, String tipo, String telefone, String email, String endereco) {
        this.nome = nome;
        this.tipo = tipo;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    @Override
    public String toString() {
        return nome + " (" + tipo + ")";
    }
}