package com.mycompany.museutrezemaio.controller;

import com.mycompany.museutrezemaio.DAO.MaterialBibliotecaDAO;
import com.mycompany.museutrezemaio.model.MaterialBiblioteca;
import java.util.ArrayList;

public class MaterialBibliotecaController {
    private MaterialBibliotecaDAO materialDAO;
    
    public MaterialBibliotecaController() {
        this.materialDAO = new MaterialBibliotecaDAO();
    }
    
    public boolean cadastrarMaterial(String tipo, String titulo, String autor, 
                                    String autorDesconhecido, int ano, 
                                    int idCategoria, String isbn, String editora) {
        if (titulo == null || titulo.trim().isEmpty()) {
            return false;
        }
        
        MaterialBiblioteca material = new MaterialBiblioteca(
            tipo, titulo, 0, autorDesconhecido, ano, idCategoria, 
            "", isbn, editora, 1, true
        );
        
        try {
            materialDAO.inserir(material);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<MaterialBiblioteca> listarMateriais() {
        return materialDAO.getMateriais();
    }
    
    public ArrayList<MaterialBiblioteca> listarMateriaisDisponiveis() {
        return materialDAO.getMateriaisDisponiveis();
    }
    
    public boolean emprestarMaterial(int idMaterial) {
        try {
            materialDAO.atualizarDisponibilidade(idMaterial, false);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean devolverMaterial(int idMaterial) {
        try {
            materialDAO.atualizarDisponibilidade(idMaterial, true);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}