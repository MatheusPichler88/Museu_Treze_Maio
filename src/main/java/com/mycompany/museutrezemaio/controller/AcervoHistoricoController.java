package com.mycompany.museutrezemaio.controller;

import com.mycompany.museutrezemaio.DAO.AcervoHistoricoDAO;
import com.mycompany.museutrezemaio.model.AcervoHistorico;
import java.sql.Date;
import java.util.ArrayList;

public class AcervoHistoricoController {
    
    private AcervoHistoricoDAO dao;
    
    public AcervoHistoricoController() {
        dao = new AcervoHistoricoDAO();
    }
    
    public boolean salvarItem(String tipo, String titulo, String descricao, 
                            Date data, String local, 
                            String doador, String arquivo) {
        

        if (titulo == null || titulo.trim().isEmpty()) {
            return false;
        }
        
        try {
            AcervoHistorico item = new AcervoHistorico();
            item.setTipo(tipo);
            item.setTitulo(titulo);
            item.setDescricao(descricao);
            item.setDataItem(data);
            item.setLocalOrigem(local);
            item.setDoador(doador);
            item.setCaminhoDigitalizacao(arquivo);
            
            dao.inserir(item);
            return true;
            
        } catch (Exception e) {
            System.out.println("Erro no Controller: " + e.getMessage());
            return false;
        }
    }
    
    public ArrayList<AcervoHistorico> buscarTodos() {
        try {
            return dao.getAcervo();
        } catch (Exception e) {
            System.out.println("Erro ao buscar todos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
     
    public boolean excluir(int id) {
        try {
            dao.excluir(id);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
            return false;
        }
    }
    
    public boolean tituloValido(String titulo) {
        return titulo != null && !titulo.trim().isEmpty();
    }
    
    public int contarItens() {
        try {
            return dao.getAcervo().size();
        } catch (Exception e) {
            return 0;
        }
    }
}