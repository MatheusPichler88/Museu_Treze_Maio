package com.mycompany.museutrezemaio.DAO;

import com.mycompany.museutrezemaio.Connection.Conexao;
import com.mycompany.museutrezemaio.model.AcervoHistorico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AcervoHistoricoDAO {
    private Conexao conexao;
    private Connection conn;
    
    public AcervoHistoricoDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    // Método Inserir Acervo
    public void inserir(AcervoHistorico a) {
        String sql = "INSERT INTO acervo_historico(tipo, titulo, descricao, data_item, " +
                    "local_origem, doador, caminho_digitalizacao) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, a.getTipo());
            stmt.setString(2, a.getTitulo());
            stmt.setString(3, a.getDescricao());
            stmt.setDate(4, a.getDataItem());
            stmt.setString(5, a.getLocalOrigem());
            stmt.setString(6, a.getDoador());
            stmt.setString(7, a.getCaminhoDigitalizacao());
            stmt.executeUpdate();
            System.out.println("Item do acervo inserido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir item do acervo: " + e.getMessage());
            e.printStackTrace();
        }
    }
        // Método Listar Acervo
    public ArrayList<AcervoHistorico> getAcervo() {
        String sql = "SELECT * FROM acervo_historico ORDER BY data_item DESC;";
        ArrayList<AcervoHistorico> acervo = new ArrayList<>();
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                AcervoHistorico a = new AcervoHistorico(
                    rs.getInt("id_item"),
                    rs.getString("tipo"),
                    rs.getString("titulo"),
                    rs.getString("descricao"),
                    rs.getDate("data_item"),
                        null,
                    rs.getString("local_origem"),
                    rs.getString("doador"),
                    rs.getString("caminho_digitalizacao")
                );
                acervo.add(a);
            }
            return acervo;
        } catch (Exception e) {
            System.out.println("Erro ao consultar acervo: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
        // Método Excluir acervo
    public void excluir(int id) {
        String sql = "DELETE FROM acervo_historico WHERE id_item = ?;";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            System.out.println("Item excluído do acervo!");
        } catch (Exception e) {
            System.out.println("Erro ao excluir item do acervo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}