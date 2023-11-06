/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Controller.ClienteController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *
 * @author Biel
 */
public class LoginCliente extends javax.swing.JFrame {

    private final ClienteController controller;
    private LoginCliente views;

    /**
     * Creates new form Login
     */
    public LoginCliente() {
        initComponents();
        controller = new ClienteController(this);
    }

    public LoginCliente(ClienteController controller, LoginCliente views) {
        this.controller = controller;
        this.views = views;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TextName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TextPassword = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        EsqueceuSenha = new javax.swing.JLabel();
        Cadastrar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        EntrarBarbeiro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0, 140));
        jPanel2.setForeground(new java.awt.Color(244, 244, 244));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nome:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Entrar como Cliente");

        TextName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextName.setAlignmentX(0.0F);
        TextName.setBorder(null);
        TextName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextNameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Senha:");

        TextPassword.setBorder(null);
        TextPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextPasswordActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ENTRAR");
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setMaximumSize(new java.awt.Dimension(32, 16));
        jButton2.setMinimumSize(new java.awt.Dimension(32, 16));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        EsqueceuSenha.setForeground(new java.awt.Color(255, 255, 255));
        EsqueceuSenha.setText("Esqueceu a Senha?");
        EsqueceuSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EsqueceuSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EsqueceuSenhaMouseClicked(evt);
            }
        });

        Cadastrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Cadastrar.setForeground(new java.awt.Color(255, 255, 255));
        Cadastrar.setText("Não possui conta? Criar conta.");
        Cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CadastrarMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ViewsImagens/Logo_resized.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel8)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel8)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        EntrarBarbeiro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EntrarBarbeiro.setForeground(new java.awt.Color(255, 255, 255));
        EntrarBarbeiro.setText("Entrar Como Barbeiro");
        EntrarBarbeiro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EntrarBarbeiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EntrarBarbeiroMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(TextName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(TextPassword))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Cadastrar)
                                .addGap(21, 21, 21))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(EsqueceuSenha)
                                .addGap(54, 54, 54)))
                        .addGap(63, 63, 63))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel9))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(EntrarBarbeiro)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel9)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EsqueceuSenha)
                .addGap(16, 16, 16)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Cadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EntrarBarbeiro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextNameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            controller.Autenticar();
        } catch (SQLException ex) {
            Logger.getLogger(LoginCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void TextPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextPasswordActionPerformed

    private void EsqueceuSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EsqueceuSenhaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_EsqueceuSenhaMouseClicked

    private void CadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CadastrarMouseClicked
        // TODO add your handling code here:
         CadastroCliente Cadastrocliente = new CadastroCliente();
         Cadastrocliente.setVisible(true);
         setVisible(false);
    }//GEN-LAST:event_CadastrarMouseClicked

    private void EntrarBarbeiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EntrarBarbeiroMouseClicked
        // TODO add your handling code here:
        LoginBarbeiro barbeiro = new LoginBarbeiro();
        barbeiro.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_EntrarBarbeiroMouseClicked

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
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginCliente().setVisible(true);
            }
        });
    }

    public JTextField getTextName() {
        return TextName;
    }

    public void setTextName(JTextField TextName) {
        this.TextName = TextName;
    }

    public JPasswordField getTextPassword() {
        return TextPassword;
    }

    public void setTextPassword(JPasswordField TextPassword) {
        this.TextPassword = TextPassword;
    }

   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cadastrar;
    private javax.swing.JLabel EntrarBarbeiro;
    private javax.swing.JLabel EsqueceuSenha;
    private javax.swing.JTextField TextName;
    private javax.swing.JPasswordField TextPassword;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
