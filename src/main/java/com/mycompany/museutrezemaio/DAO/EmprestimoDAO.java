package com.mycompany.museutrezemaio.DAO;

import com.mycompany.museutrezemaio.Connection.Conexao;
import com.mycompany.museutrezemaio.model.Emprestimo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmprestimoDAO {
    private Conexao conexao;
    private Connection conn;
    
    public EmprestimoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
        
    public void inserir(Emprestimo e) {
        String sql = "INSERT INTO emprestimos(id_material, id_usuario, data_devolucao_prevista, status_emprestimo) " +
                    "VALUES (?, ?, ?, ?);";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, e.getIdMaterial());
            stmt.setInt(2, e.getIdUsuario());
            stmt.setDate(3, e.getDataDevolucaoPrevista());
            stmt.setString(4, e.getStatusEmprestimo());
            
            System.out.println("Empréstimo registrado com sucesso!");
        } catch (Exception ex) {
            System.out.println("Erro ao registrar empréstimo: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public ArrayList<Emprestimo> getEmprestimosAtivos() {
        String sql = "SELECT * FROM emprestimos WHERE status_emprestimo = 'Ativo' ORDER BY data_emprestimo DESC;";
        return getEmprestimos(sql);
    }
    
    public ArrayList<Emprestimo> getEmprestimosAtrasados() {
        String sql = "SELECT * FROM emprestimos WHERE status_emprestimo = 'Atrasado' ORDER BY data_devolucao_prevista;";
        return getEmprestimos(sql);
    }
    
    public ArrayList<Emprestimo> getEmprestimosPorUsuario(int idUsuario) {
        String sql = "SELECT * FROM emprestimos WHERE id_usuario = ? ORDER BY data_emprestimo DESC;";
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Emprestimo e = new Emprestimo(
                    rs.getInt("id_emprestimo"),
                    rs.getInt("id_material"),
                    rs.getInt("id_usuario"),
                    rs.getTimestamp("data_emprestimo"),
                    rs.getDate("data_devolucao_prevista"),
                    rs.getDate("data_devolucao_real"),
                    rs.getString("status_emprestimo")
                );
                emprestimos.add(e);
            }
            return emprestimos;
        } catch (Exception ex) {
            System.out.println("Erro ao consultar empréstimos do usuário: " + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
    
    private ArrayList<Emprestimo> getEmprestimos(String sql) {
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Emprestimo e = new Emprestimo(
                    rs.getInt("id_emprestimo"),
                    rs.getInt("id_material"),
                    rs.getInt("id_usuario"),
                    rs.getTimestamp("data_emprestimo"),
                    rs.getDate("data_devolucao_prevista"),
                    rs.getDate("data_devolucao_real"),
                    rs.getString("status_emprestimo")
                );
                emprestimos.add(e);
            }
            return emprestimos;
        } catch (Exception ex) {
            System.out.println("Erro ao consultar empréstimos: " + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
    
    public void registrarDevolucao(int idEmprestimo) {
        String sql = "UPDATE emprestimos SET data_devolucao_real = GETDATE(), status_emprestimo = 'Devolvido' " +
                    "WHERE id_emprestimo = ?;";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idEmprestimo);
            System.out.println("Devolução registrada com sucesso!");
        } catch (Exception ex) {
            System.out.println("Erro ao registrar devolução: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}