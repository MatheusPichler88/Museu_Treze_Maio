/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.museutrezemaio.view;

import com.mycompany.museutrezemaio.model.MaterialBiblioteca;
import com.mycompany.museutrezemaio.DAO.MaterialBibliotecaDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 *
 * @author mathe
 */
public class ConsultarMaterial extends javax.swing.JFrame {
    
    /**
     * Creates new form ConsultarMaterial
     */
    public ConsultarMaterial() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        configurarTabela();
        carregarTodosMateriais();
    }
    
    private void configurarTabela() {
        // Criar modelo de tabela
        String[] colunas = {"ID", "Título", "Tipo", "Disponível"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tabelaMateriais.setModel(modelo);
    }
    
    private void carregarTodosMateriais() {
        try {
            // Limpa tabela
            DefaultTableModel modelo = (DefaultTableModel) tabelaMateriais.getModel();
            modelo.setRowCount(0);
            
            // Busca no banco
            MaterialBibliotecaDAO dao = new MaterialBibliotecaDAO();
            ArrayList<MaterialBiblioteca> lista = dao.getMateriais();
            
            // Adiciona na tabela
            for (MaterialBiblioteca m : lista) {
                String disponivel = m.isDisponivel() ? "Sim" : "Não";
                Object[] linha = {
                    m.getIdMaterial(),
                    m.getTitulo(),
                    m.getTipo(),
                    disponivel
                };
                modelo.addRow(linha);
            }
            
            // Mostra quantos materiais tem
            lblTotal.setText("Total: " + lista.size() + " materiais");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }
    
    private void carregarMateriaisDisponiveis() {
        try {
            // Limpa tabela
            DefaultTableModel modelo = (DefaultTableModel) tabelaMateriais.getModel();
            modelo.setRowCount(0);
            
            // Busca no banco apenas os disponíveis
            MaterialBibliotecaDAO dao = new MaterialBibliotecaDAO();
            ArrayList<MaterialBiblioteca> lista = dao.getMateriaisDisponiveis();
            
            // Adiciona na tabela
            for (MaterialBiblioteca m : lista) {
                Object[] linha = {
                    m.getIdMaterial(),
                    m.getTitulo(),
                    m.getTipo(),
                    "Sim"
                };
                modelo.addRow(linha);
            }
            
            lblTotal.setText("Disponíveis: " + lista.size() + " materiais");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }
    
    private void buscarPorTitulo() {
        String busca = txtBuscar.getText().trim();
        
        if (busca.isEmpty()) {
            carregarTodosMateriais();
            return;
        }
        
        try {
            // Limpa tabela
            DefaultTableModel modelo = (DefaultTableModel) tabelaMateriais.getModel();
            modelo.setRowCount(0);
            
            // Busca todos
            MaterialBibliotecaDAO dao = new MaterialBibliotecaDAO();
            ArrayList<MaterialBiblioteca> lista = dao.getMateriais();
            
            int encontrados = 0;
            
            // Filtrar por título
            for (MaterialBiblioteca m : lista) {
                if (m.getTitulo().toLowerCase().contains(busca.toLowerCase())) {
                    String disponivel = m.isDisponivel() ? "Sim" : "Não";
                    modelo.addRow(new Object[]{
                        m.getIdMaterial(),
                        m.getTitulo(),
                        m.getTipo(),
                        disponivel
                    });
                    encontrados++;
                }
            }
            
            lblTotal.setText("Encontrados: " + encontrados + " materiais");
            
            if (encontrados == 0) {
                JOptionPane.showMessageDialog(this, "Nenhum material encontrado!");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }
    
    private void verDetalhes() {
        int linha = tabelaMateriais.getSelectedRow();
        
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um material na tabela!");
            return;
        }
        
        try {
            int id = (int) tabelaMateriais.getValueAt(linha, 0);
            
            MaterialBibliotecaDAO dao = new MaterialBibliotecaDAO();
            MaterialBiblioteca material = dao.getMaterial(id);
            
            if (material != null) {
                String info = 
                    "DETALHES DO MATERIAL\n\n" +
                    "ID: " + material.getIdMaterial() + "\n" +
                    "Título: " + material.getTitulo() + "\n" +
                    "Tipo: " + material.getTipo() + "\n" +
                    "Ano: " + material.getAnoPublicacao() + "\n" +
                    "Editora: " + (material.getEditora() != null ? material.getEditora() : "Não informada") + "\n" +
                    "Disponível: " + (material.isDisponivel() ? "Sim" : "Não");
                
                JOptionPane.showMessageDialog(this, info);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnTodos = new javax.swing.JButton();
        btnDisponiveis = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMateriais = new javax.swing.JTable();
        btnDetalhes = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Materiais");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("CONSULTAR MATERIAIS DA BIBLIOTECA");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Opções"));

        lblBuscar.setText("Buscar:");

        txtBuscar.setColumns(20);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnTodos.setText("Ver Todos");
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });

        btnDisponiveis.setText("Apenas Disponíveis");
        btnDisponiveis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisponiveisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(btnTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDisponiveis)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnTodos)
                    .addComponent(btnDisponiveis))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelaMateriais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Título", "Tipo", "Disponível"
            }
        ));
        jScrollPane1.setViewportView(tabelaMateriais);

        btnDetalhes.setText("Ver Detalhes");
        btnDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        lblTotal.setText("Total: 0 materiais");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDetalhes)
                                .addGap(18, 18, 18)
                                .addComponent(btnFechar))
                            .addComponent(lblTotal))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetalhes)
                    .addComponent(btnFechar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarPorTitulo();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
        carregarTodosMateriais();
    }//GEN-LAST:event_btnTodosActionPerformed

    private void btnDisponiveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisponiveisActionPerformed
        carregarMateriaisDisponiveis();
    }//GEN-LAST:event_btnDisponiveisActionPerformed

    private void btnDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesActionPerformed
        verDetalhes();
    }//GEN-LAST:event_btnDetalhesActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ConsultarMaterial().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDetalhes;
    private javax.swing.JButton btnDisponiveis;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tabelaMateriais;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}