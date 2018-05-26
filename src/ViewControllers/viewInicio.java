/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Classes.GerenciadorDados;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class viewInicio extends javax.swing.JFrame {

    /**
     * Creates new form viewInicio
     */
    public viewInicio() {
        
        try {
            
            initComponents();

            // Inicia as configurações dos controles de tela
            iniciaControles();
        }
        catch(Exception e) {
            
            // Mostra na tela um alerta informando do erro e imprime no console qual foi o erro
            JOptionPane.showMessageDialog(null, "Houve algum erro. Tente novamente!");
            System.err.println("Erro gerado:\n");
            System.err.println(e.getMessage());
        }
    }
    
    private void iniciaControles() {
        
        // Texto do título que apresenta a cima do logo
        this.lblTituloLogo.setText("<HTML><p align=\"center\">Consumption\nCalculator</p></HTML>");
        
        // Descrição é configurada em HTML para ter o efeito 'word wrap', o que torna a label multi-linhas
        // com alinhamento justificado na tag <p></p>
        this.lblDescricao.setText("<HTML><p align=\"center\">Descubra se você é um consumidor consciente quando trata-se de suas ações e impactos diretos/indiretos ao meio ambiente.<br><br>Você será submetido a uma análise aprofundada de conhecimentos e dicas, na qual mostrará um resultado com base na sua pontuação, que definirá o perfil de consumir que és.</p></HTML>");
        
        // Esta operação faz com que o Form apareça no centro da tela
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblTituloLogo = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Myriad Pro", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(70, 178, 142));
        jLabel3.setText("Calcule o seu");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Myriad Pro", 0, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(2, 127, 149));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Impacto Ambiental");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/IconLogoNegativo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        lblTituloLogo.setFont(new java.awt.Font("Myriad Pro", 0, 48)); // NOI18N
        lblTituloLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloLogo.setText("Consumption");
        lblTituloLogo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(lblTituloLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 300, 160));

        btnIniciar.setBackground(new java.awt.Color(0, 78, 64));
        btnIniciar.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciar.setText("Iniciar");
        btnIniciar.setAlignmentX(1.0F);
        btnIniciar.setAlignmentY(1.0F);
        btnIniciar.setBorder(null);
        btnIniciar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, 150, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lateral_e.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblDescricao.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblDescricao.setForeground(new java.awt.Color(153, 153, 153));
        lblDescricao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDescricao.setText("jLabel2");
        lblDescricao.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(lblDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 400, 240));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        
        try {
        
            // Cria uma instância da nova tela a ser aberta
            FormFolha frmFolha = new FormFolha(1);

            // Seta que ela deve ser visível
            frmFolha.setVisible(true);

            // Seta que ESTA tela não deve ser mais visível
            this.setVisible(false);
        }
        catch(Exception e) {
            
            // Mostra na tela um alerta informando do erro e imprime no console qual foi o erro
            JOptionPane.showMessageDialog(null, "Houve algum erro. Tente novamente!");
            System.err.println("Erro gerado:\n");
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

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
            java.util.logging.Logger.getLogger(viewInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblTituloLogo;
    // End of variables declaration//GEN-END:variables

 
}