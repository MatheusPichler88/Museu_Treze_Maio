package com.mycompany.museutrezemaio.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Emprestimo {
    private int idEmprestimo;
    private int idMaterial;
    private int idUsuario;
    private Timestamp dataEmprestimo;
    private Date dataDevolucaoPrevista;
    private Date dataDevolucaoReal;
    private String statusEmprestimo;
    
    public Emprestimo() {}
    
    public Emprestimo(int idEmprestimo, int idMaterial, int idUsuario, Timestamp dataEmprestimo, 
                     Date dataDevolucaoPrevista, Date dataDevolucaoReal, String statusEmprestimo) {
        this.idEmprestimo = idEmprestimo;
        this.idMaterial = idMaterial;
        this.idUsuario = idUsuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.dataDevolucaoReal = dataDevolucaoReal;
        this.statusEmprestimo = statusEmprestimo;
    }
    
    public Emprestimo(int idMaterial, int idUsuario, Date dataDevolucaoPrevista, String statusEmprestimo) {
        this.idMaterial = idMaterial;
        this.idUsuario = idUsuario;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.statusEmprestimo = statusEmprestimo;
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Timestamp getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Timestamp dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(Date dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public Date getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public void setDataDevolucaoReal(Date dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    public String getStatusEmprestimo() {
        return statusEmprestimo;
    }

    public void setStatusEmprestimo(String statusEmprestimo) {
        this.statusEmprestimo = statusEmprestimo;
    }
    

    
    @Override
    public String toString() {
        return "Empréstimo #" + idEmprestimo + " - Status: " + statusEmprestimo;
    }
}