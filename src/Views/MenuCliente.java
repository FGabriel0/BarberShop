/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Controller.ClienteController;
import java.awt.EventQueue;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author Biel
 */
public class MenuCliente extends javax.swing.JFrame {
    
    private ClienteController controller;
    
    /**
     * Creates new form MenuCliente
     */
    public MenuCliente() {
        this.controller = controller;
        initComponents();
    }

    private void iniciarTable() throws SQLException {
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonEmDia = new javax.swing.JButton();
        ButtonTodos = new javax.swing.JButton();
        welcomeCliente = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ButtonAgendar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableAgendamentos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonEmDia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonEmDia.setForeground(new java.awt.Color(0, 0, 0));
        ButtonEmDia.setText("Em Dia");
        ButtonEmDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEmDiaActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonEmDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 80, 30));

        ButtonTodos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonTodos.setForeground(new java.awt.Color(0, 0, 0));
        ButtonTodos.setText("Todos");
        getContentPane().add(ButtonTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 70, 30));

        welcomeCliente.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        welcomeCliente.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(welcomeCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 220, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Agendamentos");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, -1));

        ButtonAgendar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonAgendar.setForeground(new java.awt.Color(0, 0, 0));
        ButtonAgendar.setText("Agendar");
        ButtonAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAgendarActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonAgendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, -1, 30));

        TableAgendamentos.setBackground(new java.awt.Color(204, 204, 204));
        TableAgendamentos.setForeground(new java.awt.Color(255, 255, 255));
        TableAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Email", "Telefone", "Serviço", "Preço", "Dia", "Hora", "Obeservação"
            }
        ));
        jScrollPane1.setViewportView(TableAgendamentos);
        if (TableAgendamentos.getColumnModel().getColumnCount() > 0) {
            TableAgendamentos.getColumnModel().getColumn(0).setHeaderValue("id");
            TableAgendamentos.getColumnModel().getColumn(1).setHeaderValue("Telefone");
            TableAgendamentos.getColumnModel().getColumn(2).setHeaderValue("Serviço");
            TableAgendamentos.getColumnModel().getColumn(3).setHeaderValue("Preço");
            TableAgendamentos.getColumnModel().getColumn(4).setHeaderValue("Dia");
            TableAgendamentos.getColumnModel().getColumn(5).setHeaderValue("Hora");
            TableAgendamentos.getColumnModel().getColumn(6).setHeaderValue("Observação");
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 860, 290));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 64, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ViewsImagens/BannerPC.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 490));

        jMenu2.setText("Ações");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ViewsIcons/usuario-icon.png"))); // NOI18N
        jMenuItem2.setText("Voltar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar2.add(jMenu2);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAgendarActionPerformed
        // TODO add your handling code here:
        Agendar agendar = new Agendar();
        agendar.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_ButtonAgendarActionPerformed

    private void ButtonEmDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEmDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonEmDiaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        LoginCliente login = new LoginCliente();
        login.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       EventQueue.invokeLater(() -> {
        MenuCliente menu = new MenuCliente();
        menu.setVisible(true);

        ClienteController controller = new ClienteController(menu); // Crie o ClienteController passando o MenuCliente

        menu.setController(controller); // Defina o controlador no MenuCliente
    });
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
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuCliente().setVisible(true);
            }
        });
    }

    public JTable getTableAgendamentos() {
        return TableAgendamentos;
    }

    public void setTableAgendamentos(JTable TableAgendamentos) {
        this.TableAgendamentos = TableAgendamentos;
    }

    public JLabel getWelcomeCliente() {
        return welcomeCliente;
    }

    public void setWelcomeCliente(JLabel welcomeCliente) {
        this.welcomeCliente = welcomeCliente;
    }

    public ClienteController getController() {
        return controller;
    }

    public void setController(ClienteController controller) {
        this.controller = controller;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAgendar;
    private javax.swing.JButton ButtonEmDia;
    private javax.swing.JButton ButtonTodos;
    private javax.swing.JTable TableAgendamentos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel welcomeCliente;
    // End of variables declaration//GEN-END:variables
}
