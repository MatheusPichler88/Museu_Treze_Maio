package com.mycompany.museutrezemaio.DAO;

import com.mycompany.museutrezemaio.Connection.Conexao;
import com.mycompany.museutrezemaio.model.MaterialBiblioteca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MaterialBibliotecaDAO {
    private Conexao conexao;
    private Connection conn;
    
    public MaterialBibliotecaDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(MaterialBiblioteca m) {
        String sql = "INSERT INTO materiais_biblioteca(tipo, titulo, id_autor, autor_desconhecido, " +
                    "ano_publicacao, id_categoria, descricao, isbn, editora, quantidade_exemplares, disponivel) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, m.getTipo());
            stmt.setString(2, m.getTitulo());
            
            if (m.getIdAutor() > 0) {
                stmt.setInt(3, m.getIdAutor());
            } else {
                stmt.setObject(3, null);
            }
            
            stmt.setString(4, m.getAutorDesconhecido());
            stmt.setInt(5, m.getAnoPublicacao());
            stmt.setInt(6, m.getIdCategoria());
            stmt.setString(7, m.getDescricao());
            stmt.setString(8, m.getIsbn());
            stmt.setString(9, m.getEditora());
            stmt.setInt(10, m.getQuantidadeExemplares());
            stmt.setBoolean(11, m.isDisponivel());
            stmt.executeUpdate();
            
            System.out.println("Material inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir material: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public ArrayList<MaterialBiblioteca> getMateriais() {
        String sql = "SELECT * FROM materiais_biblioteca ORDER BY titulo;";
        ArrayList<MaterialBiblioteca> materiais = new ArrayList<>();
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                MaterialBiblioteca m = new MaterialBiblioteca(
                    rs.getInt("id_material"),
                    rs.getString("tipo"),
                    rs.getString("titulo"),
                    rs.getInt("id_autor"),
                    rs.getString("autor_desconhecido"),
                    rs.getInt("ano_publicacao"),
                    rs.getInt("id_categoria"),
                    rs.getString("descricao"),
                    rs.getString("isbn"),
                    rs.getString("editora"),
                    rs.getInt("quantidade_exemplares"),
                    rs.getBoolean("disponivel")
                );
                materiais.add(m);
            }
            return materiais;
        } catch (Exception e) {
            System.out.println("Erro ao consultar materiais: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<MaterialBiblioteca> getMateriaisDisponiveis() {
        String sql = "SELECT * FROM materiais_biblioteca WHERE disponivel = 1 ORDER BY titulo;";
        ArrayList<MaterialBiblioteca> materiais = new ArrayList<>();
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                MaterialBiblioteca m = new MaterialBiblioteca(
                    rs.getInt("id_material"),
                    rs.getString("tipo"),
                    rs.getString("titulo"),
                    rs.getInt("id_autor"),
                    rs.getString("autor_desconhecido"),
                    rs.getInt("ano_publicacao"),
                    rs.getInt("id_categoria"),
                    rs.getString("descricao"),
                    rs.getString("isbn"),
                    rs.getString("editora"),
                    rs.getInt("quantidade_exemplares"),
                    rs.getBoolean("disponivel")
                );
                materiais.add(m);
            }
            return materiais;
        } catch (Exception e) {
            System.out.println("Erro ao consultar materiais disponíveis: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    public MaterialBiblioteca getMaterial(int idMaterial) {
        String sql = "SELECT * FROM materiais_biblioteca WHERE id_material = ?;";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idMaterial);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new MaterialBiblioteca(
                    rs.getInt("id_material"),
                    rs.getString("tipo"),
                    rs.getString("titulo"),
                    rs.getInt("id_autor"),
                    rs.getString("autor_desconhecido"),
                    rs.getInt("ano_publicacao"),
                    rs.getInt("id_categoria"),
                    rs.getString("descricao"),
                    rs.getString("isbn"),
                    rs.getString("editora"),
                    rs.getInt("quantidade_exemplares"),
                    rs.getBoolean("disponivel")
                );
            }
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao consultar material: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    public void atualizarDisponibilidade(int idMaterial, boolean disponivel) {
        String sql = "UPDATE materiais_biblioteca SET disponivel = ? WHERE id_material = ?;";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setBoolean(1, disponivel);
            stmt.setInt(2, idMaterial);
            System.out.println("Disponibilidade atualizada!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar disponibilidade: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void excluir(int id) {
    String sql = "DELETE FROM materiais_biblioteca WHERE id_material = ?;";
    
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        System.out.println("Material excluído!");
    } catch (Exception e) {
        System.out.println("Erro ao excluir material: " + e.getMessage());
        e.printStackTrace();
    }
}

public void atualizar(MaterialBiblioteca m) {
    String sql = "UPDATE materiais_biblioteca SET tipo=?, titulo=?, id_autor=?, autor_desconhecido=?, " +
                "ano_publicacao=?, id_categoria=?, descricao=?, isbn=?, editora=?, " +
                "quantidade_exemplares=?, disponivel=? WHERE id_material=?;";
    
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, m.getTipo());
        stmt.setString(2, m.getTitulo());
        
        if (m.getIdAutor() > 0) {
            stmt.setInt(3, m.getIdAutor());
        } else {
            stmt.setObject(3, null);
        }
        
        stmt.setString(4, m.getAutorDesconhecido());
        stmt.setInt(5, m.getAnoPublicacao());
        stmt.setInt(6, m.getIdCategoria());
        stmt.setString(7, m.getDescricao());
        stmt.setString(8, m.getIsbn());
        stmt.setString(9, m.getEditora());
        stmt.setInt(10, m.getQuantidadeExemplares());
        stmt.setBoolean(11, m.isDisponivel());
        stmt.setInt(12, m.getIdMaterial());
        
        System.out.println("Material atualizado!");
    } catch (Exception e) {
        System.out.println("Erro ao atualizar material: " + e.getMessage());
        e.printStackTrace();
    }
}
}