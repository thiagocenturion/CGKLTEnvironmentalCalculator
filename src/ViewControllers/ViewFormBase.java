/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Classes.GerenciadorDados;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author thiagocenturion
 */
public class ViewFormBase extends javax.swing.JFrame {
    
    /**
     * Esta propriedade fornece qual a página atual do form
     */
    protected int iPagAtual;
    
    /**
     * Creates new form ViewFormBase
     */
    public ViewFormBase() {
        
        // Sobrecarga do construtor completo passando página vazia
        this(0);
    }
    
    public ViewFormBase( int iPagAtual ) {
        
        try {
        
            // Inicia os componentes de tela
            initComponents();

            // Armazena a página atual a qual se remete a ordem na lista de formularios
            //desta view
            this.iPagAtual = iPagAtual;

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
        
        // Cor de tinta ativada para as labels de pagina
        Color corTinta = new Color(20, 100, 75);
        this.lblPag1.setTinta(corTinta);
        this.lblPag2.setTinta(corTinta);
        this.lblPag3.setTinta(corTinta);
        this.lblPag4.setTinta(corTinta);
        this.lblPag5.setTinta(corTinta);
        
        // Coloca a label ativa conforme seu valor e desativa as outras
        atualizaPaginaAtiva();
        
        // Esta operação faz com que o Form apareça no centro da tela
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        // Isto faz com que o usuário não maximize a tela, fazendo com que quebre a diagramação do layout
        this.setResizable(false);
    }
    
    private void atualizaPaginaAtiva() {
        
        switch ( this.iPagAtual ) {
            
            case 1:
                
                // Ativa a pagina 1
                this.lblPag1.setAtiva(true);
                
                // Desativa as demais
                this.lblPag2.setAtiva(false);
                this.lblPag3.setAtiva(false);
                this.lblPag4.setAtiva(false);
                this.lblPag5.setAtiva(false);
                
                break;
                
            case 2:
                
                // Ativa a pagina 2
                this.lblPag2.setAtiva(true);
                
                // Desativa as demais
                this.lblPag1.setAtiva(false);
                this.lblPag3.setAtiva(false);
                this.lblPag4.setAtiva(false);
                this.lblPag5.setAtiva(false);
                
                break;
                
            case 3:
                
                // Ativa a pagina 3
                this.lblPag3.setAtiva(true);
                
                // Desativa as demais
                this.lblPag1.setAtiva(false);
                this.lblPag2.setAtiva(false);
                this.lblPag4.setAtiva(false);
                this.lblPag5.setAtiva(false);
                
                break;
                
            case 4:
                
                // Ativa a pagina 4
                this.lblPag4.setAtiva(true);
                
                // Desativa as demais
                this.lblPag1.setAtiva(false);
                this.lblPag2.setAtiva(false);
                this.lblPag3.setAtiva(false);
                this.lblPag5.setAtiva(false);
                
                break;
                
            case 5:
                
                // Ativa a pagina 5
                this.lblPag5.setAtiva(true);
                
                // Desativa as demais
                this.lblPag1.setAtiva(false);
                this.lblPag2.setAtiva(false);
                this.lblPag3.setAtiva(false);
                this.lblPag4.setAtiva(false);
                
                break;
        }
    }
    
    protected int getSelecionado(int iQuestao) {
        
        int iRetorno = 0;
        
        // Obtem a resposta atual selecionada da questao dada por parametro. 
        // Se a questão não existir, retorna 0.
        switch (iQuestao) {
            case 1:
                // Pega o comando de ação do botao selecionado referente à questão 1
                iRetorno = Integer.parseInt(grpOpcoes1.getSelection().getActionCommand());
                break;
            case 2:
                // Pega o comando de ação do botao selecionado referente à questão 2
                iRetorno = Integer.parseInt(grpOpcoes2.getSelection().getActionCommand());
                break;
            case 3:
                // Pega o comando de ação do botao selecionado referente à questão 3
                iRetorno = Integer.parseInt(grpOpcoes3.getSelection().getActionCommand());
                break;
            default:
                break;
        }
        
        return iRetorno;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpOpcoes1 = new javax.swing.ButtonGroup();
        grpOpcoes2 = new javax.swing.ButtonGroup();
        grpOpcoes3 = new javax.swing.ButtonGroup();
        pnlDashboard = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblPag1 = new ControlesTela.LabelAtiva();
        lblPag2 = new ControlesTela.LabelAtiva();
        lblPag3 = new ControlesTela.LabelAtiva();
        lblPag4 = new ControlesTela.LabelAtiva();
        lblPag5 = new ControlesTela.LabelAtiva();
        lblIcon = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblTitulo = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        pnlFormulario = new javax.swing.JPanel();
        btnContinuar = new javax.swing.JButton();
        pnlForm1 = new javax.swing.JPanel();
        lblPerg1 = new javax.swing.JLabel();
        btnOpcao1A = new javax.swing.JRadioButton();
        btnOpcao1C = new javax.swing.JRadioButton();
        btnOpcao1B = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        pnlForm3 = new javax.swing.JPanel();
        lblPerg3 = new javax.swing.JLabel();
        btnOpcao3A = new javax.swing.JRadioButton();
        btnOpcao3C = new javax.swing.JRadioButton();
        btnOpcao3B = new javax.swing.JRadioButton();
        jSeparator4 = new javax.swing.JSeparator();
        pnlForm2 = new javax.swing.JPanel();
        lblPerg2 = new javax.swing.JLabel();
        btnOpcao2A = new javax.swing.JRadioButton();
        btnOpcao2C = new javax.swing.JRadioButton();
        btnOpcao2B = new javax.swing.JRadioButton();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlDashboard.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        lblPag1.setForeground(new java.awt.Color(153, 153, 153));
        lblPag1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPag1.setText("1");

        lblPag2.setForeground(new java.awt.Color(153, 153, 153));
        lblPag2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPag2.setText("2");

        lblPag3.setForeground(new java.awt.Color(153, 153, 153));
        lblPag3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPag3.setText("3");

        lblPag4.setForeground(new java.awt.Color(153, 153, 153));
        lblPag4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPag4.setText("4");

        lblPag5.setForeground(new java.awt.Color(153, 153, 153));
        lblPag5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPag5.setText("5");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblPag1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(lblPag2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(lblPag3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(lblPag4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(lblPag5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPag1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPag2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPag3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPag4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPag5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/IconFolhas.png"))); // NOI18N

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 15));
        jSeparator1.setSize(new java.awt.Dimension(50, 15));

        lblTitulo.setFont(new java.awt.Font("Myriad Pro", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Título");
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblDescricao.setForeground(new java.awt.Color(153, 153, 153));
        lblDescricao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDescricao.setText("A utilização da folha esta intrinscamente ligada ao nosso cotidiano de maneira direta e indireta. Consequentemente, são gastos 10 litros d’água e 0,013% de uma árvore de Eucalipto para a produção de 1 folha A4.");
        lblDescricao.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlDashboardLayout = new javax.swing.GroupLayout(pnlDashboard);
        pnlDashboard.setLayout(pnlDashboardLayout);
        pnlDashboardLayout.setHorizontalGroup(
            pnlDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlDashboardLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(pnlDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDashboardLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(lblDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        pnlDashboardLayout.setVerticalGroup(
            pnlDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDashboardLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(lblDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlFormulario.setBackground(new java.awt.Color(242, 242, 242));

        btnContinuar.setBackground(new java.awt.Color(0, 78, 64));
        btnContinuar.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        btnContinuar.setForeground(new java.awt.Color(255, 255, 255));
        btnContinuar.setText("Continuar");
        btnContinuar.setAlignmentX(1.0F);
        btnContinuar.setAlignmentY(1.0F);
        btnContinuar.setBorder(null);
        btnContinuar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        pnlForm1.setBackground(new java.awt.Color(242, 242, 242));

        lblPerg1.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        lblPerg1.setForeground(new java.awt.Color(102, 102, 102));
        lblPerg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPerg1.setText("Quantas das suas faturas são entregues por correspondências, ou seja, em casa?");

        grpOpcoes1.add(btnOpcao1A);
        btnOpcao1A.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        btnOpcao1A.setForeground(new java.awt.Color(51, 51, 51));
        btnOpcao1A.setSelected(true);
        btnOpcao1A.setText("Todas");
        btnOpcao1A.setToolTipText("");
        btnOpcao1A.setActionCommand("1");
        btnOpcao1A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcao1AActionPerformed(evt);
            }
        });

        grpOpcoes1.add(btnOpcao1C);
        btnOpcao1C.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        btnOpcao1C.setForeground(new java.awt.Color(51, 51, 51));
        btnOpcao1C.setText("Nenhuma");
        btnOpcao1C.setActionCommand("3");

        grpOpcoes1.add(btnOpcao1B);
        btnOpcao1B.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        btnOpcao1B.setForeground(new java.awt.Color(51, 51, 51));
        btnOpcao1B.setText("Algumas");
        btnOpcao1B.setActionCommand("2");
        btnOpcao1B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcao1BActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlForm1Layout = new javax.swing.GroupLayout(pnlForm1);
        pnlForm1.setLayout(pnlForm1Layout);
        pnlForm1Layout.setHorizontalGroup(
            pnlForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlForm1Layout.createSequentialGroup()
                .addGap(0, 56, Short.MAX_VALUE)
                .addGroup(pnlForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPerg1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlForm1Layout.createSequentialGroup()
                        .addComponent(btnOpcao1A)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOpcao1B)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOpcao1C)))
                .addGap(54, 54, 54))
            .addGroup(pnlForm1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlForm1Layout.setVerticalGroup(
            pnlForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlForm1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblPerg1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(pnlForm1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpcao1A)
                    .addComponent(btnOpcao1C)
                    .addComponent(btnOpcao1B))
                .addGap(27, 27, 27)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlForm3.setBackground(new java.awt.Color(242, 242, 242));

        lblPerg3.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        lblPerg3.setForeground(new java.awt.Color(102, 102, 102));
        lblPerg3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPerg3.setText("Quantos cadernos tem em sua casa?");

        grpOpcoes3.add(btnOpcao3A);
        btnOpcao3A.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        btnOpcao3A.setForeground(new java.awt.Color(51, 51, 51));
        btnOpcao3A.setSelected(true);
        btnOpcao3A.setText("1 a 2 cadernos");
        btnOpcao3A.setActionCommand("1");
        btnOpcao3A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcao3AActionPerformed(evt);
            }
        });

        grpOpcoes3.add(btnOpcao3C);
        btnOpcao3C.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        btnOpcao3C.setForeground(new java.awt.Color(51, 51, 51));
        btnOpcao3C.setText("5 ou mais");
        btnOpcao3C.setActionCommand("3");

        grpOpcoes3.add(btnOpcao3B);
        btnOpcao3B.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        btnOpcao3B.setForeground(new java.awt.Color(51, 51, 51));
        btnOpcao3B.setText("3 a 4 cadernos");
        btnOpcao3B.setActionCommand("2");

        javax.swing.GroupLayout pnlForm3Layout = new javax.swing.GroupLayout(pnlForm3);
        pnlForm3.setLayout(pnlForm3Layout);
        pnlForm3Layout.setHorizontalGroup(
            pnlForm3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlForm3Layout.createSequentialGroup()
                .addGap(0, 56, Short.MAX_VALUE)
                .addGroup(pnlForm3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlForm3Layout.createSequentialGroup()
                        .addComponent(btnOpcao3A)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOpcao3B)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOpcao3C))
                    .addComponent(lblPerg3, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
            .addGroup(pnlForm3Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlForm3Layout.setVerticalGroup(
            pnlForm3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlForm3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblPerg3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(pnlForm3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpcao3A)
                    .addComponent(btnOpcao3C)
                    .addComponent(btnOpcao3B))
                .addGap(27, 27, 27)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlForm2.setBackground(new java.awt.Color(242, 242, 242));

        lblPerg2.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        lblPerg2.setForeground(new java.awt.Color(102, 102, 102));
        lblPerg2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPerg2.setText("Na maioria dos casos, você costuma solicitar a segunda via do pagamento ao realizar com cartão?");

        grpOpcoes2.add(btnOpcao2A);
        btnOpcao2A.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        btnOpcao2A.setForeground(new java.awt.Color(51, 51, 51));
        btnOpcao2A.setSelected(true);
        btnOpcao2A.setText("Sim");
        btnOpcao2A.setActionCommand("1");
        btnOpcao2A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcao2AActionPerformed(evt);
            }
        });

        grpOpcoes2.add(btnOpcao2C);
        btnOpcao2C.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        btnOpcao2C.setForeground(new java.awt.Color(51, 51, 51));
        btnOpcao2C.setText("Não sei");
        btnOpcao2C.setActionCommand("3");
        btnOpcao2C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcao2CActionPerformed(evt);
            }
        });

        grpOpcoes2.add(btnOpcao2B);
        btnOpcao2B.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        btnOpcao2B.setForeground(new java.awt.Color(51, 51, 51));
        btnOpcao2B.setText("Não");
        btnOpcao2B.setActionCommand("2");
        btnOpcao2B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcao2BActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlForm2Layout = new javax.swing.GroupLayout(pnlForm2);
        pnlForm2.setLayout(pnlForm2Layout);
        pnlForm2Layout.setHorizontalGroup(
            pnlForm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlForm2Layout.createSequentialGroup()
                .addGap(0, 56, Short.MAX_VALUE)
                .addGroup(pnlForm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlForm2Layout.createSequentialGroup()
                        .addComponent(btnOpcao2A)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOpcao2B)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOpcao2C))
                    .addComponent(lblPerg2, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
            .addGroup(pnlForm2Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlForm2Layout.setVerticalGroup(
            pnlForm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlForm2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblPerg2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(pnlForm2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpcao2A)
                    .addComponent(btnOpcao2C)
                    .addComponent(btnOpcao2B))
                .addGap(27, 27, 27)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlFormularioLayout = new javax.swing.GroupLayout(pnlFormulario);
        pnlFormulario.setLayout(pnlFormularioLayout);
        pnlFormularioLayout.setHorizontalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlForm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlForm3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlForm2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlFormularioLayout.setVerticalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlForm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlForm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlForm3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDashboard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void btnOpcao1AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcao1AActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOpcao1AActionPerformed

    private void btnOpcao3AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcao3AActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOpcao3AActionPerformed

    private void btnOpcao2AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcao2AActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOpcao2AActionPerformed

    private void btnOpcao2BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcao2BActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOpcao2BActionPerformed

    private void btnOpcao2CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcao2CActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOpcao2CActionPerformed

    private void btnOpcao1BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcao1BActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOpcao1BActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnContinuar;
    protected javax.swing.JRadioButton btnOpcao1A;
    protected javax.swing.JRadioButton btnOpcao1B;
    protected javax.swing.JRadioButton btnOpcao1C;
    protected javax.swing.JRadioButton btnOpcao2A;
    protected javax.swing.JRadioButton btnOpcao2B;
    protected javax.swing.JRadioButton btnOpcao2C;
    protected javax.swing.JRadioButton btnOpcao3A;
    protected javax.swing.JRadioButton btnOpcao3B;
    protected javax.swing.JRadioButton btnOpcao3C;
    private javax.swing.ButtonGroup grpOpcoes1;
    private javax.swing.ButtonGroup grpOpcoes2;
    private javax.swing.ButtonGroup grpOpcoes3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    protected javax.swing.JLabel lblDescricao;
    protected javax.swing.JLabel lblIcon;
    protected ControlesTela.LabelAtiva lblPag1;
    protected ControlesTela.LabelAtiva lblPag2;
    protected ControlesTela.LabelAtiva lblPag3;
    protected ControlesTela.LabelAtiva lblPag4;
    protected ControlesTela.LabelAtiva lblPag5;
    protected javax.swing.JLabel lblPerg1;
    protected javax.swing.JLabel lblPerg2;
    protected javax.swing.JLabel lblPerg3;
    protected javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlDashboard;
    protected javax.swing.JPanel pnlForm1;
    protected javax.swing.JPanel pnlForm2;
    protected javax.swing.JPanel pnlForm3;
    private javax.swing.JPanel pnlFormulario;
    // End of variables declaration//GEN-END:variables
}
