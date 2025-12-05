package com.mycompany.museutrezemaio.DAO;

import com.mycompany.museutrezemaio.Connection.Conexao;
import com.mycompany.museutrezemaio.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAO {
    private Conexao conexao;
    private Connection conn;
    
    public UsuarioDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Usuario u) {
        String sql = "INSERT INTO usuarios(nome, tipo, telefone, email, endereco) VALUES (?, ?, ?, ?, ?);";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getTipo());
            stmt.setString(3, u.getTelefone());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getEndereco());
            stmt.executeUpdate();
            
            System.out.println("Usuário inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir usuário: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public Usuario getUsuario(int idUsuario) {
        String sql = "SELECT * FROM usuarios WHERE id_usuario = ?;";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String nome = rs.getString("nome");
                String tipo = rs.getString("tipo");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String endereco = rs.getString("endereco");
                
                return new Usuario(idUsuario, nome, tipo, telefone, email, endereco);
            }
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao consultar usuário: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Usuario> getUsuarios() {
        String sql = "SELECT * FROM usuarios ORDER BY nome;";
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String nome = rs.getString("nome");
                String tipo = rs.getString("tipo");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String endereco = rs.getString("endereco");
                
                Usuario usuario = new Usuario(idUsuario, nome, tipo, telefone, email, endereco);
                usuarios.add(usuario);
            }
            return usuarios;
        } catch (Exception e) {
            System.out.println("Erro ao consultar usuários: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    public void atualizar(Usuario u) {
        String sql = "UPDATE usuarios SET nome=?, tipo=?, telefone=?, email=?, endereco=? WHERE id_usuario=?;";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getTipo());
            stmt.setString(3, u.getTelefone());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getEndereco());
            stmt.setInt(6, u.getIdUsuario());
            System.out.println("Usuário atualizado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void excluir(int idUsuario) {
        String sql = "DELETE FROM usuarios WHERE id_usuario=?;";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            System.out.println("Usuário excluído com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao excluir usuário: " + e.getMessage());
            e.printStackTrace();
        }
    }
}