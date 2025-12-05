package com.mycompany.museutrezemaio.controller;

import com.mycompany.museutrezemaio.DAO.EmprestimoDAO;
import com.mycompany.museutrezemaio.DAO.MaterialBibliotecaDAO;
import com.mycompany.museutrezemaio.DAO.UsuarioDAO;
import com.mycompany.museutrezemaio.model.Emprestimo;
import java.sql.Date;
import java.util.ArrayList;

public class EmprestimoController {
    private EmprestimoDAO emprestimoDAO;
    private MaterialBibliotecaDAO materialDAO;
    private UsuarioDAO usuarioDAO;
    
    public EmprestimoController() {
        this.emprestimoDAO = new EmprestimoDAO();
        this.materialDAO = new MaterialBibliotecaDAO();
        this.usuarioDAO = new UsuarioDAO();
    }
    
    public boolean realizarEmprestimo(int idMaterial, int idUsuario, Date dataDevolucaoPrevista) {
        if (materialDAO.getMaterial(idMaterial) == null) {
            return false;
        }
        
        if (!materialDAO.getMaterial(idMaterial).isDisponivel()) {
            return false;
        }
        
        if (usuarioDAO.getUsuario(idUsuario) == null) {
            return false;
        }
        
        Emprestimo emprestimo = new Emprestimo(
            idMaterial, idUsuario, dataDevolucaoPrevista, "Ativo"
        );
        
        try {
            emprestimoDAO.inserir(emprestimo);
            materialDAO.atualizarDisponibilidade(idMaterial, false);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Emprestimo> listarEmprestimosAtivos() {
        return emprestimoDAO.getEmprestimosAtivos();
    }
    
    public boolean registrarDevolucao(int idEmprestimo, int idMaterial) {
        try {
            emprestimoDAO.registrarDevolucao(idEmprestimo);
            materialDAO.atualizarDisponibilidade(idMaterial, true);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}