package com.mycompany.museutrezemaio.controller;

import com.mycompany.museutrezemaio.DAO.UsuarioDAO;
import com.mycompany.museutrezemaio.model.Usuario;
import java.util.ArrayList;

public class UsuarioController {
    private UsuarioDAO usuarioDAO;
    
    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }
    
    public boolean cadastrarUsuario(String nome, String tipo, String telefone, 
                                   String email, String endereco) {
        if (nome == null || nome.trim().isEmpty() || 
            telefone == null || telefone.trim().isEmpty()) {
            return false; 
        }
        
        Usuario usuario = new Usuario(nome, tipo, telefone, email, endereco);
        try {
            usuarioDAO.inserir(usuario);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Usuario> listarUsuarios() {
        return usuarioDAO.getUsuarios();
    }
    
    public ArrayList<Usuario> buscarUsuarioPorNome(String nome) {
        ArrayList<Usuario> todos = usuarioDAO.getUsuarios();
        ArrayList<Usuario> resultado = new ArrayList<>();
        
        for (Usuario u : todos) {
            if (u.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultado.add(u);
            }
        }
        return resultado;
    }
    
    public boolean excluirUsuario(int id) {
        try {
            usuarioDAO.excluir(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Usuario buscarUsuarioPorId(int id) {
        return usuarioDAO.getUsuario(id);
    }
}