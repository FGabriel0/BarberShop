/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Controller.BarbeiroController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author Biel
 */
public class MenuBarbeiro extends javax.swing.JFrame {

    private BarbeiroController controller;

    public MenuBarbeiro(BarbeiroController controller) {
        this.controller = controller;
    }
    
    /**
     * Creates new form MenuBarbeiro
     */
    public MenuBarbeiro() throws SQLException {
        initComponents();
        controller = new BarbeiroController(this);
        iniciarTable();
    }
    
     private void iniciarTable() throws SQLException {
         controller.atualizarTabelaAgendamento();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableAgendamentos = new javax.swing.JTable();
        TodosAgendamentos = new javax.swing.JButton();
        AgendamentoHoje = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableAgendamentos.setBackground(new java.awt.Color(255, 255, 255));
        TableAgendamentos.setForeground(new java.awt.Color(0, 0, 0));
        TableAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "whats", "Serviço", "Data", "Hora", "Preço", "Obser"
            }
        ));
        jScrollPane1.setViewportView(TableAgendamentos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 910, 330));

        TodosAgendamentos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TodosAgendamentos.setForeground(new java.awt.Color(255, 255, 255));
        TodosAgendamentos.setText("Todos");
        TodosAgendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TodosAgendamentosActionPerformed(evt);
            }
        });
        getContentPane().add(TodosAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 52, 70, 30));

        AgendamentoHoje.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AgendamentoHoje.setForeground(new java.awt.Color(255, 255, 255));
        AgendamentoHoje.setText("Hoje");
        AgendamentoHoje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendamentoHojeActionPerformed(evt);
            }
        });
        getContentPane().add(AgendamentoHoje, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 52, -1, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Agendamentos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ViewsImagens/BannerPC.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setForeground(new java.awt.Color(0, 0, 0));

        jMenu2.setText("Edit");

        jMenuItem2.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ViewsIcons/tesoura-icon.png"))); // NOI18N
        jMenuItem2.setText("Serviços");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ViewsIcons/usuario-icon.png"))); // NOI18N
        jMenuItem3.setText("Voltar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem1.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ViewsIcons/cliente-icon.png"))); // NOI18N
        jMenuItem1.setText("Novo Acesso");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            // TODO add your handling code here:
            TelaService services = new TelaService();
            services.setVisible(true);
            setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(MenuBarbeiro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        LoginBarbeiro login = new LoginBarbeiro();
        login.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        CadastrarBarbeiro cadastrar = new CadastrarBarbeiro();
        cadastrar.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void TodosAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TodosAgendamentosActionPerformed
        try {
            // TODO add your handling code here:
            controller.filtrarTodos();
        } catch (SQLException ex) {
            Logger.getLogger(MenuBarbeiro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TodosAgendamentosActionPerformed

    private void AgendamentoHojeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendamentoHojeActionPerformed
        try {
            // TODO add your handling code here:
            controller.filtrarAgendamentosHoje();
        } catch (SQLException ex) {
            Logger.getLogger(MenuBarbeiro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AgendamentoHojeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuBarbeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuBarbeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuBarbeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuBarbeiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MenuBarbeiro().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MenuBarbeiro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public JTable getTableAgendamentos() {
        return TableAgendamentos;
    }

    public void setTableAgendamentos(JTable TableAgendamentos) {
        this.TableAgendamentos = TableAgendamentos;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgendamentoHoje;
    private javax.swing.JTable TableAgendamentos;
    private javax.swing.JButton TodosAgendamentos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
