/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import logica.AdministradorLogica;
import logica.EncargadoLogica;
import logica.UsuarioLogica;
import modelo.Administrador;
import modelo.EncargadoDependencia;
import modelo.Usuario;

/**
 *
 * @author USUARIO
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("../Imagenes/logo.png")).getImage());
        setResizable(false);
        setTitle("Menú principal");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelLogo = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
        jLabelUv = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        jLabelPass = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        usuario = new javax.swing.JTextField();
        jButtonIngresar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo.png"))); // NOI18N
        getContentPane().add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, -1, -1));

        jButtonSalir.setBackground(new java.awt.Color(0, 51, 153));
        jButtonSalir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, -1));

        jLabelUv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoUv.png"))); // NOI18N
        jLabelUv.setText("jLabel1");
        getContentPane().add(jLabelUv, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, -10, 180, 140));

        jLabelUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelUser.setText("Usuario: ");
        getContentPane().add(jLabelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, 20));

        jLabelPass.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelPass.setText("Contraseña: ");
        getContentPane().add(jLabelPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        password.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 170, -1));

        usuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 170, -1));

        jButtonIngresar.setText("Ingresar");
        jButtonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, -1, -1));

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, -1, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/hospital.png"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void jButtonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarActionPerformed
        
        if(usuLog.verificarUsuario(usuario.getText())){
            Usuario usu = usuLog.getUsuario(usuario.getText(), password.getText());
        
            if(usu!=null){
                vistaUsuario obj=new vistaUsuario(usu);
                obj.setVisible(true);
                dispose(); 
                return;
            }
        }else if(encLog.verificarEncargado(usuario.getText())){
            EncargadoDependencia enc = encLog.getEncargado(usuario.getText(), password.getText());
        
            if(enc!=null){
                vistaEncargado obj=new vistaEncargado(enc);
                obj.setVisible(true);
                dispose();
            }
        }else if(adminLog.verificarAdmin(usuario.getText())){
            Administrador admin = adminLog.getAdmin(usuario.getText(), password.getText());
        
            if(admin!=null){
                vistaAdministrador obj=new vistaAdministrador(admin);
                obj.setVisible(true);
                dispose();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
        }
        
    }//GEN-LAST:event_jButtonIngresarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RegistroUsuario obj=new RegistroUsuario();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonIngresar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelPass;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JLabel jLabelUv;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
    private UsuarioLogica usuLog=new UsuarioLogica();
    private EncargadoLogica encLog=new EncargadoLogica();
    private AdministradorLogica adminLog = new AdministradorLogica();
}
