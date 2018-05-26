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
 * @author thiagocenturion
 */
public class ViewFinal extends javax.swing.JFrame {
    
    /**
     * Esta propriedade fornece o gerenciador de modelos
     */
    private GerenciadorDados gerenciadorDados;

    public GerenciadorDados getGerenciadorDados() {
        return gerenciadorDados;
    }
    public void setGerenciadorDados(GerenciadorDados gerenciadorDados) {
        this.gerenciadorDados = gerenciadorDados;
    }

    /**
     * Creates new form ViewFinal
     */
    public ViewFinal() {
        
        try {
            
            initComponents();

            // Inicia os controles customizados
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
        pnlEsp1 = new javax.swing.JPanel();
        lblBottomEsp1 = new javax.swing.JLabel();
        lblTopEsp1 = new javax.swing.JLabel();
        lblResultEsp1 = new javax.swing.JLabel();
        pnlEsp2 = new javax.swing.JPanel();
        lblBottomEsp2 = new javax.swing.JLabel();
        lblTopEsp2 = new javax.swing.JLabel();
        lblResultEsp2 = new javax.swing.JLabel();
        pnlGlob = new javax.swing.JPanel();
        lblBottomGlob = new javax.swing.JLabel();
        lblTopGlob = new javax.swing.JLabel();
        lblResultGlob = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblProcureMelh = new javax.swing.JLabel();
        lblMelhorarMelh = new javax.swing.JLabel();
        lblSugMelh1 = new javax.swing.JLabel();
        lblSugMelh2 = new javax.swing.JLabel();
        lblSugMelh3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTopCons = new javax.swing.JLabel();
        lblResultPercntCons = new javax.swing.JLabel();
        lblPercntCons1 = new javax.swing.JLabel();
        lblResultPercntCons1 = new javax.swing.JLabel();
        lblAproveitamento = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(235, 235, 235));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlEsp1.setBackground(new java.awt.Color(255, 255, 255));

        lblBottomEsp1.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblBottomEsp1.setForeground(new java.awt.Color(153, 153, 153));
        lblBottomEsp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBottomEsp1.setText("jLabel1");
        lblBottomEsp1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblTopEsp1.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblTopEsp1.setForeground(new java.awt.Color(153, 153, 153));
        lblTopEsp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTopEsp1.setText("jLabel1");
        lblTopEsp1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblResultEsp1.setFont(new java.awt.Font("Myriad Pro", 0, 48)); // NOI18N
        lblResultEsp1.setForeground(new java.awt.Color(204, 0, 51));
        lblResultEsp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultEsp1.setText("jLabel1");

        javax.swing.GroupLayout pnlEsp1Layout = new javax.swing.GroupLayout(pnlEsp1);
        pnlEsp1.setLayout(pnlEsp1Layout);
        pnlEsp1Layout.setHorizontalGroup(
            pnlEsp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEsp1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEsp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBottomEsp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTopEsp1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(lblResultEsp1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlEsp1Layout.setVerticalGroup(
            pnlEsp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEsp1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTopEsp1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResultEsp1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBottomEsp1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(pnlEsp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 285, 175));

        pnlEsp2.setBackground(new java.awt.Color(255, 255, 255));

        lblBottomEsp2.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblBottomEsp2.setForeground(new java.awt.Color(153, 153, 153));
        lblBottomEsp2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBottomEsp2.setText("jLabel1");
        lblBottomEsp2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblTopEsp2.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblTopEsp2.setForeground(new java.awt.Color(153, 153, 153));
        lblTopEsp2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTopEsp2.setText("jLabel1");
        lblTopEsp2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblResultEsp2.setFont(new java.awt.Font("Myriad Pro", 0, 48)); // NOI18N
        lblResultEsp2.setForeground(new java.awt.Color(204, 0, 51));
        lblResultEsp2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultEsp2.setText("jLabel1");

        javax.swing.GroupLayout pnlEsp2Layout = new javax.swing.GroupLayout(pnlEsp2);
        pnlEsp2.setLayout(pnlEsp2Layout);
        pnlEsp2Layout.setHorizontalGroup(
            pnlEsp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEsp2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEsp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBottomEsp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTopEsp2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblResultEsp2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlEsp2Layout.setVerticalGroup(
            pnlEsp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEsp2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTopEsp2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResultEsp2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBottomEsp2, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(pnlEsp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 285, 175));

        pnlGlob.setBackground(new java.awt.Color(255, 255, 255));

        lblBottomGlob.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblBottomGlob.setForeground(new java.awt.Color(153, 153, 153));
        lblBottomGlob.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBottomGlob.setText("jLabel1");
        lblBottomGlob.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblTopGlob.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblTopGlob.setForeground(new java.awt.Color(153, 153, 153));
        lblTopGlob.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTopGlob.setText("jLabel1");
        lblTopGlob.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblResultGlob.setFont(new java.awt.Font("Myriad Pro", 0, 48)); // NOI18N
        lblResultGlob.setForeground(new java.awt.Color(0, 153, 204));
        lblResultGlob.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultGlob.setText("jLabel1");

        javax.swing.GroupLayout pnlGlobLayout = new javax.swing.GroupLayout(pnlGlob);
        pnlGlob.setLayout(pnlGlobLayout);
        pnlGlobLayout.setHorizontalGroup(
            pnlGlobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlobLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGlobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBottomGlob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTopGlob, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblResultGlob, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlGlobLayout.setVerticalGroup(
            pnlGlobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGlobLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTopGlob, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResultGlob)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBottomGlob, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(pnlGlob, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 285, 175));

        lblTitulo.setFont(new java.awt.Font("Myriad Pro", 0, 21)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Resultado da Pesquisa");
        lblTitulo.setToolTipText("");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/FinalBackground.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 167));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        lblProcureMelh.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblProcureMelh.setForeground(new java.awt.Color(153, 153, 153));
        lblProcureMelh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProcureMelh.setText("Procure");
        lblProcureMelh.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblMelhorarMelh.setFont(new java.awt.Font("Myriad Pro", 0, 48)); // NOI18N
        lblMelhorarMelh.setForeground(new java.awt.Color(0, 153, 204));
        lblMelhorarMelh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMelhorarMelh.setText("Melhorar");

        lblSugMelh1.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblSugMelh1.setForeground(new java.awt.Color(153, 153, 153));

        lblSugMelh2.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblSugMelh2.setForeground(new java.awt.Color(153, 153, 153));

        lblSugMelh3.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblSugMelh3.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProcureMelh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMelhorarMelh, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(lblSugMelh1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSugMelh2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSugMelh3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProcureMelh, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMelhorarMelh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSugMelh1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSugMelh2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSugMelh3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 290, 285, 270));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/IconLogoPositivo.png"))); // NOI18N

        lblTopCons.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblTopCons.setForeground(new java.awt.Color(153, 153, 153));
        lblTopCons.setText("Você é um Consumidor");
        lblTopCons.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblResultPercntCons.setFont(new java.awt.Font("Myriad Pro", 0, 64)); // NOI18N
        lblResultPercntCons.setForeground(new java.awt.Color(0, 153, 102));
        lblResultPercntCons.setText("Consciente");
        lblResultPercntCons.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblPercntCons1.setFont(new java.awt.Font("Myriad Pro", 0, 100)); // NOI18N
        lblPercntCons1.setForeground(new java.awt.Color(0, 153, 102));
        lblPercntCons1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPercntCons1.setText("100");
        lblPercntCons1.setToolTipText("");
        lblPercntCons1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblResultPercntCons1.setFont(new java.awt.Font("Myriad Pro", 0, 48)); // NOI18N
        lblResultPercntCons1.setForeground(new java.awt.Color(0, 153, 102));
        lblResultPercntCons1.setText("%");
        lblResultPercntCons1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblAproveitamento.setFont(new java.awt.Font("Myriad Pro", 0, 20)); // NOI18N
        lblAproveitamento.setForeground(new java.awt.Color(153, 153, 153));
        lblAproveitamento.setText("Aproveitamento");
        lblAproveitamento.setToolTipText("");
        lblAproveitamento.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblResultPercntCons, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTopCons, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPercntCons1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAproveitamento, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblResultPercntCons1))
                        .addGap(31, 31, 31))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(59, 59, 59))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTopCons, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResultPercntCons)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lblResultPercntCons1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblAproveitamento))
                    .addComponent(lblPercntCons1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 34, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 290, 610, 270));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1000, 622);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ViewFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewFinal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblAproveitamento;
    private javax.swing.JLabel lblBottomEsp1;
    private javax.swing.JLabel lblBottomEsp2;
    private javax.swing.JLabel lblBottomGlob;
    private javax.swing.JLabel lblMelhorarMelh;
    private javax.swing.JLabel lblPercntCons1;
    private javax.swing.JLabel lblProcureMelh;
    private javax.swing.JLabel lblResultEsp1;
    private javax.swing.JLabel lblResultEsp2;
    private javax.swing.JLabel lblResultGlob;
    private javax.swing.JLabel lblResultPercntCons;
    private javax.swing.JLabel lblResultPercntCons1;
    private javax.swing.JLabel lblSugMelh1;
    private javax.swing.JLabel lblSugMelh2;
    private javax.swing.JLabel lblSugMelh3;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTopCons;
    private javax.swing.JLabel lblTopEsp1;
    private javax.swing.JLabel lblTopEsp2;
    private javax.swing.JLabel lblTopGlob;
    private javax.swing.JPanel pnlEsp1;
    private javax.swing.JPanel pnlEsp2;
    private javax.swing.JPanel pnlGlob;
    // End of variables declaration//GEN-END:variables
}
