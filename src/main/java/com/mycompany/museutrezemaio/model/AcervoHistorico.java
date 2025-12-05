package com.mycompany.museutrezemaio.model;

import java.sql.Date;

public class AcervoHistorico {
    private int idItem;
    private String tipo;
    private String titulo;
    private String descricao;
    private Date dataItem;
    private String palavraChave;
    private String localOrigem;
    private String doador;
    private String caminhoDigitalizacao;
    
    public AcervoHistorico() {}
    
    public AcervoHistorico(int idItem, String tipo, String titulo, String descricao, Date dataItem, 
                          String palavraChave, String localOrigem, String doador, String caminhoDigitalizacao) {
        this.idItem = idItem;
        this.tipo = tipo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataItem = dataItem;
        this.localOrigem = localOrigem;
        this.doador = doador;
        this.caminhoDigitalizacao = caminhoDigitalizacao;
    }
    


    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataItem() {
        return dataItem;
    }

    public void setDataItem(Date dataItem) {
        this.dataItem = dataItem;
    }

    public String getLocalOrigem() {
        return localOrigem;
    }

    public void setLocalOrigem(String localOrigem) {
        this.localOrigem = localOrigem;
    }

    public String getDoador() {
        return doador;
    }

    public void setDoador(String doador) {
        this.doador = doador;
    }

    public String getCaminhoDigitalizacao() {
        return caminhoDigitalizacao;
    }

    public void setCaminhoDigitalizacao(String caminhoDigitalizacao) {
        this.caminhoDigitalizacao = caminhoDigitalizacao;
    }
    

    
    @Override
    public String toString() {
        return titulo + " (" + tipo + ") - " + dataItem;
    }
}