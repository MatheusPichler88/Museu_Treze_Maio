package com.mycompany.museutrezemaio.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public Connection getConexao() {
        // Tentando realizar a conexão com o Banco de Dados do SQLServer
        try {
            String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                                 + "databaseName=MuseuTrezeDeMaio;"
                                 + "user=sa;" 
                                 + "password=12345678;"
                                 + "encrypt=false;"
                                 + "trustServerCertificate=true;"
                                 + "loginTimeout=30;";
            
            Connection conn = DriverManager.getConnection(connectionUrl);
            System.out.println("Conexao realizada com o SQL Server");
            return conn;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar no SQL Server: " + e.getMessage());
            return null;
        }
    }
}