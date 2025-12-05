package com.mycompany.museutrezemaio.model;

public class MaterialBiblioteca {
    private int idMaterial;
    private String tipo;
    private String titulo;
    private int idAutor;
    private String autorDesconhecido;
    private int anoPublicacao;
    private int idCategoria;
    private String descricao;
    private String isbn;
    private String editora;
    private int quantidadeExemplares;
    private boolean disponivel;
    
    public MaterialBiblioteca() {}
    
    public MaterialBiblioteca(int idMaterial, String tipo, String titulo, int idAutor, String autorDesconhecido, 
                             int anoPublicacao, int idCategoria, String descricao, String isbn, 
                             String editora, int quantidadeExemplares, boolean disponivel) {
        this.idMaterial = idMaterial;
        this.tipo = tipo;
        this.titulo = titulo;
        this.idAutor = idAutor;
        this.autorDesconhecido = autorDesconhecido;
        this.anoPublicacao = anoPublicacao;
        this.idCategoria = idCategoria;
        this.descricao = descricao;
        this.isbn = isbn;
        this.editora = editora;
        this.quantidadeExemplares = quantidadeExemplares;
        this.disponivel = disponivel;
    }
    
    // Construtor para inserção sem ID
    public MaterialBiblioteca(String tipo, String titulo, int idAutor, String autorDesconhecido, 
                             int anoPublicacao, int idCategoria, String descricao, String isbn, 
                             String editora, int quantidadeExemplares, boolean disponivel) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.idAutor = idAutor;
        this.autorDesconhecido = autorDesconhecido;
        this.anoPublicacao = anoPublicacao;
        this.idCategoria = idCategoria;
        this.descricao = descricao;
        this.isbn = isbn;
        this.editora = editora;
        this.quantidadeExemplares = quantidadeExemplares;
        this.disponivel = disponivel;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getAutorDesconhecido() {
        return autorDesconhecido;
    }

    public void setAutorDesconhecido(String autorDesconhecido) {
        this.autorDesconhecido = autorDesconhecido;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getQuantidadeExemplares() {
        return quantidadeExemplares;
    }

    public void setQuantidadeExemplares(int quantidadeExemplares) {
        this.quantidadeExemplares = quantidadeExemplares;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    

    
    @Override
    public String toString() {
        return titulo + " (" + tipo + ") - " + (disponivel ? "Disponível" : "Indisponível");
    }
}