/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Classes.Calculadora;
import Classes.GerenciadorDados;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JLabel;
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
        
        // Cria a calculadora que fará a agregação de resultados das múltiplas models
        Calculadora calculadora = new Calculadora();
        
        // Solicita à calculadora estimar e processar todos os resultados das models dadas
        calculadora.estimarResultados(GerenciadorDados.getModels());
        
        // Depois que a calculadora estimou todos os resultados, aciona o método que os ajustam com os resultados na tela
        ajustaResultadosTela(calculadora);
        
        // Aciona o método que mostra dicas de melhorias na tela conforme desempenho do consumidor
        mostraDicasDesempenho(calculadora);
        
        // Esta operação faz com que o Form apareça no centro da tela
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        // Isto faz com que o usuário não maximize a tela, fazendo com que quebre a diagramação do layout
        this.setResizable(false);
    }
    
    public void ajustaResultadosTela(Calculadora calculadora) {
        
        float fAux = 0.0f;
        
        // formatador de números para a língua português do Brasil
        NumberFormat numberFormat = NumberFormat.getInstance(new Locale("pt","BR"));
        numberFormat.setMaximumFractionDigits(3);
        
        // Recupera a pontuação final das models e coloca na tela com a sua cor
        this.lblPercntCons1.setText(calculadora.getPontuacao().toString());
        this.lblResultPercntCons.setText(calculadora.getConsciencia());
        this.lblResultPercntCons.setForeground(calculadora.getCorConsciencia());
        this.lblPercntCons1.setForeground(calculadora.getCorConsciencia());
        this.lblResultPercntConsSimbolo.setForeground(calculadora.getCorConsciencia());
        
        /**
         * Obtenção dos valores para Árvores de eucalipto
         */
        fAux = calculadora.getResultados().get(GerenciadorDados.FOLHAS)[0].getQuantidadeValor();
        this.lblResultEsp3.setText( numberFormat.format(fAux) );
        
        /**
         * Obtenção dos valores para Kg de CO2
         */
        fAux = calculadora.getResultados().get(GerenciadorDados.AUTOMOVEIS)[0].getQuantidadeValor();
        fAux += calculadora.getResultados().get(GerenciadorDados.ELETRONICOS)[1].getQuantidadeValor();
        fAux += calculadora.getResultados().get(GerenciadorDados.ROUPAS)[0].getQuantidadeValor();
        fAux += calculadora.getResultados().get(GerenciadorDados.ALIMENTOS)[0].getQuantidadeValor();
        this.lblResultEsp2.setText( numberFormat.format( Float.parseFloat(String.format("%.2f", fAux)) ) );
        
        /**
         * Obtenção dos valores para Kg de Combustíveis fósseis
         */
        fAux = calculadora.getResultados().get(GerenciadorDados.ELETRONICOS)[0].getQuantidadeValor();
        this.lblResultEsp1.setText( numberFormat.format(fAux) );
        
        /**
         * Obtenção dos valores para água e banhos
         * 1 Banho de 6 minutos = 50 L de água
         */
        this.lblResultGlob.setText( numberFormat.format( Math.round( calculadora.getResultadoAgua() ) ) );
        this.lblResultBanhos.setText( numberFormat.format( Math.round(calculadora.getResultadoAgua() / 50.0f) ) );
    }
    
    public void mostraDicasDesempenho(Calculadora calculadora) {
        
        // Caso o usuário tenha atingido uma nota abaixo de 50% para FOLHAS
        if ( calculadora.getResultados().get(GerenciadorDados.FOLHAS)[0].getPontuacao() < 60 ) {
            // Mostra na tela dicas referente a folhas
            setLabelDicas("<HTML><p align=\"justify\">- Priorize documentos, materiais e extratos digitais para economizar papel.</p></HTML>");
        }
        
        // Caso o usuário tenha atingido uma nota abaixo de 50% para AUTOMÓVEIS
        if ( calculadora.getResultados().get(GerenciadorDados.AUTOMOVEIS)[0].getPontuacao() < 60 ) {
            // Mostra na tela dicas referente a folhas
            setLabelDicas("<HTML><p align=\"justify\">- Priorize utilizar transportes públicos ou compartilhar viagens com outras pessoas no mesmo automóvel.</p></HTML>");
        }
        
        // Caso o usuário tenha atingido uma nota abaixo de 50% para ELETRÔNICOS
        if ( calculadora.getResultados().get(GerenciadorDados.ELETRONICOS)[0].getPontuacao() < 60 ) {
            // Mostra na tela dicas referente a folhas
            setLabelDicas("<HTML><p align=\"justify\">- Mantenha seu eletrônico por mais tempo. Recicle ou descarte eletrônicos de forma correta.</p></HTML>");
        }
        
        // Caso o usuário tenha atingido uma nota abaixo de 50% para ROUPAS
        if ( calculadora.getResultados().get(GerenciadorDados.ROUPAS)[0].getPontuacao() < 60 ) {
            // Mostra na tela dicas referente a folhas
            setLabelDicas("<HTML><p align=\"justify\">- Conheça mais sobre o guarda-roupa “cápsula”.</p></HTML>");
        }
    }
    
    public void setLabelDicas(String sTexto) {
        
        // Monta um array com todas as labels de dicas
        JLabel[] arrLabelsDicas = new JLabel[]{this.lblSugMelh1, this.lblSugMelh2, this.lblSugMelh3, this.lblSugMelh4};
        
        // Looping pelas labels para verificar a próxima label a receber o texto
        for ( JLabel lblAux : arrLabelsDicas ) {
            
            // Esta label ainda está vazia?
            if ( lblAux.getText().equals("") ) {
                
                // Seta o texto recebido nela e finaliza a operação
                lblAux.setText(sTexto);
                break;
            }
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

        jPanel1 = new javax.swing.JPanel();
        pnlEsp1 = new javax.swing.JPanel();
        lblBottomEsp1 = new javax.swing.JLabel();
        lblTopEsp1 = new javax.swing.JLabel();
        lblResultEsp1 = new javax.swing.JLabel();
        lblResultEsp5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnlEsp2 = new javax.swing.JPanel();
        lblBottomEsp2 = new javax.swing.JLabel();
        lblTopEsp2 = new javax.swing.JLabel();
        lblResultEsp2 = new javax.swing.JLabel();
        lblResultEsp10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnlGlob1 = new javax.swing.JPanel();
        lblBottomGlob1 = new javax.swing.JLabel();
        lblTopGlob1 = new javax.swing.JLabel();
        lblResultEsp3 = new javax.swing.JLabel();
        lblResultEsp6 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlGlob = new javax.swing.JPanel();
        lblBottomGlob = new javax.swing.JLabel();
        lblTopGlob = new javax.swing.JLabel();
        lblResultGlob = new javax.swing.JLabel();
        lblResultEsp4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblBottomGlob2 = new javax.swing.JLabel();
        lblResultBanhos = new javax.swing.JLabel();
        lblResultEsp7 = new javax.swing.JLabel();
        lblBottomGlob3 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTopCons = new javax.swing.JLabel();
        lblResultPercntCons = new javax.swing.JLabel();
        lblPercntCons1 = new javax.swing.JLabel();
        lblResultPercntConsSimbolo = new javax.swing.JLabel();
        lblAproveitamento = new javax.swing.JLabel();
        lblSugMelh1 = new javax.swing.JLabel();
        lblSugMelh2 = new javax.swing.JLabel();
        lblSugMelh3 = new javax.swing.JLabel();
        lblSugMelh4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(235, 235, 235));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlEsp1.setBackground(new java.awt.Color(255, 255, 255));

        lblBottomEsp1.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblBottomEsp1.setForeground(new java.awt.Color(153, 153, 153));
        lblBottomEsp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBottomEsp1.setText("de Combustíveis Fósseis");
        lblBottomEsp1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblTopEsp1.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblTopEsp1.setForeground(new java.awt.Color(153, 153, 153));
        lblTopEsp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTopEsp1.setText("Foram gastos");
        lblTopEsp1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblResultEsp1.setFont(new java.awt.Font("Myriad Pro", 0, 48)); // NOI18N
        lblResultEsp1.setForeground(new java.awt.Color(204, 0, 51));
        lblResultEsp1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblResultEsp1.setText("Label1");

        lblResultEsp5.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        lblResultEsp5.setForeground(new java.awt.Color(204, 0, 51));
        lblResultEsp5.setText("Kg");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/IconPetrol.png"))); // NOI18N

        javax.swing.GroupLayout pnlEsp1Layout = new javax.swing.GroupLayout(pnlEsp1);
        pnlEsp1.setLayout(pnlEsp1Layout);
        pnlEsp1Layout.setHorizontalGroup(
            pnlEsp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEsp1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEsp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBottomEsp1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(lblTopEsp1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlEsp1Layout.createSequentialGroup()
                        .addComponent(lblResultEsp1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblResultEsp5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEsp1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(102, 102, 102))
        );
        pnlEsp1Layout.setVerticalGroup(
            pnlEsp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEsp1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTopEsp1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEsp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblResultEsp5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResultEsp1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBottomEsp1)
                .addContainerGap())
        );

        jPanel1.add(pnlEsp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 285, 230));

        pnlEsp2.setBackground(new java.awt.Color(255, 255, 255));

        lblBottomEsp2.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblBottomEsp2.setForeground(new java.awt.Color(153, 153, 153));
        lblBottomEsp2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBottomEsp2.setText("para o efeito estufa");
        lblBottomEsp2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblTopEsp2.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblTopEsp2.setForeground(new java.awt.Color(153, 153, 153));
        lblTopEsp2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTopEsp2.setText("Você produz");
        lblTopEsp2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblResultEsp2.setFont(new java.awt.Font("Myriad Pro", 0, 48)); // NOI18N
        lblResultEsp2.setForeground(new java.awt.Color(204, 0, 51));
        lblResultEsp2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblResultEsp2.setText("Label1");

        lblResultEsp10.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        lblResultEsp10.setForeground(new java.awt.Color(204, 0, 51));
        lblResultEsp10.setText("Kg de CO2");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/IconCarbonDiox.png"))); // NOI18N

        javax.swing.GroupLayout pnlEsp2Layout = new javax.swing.GroupLayout(pnlEsp2);
        pnlEsp2.setLayout(pnlEsp2Layout);
        pnlEsp2Layout.setHorizontalGroup(
            pnlEsp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEsp2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEsp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBottomEsp2, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(lblTopEsp2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlEsp2Layout.createSequentialGroup()
                        .addComponent(lblResultEsp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblResultEsp10, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(pnlEsp2Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlEsp2Layout.setVerticalGroup(
            pnlEsp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEsp2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTopEsp2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEsp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResultEsp2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResultEsp10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblBottomEsp2)
                .addContainerGap())
        );

        jPanel1.add(pnlEsp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 285, 230));

        pnlGlob1.setBackground(new java.awt.Color(255, 255, 255));

        lblBottomGlob1.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblBottomGlob1.setForeground(new java.awt.Color(153, 153, 153));
        lblBottomGlob1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBottomGlob1.setText("pela a quantidade de folhas gastas");
        lblBottomGlob1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblTopGlob1.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblTopGlob1.setForeground(new java.awt.Color(153, 153, 153));
        lblTopGlob1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTopGlob1.setText("Você custou");
        lblTopGlob1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblResultEsp3.setFont(new java.awt.Font("Myriad Pro", 0, 48)); // NOI18N
        lblResultEsp3.setForeground(new java.awt.Color(204, 0, 51));
        lblResultEsp3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblResultEsp3.setText("jLabel1");

        lblResultEsp6.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        lblResultEsp6.setForeground(new java.awt.Color(204, 0, 51));
        lblResultEsp6.setText("% de 1 árvore de Eucaliptio");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/IconTree.png"))); // NOI18N

        javax.swing.GroupLayout pnlGlob1Layout = new javax.swing.GroupLayout(pnlGlob1);
        pnlGlob1.setLayout(pnlGlob1Layout);
        pnlGlob1Layout.setHorizontalGroup(
            pnlGlob1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlob1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGlob1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBottomGlob1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(lblTopGlob1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlGlob1Layout.createSequentialGroup()
                        .addComponent(lblResultEsp3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblResultEsp6)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGlob1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(111, 111, 111))
        );
        pnlGlob1Layout.setVerticalGroup(
            pnlGlob1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGlob1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTopGlob1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGlob1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblResultEsp3)
                    .addComponent(lblResultEsp6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBottomGlob1)
                .addContainerGap())
        );

        jPanel1.add(pnlGlob1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 80, 285, 230));

        pnlGlob.setBackground(new java.awt.Color(255, 255, 255));

        lblBottomGlob.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblBottomGlob.setForeground(new java.awt.Color(153, 153, 153));
        lblBottomGlob.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBottomGlob.setText("da água gasta no mundo.");
        lblBottomGlob.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblTopGlob.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblTopGlob.setForeground(new java.awt.Color(153, 153, 153));
        lblTopGlob.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTopGlob.setText("Você contribui para");
        lblTopGlob.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblResultGlob.setFont(new java.awt.Font("Myriad Pro", 0, 48)); // NOI18N
        lblResultGlob.setForeground(new java.awt.Color(0, 153, 204));
        lblResultGlob.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblResultGlob.setText("jLabel1");

        lblResultEsp4.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        lblResultEsp4.setForeground(new java.awt.Color(0, 153, 204));
        lblResultEsp4.setText("litros");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/IconWater.png"))); // NOI18N

        lblBottomGlob2.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblBottomGlob2.setForeground(new java.awt.Color(153, 153, 153));
        lblBottomGlob2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBottomGlob2.setText("O equivalente a");
        lblBottomGlob2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblResultBanhos.setFont(new java.awt.Font("Myriad Pro", 0, 48)); // NOI18N
        lblResultBanhos.setForeground(new java.awt.Color(0, 153, 204));
        lblResultBanhos.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblResultBanhos.setText("jLabel1");

        lblResultEsp7.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        lblResultEsp7.setForeground(new java.awt.Color(0, 153, 204));
        lblResultEsp7.setText("banhos");

        lblBottomGlob3.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblBottomGlob3.setForeground(new java.awt.Color(153, 153, 153));
        lblBottomGlob3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBottomGlob3.setText("de 6 minutos cada.");
        lblBottomGlob3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlGlobLayout = new javax.swing.GroupLayout(pnlGlob);
        pnlGlob.setLayout(pnlGlobLayout);
        pnlGlobLayout.setHorizontalGroup(
            pnlGlobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlobLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlGlobLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGlobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBottomGlob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTopGlob, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlGlobLayout.createSequentialGroup()
                        .addComponent(lblResultGlob, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblResultEsp4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblBottomGlob2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlGlobLayout.createSequentialGroup()
                        .addComponent(lblResultBanhos, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblResultEsp7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblBottomGlob3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlGlobLayout.setVerticalGroup(
            pnlGlobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlobLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTopGlob, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGlobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblResultGlob)
                    .addComponent(lblResultEsp4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBottomGlob)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBottomGlob2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlGlobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblResultBanhos)
                    .addComponent(lblResultEsp7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBottomGlob3)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(pnlGlob, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 350, 285, 420));

        lblTitulo.setFont(new java.awt.Font("Myriad Pro", 0, 21)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Resultado da Pesquisa");
        lblTitulo.setToolTipText("");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/FinalBackground.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 167));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/IconLogoPositivo.png"))); // NOI18N

        lblTopCons.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblTopCons.setForeground(new java.awt.Color(153, 153, 153));
        lblTopCons.setText("Você é um Consumidor");
        lblTopCons.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblResultPercntCons.setFont(new java.awt.Font("Myriad Pro", 0, 52)); // NOI18N
        lblResultPercntCons.setForeground(new java.awt.Color(0, 153, 102));
        lblResultPercntCons.setText("Não Consciente");
        lblResultPercntCons.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblPercntCons1.setFont(new java.awt.Font("Myriad Pro", 0, 100)); // NOI18N
        lblPercntCons1.setForeground(new java.awt.Color(0, 153, 102));
        lblPercntCons1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPercntCons1.setText("100");
        lblPercntCons1.setToolTipText("");
        lblPercntCons1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblResultPercntConsSimbolo.setFont(new java.awt.Font("Myriad Pro", 0, 48)); // NOI18N
        lblResultPercntConsSimbolo.setForeground(new java.awt.Color(0, 153, 102));
        lblResultPercntConsSimbolo.setText("%");
        lblResultPercntConsSimbolo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lblAproveitamento.setFont(new java.awt.Font("Myriad Pro", 0, 20)); // NOI18N
        lblAproveitamento.setForeground(new java.awt.Color(153, 153, 153));
        lblAproveitamento.setText("Aproveitamento");
        lblAproveitamento.setToolTipText("");
        lblAproveitamento.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblSugMelh1.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblSugMelh1.setForeground(new java.awt.Color(153, 153, 153));

        lblSugMelh2.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblSugMelh2.setForeground(new java.awt.Color(153, 153, 153));

        lblSugMelh3.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblSugMelh3.setForeground(new java.awt.Color(153, 153, 153));

        lblSugMelh4.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        lblSugMelh4.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblResultPercntCons, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTopCons, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPercntCons1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAproveitamento, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblResultPercntConsSimbolo))
                        .addGap(31, 31, 31))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSugMelh3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSugMelh2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSugMelh1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSugMelh4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTopCons, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lblResultPercntCons)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lblResultPercntConsSimbolo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblAproveitamento))
                            .addComponent(lblPercntCons1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSugMelh1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSugMelh2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSugMelh3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSugMelh4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 610, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1000, 817);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblAproveitamento;
    private javax.swing.JLabel lblBottomEsp1;
    private javax.swing.JLabel lblBottomEsp2;
    private javax.swing.JLabel lblBottomGlob;
    private javax.swing.JLabel lblBottomGlob1;
    private javax.swing.JLabel lblBottomGlob2;
    private javax.swing.JLabel lblBottomGlob3;
    private javax.swing.JLabel lblPercntCons1;
    private javax.swing.JLabel lblResultBanhos;
    private javax.swing.JLabel lblResultEsp1;
    private javax.swing.JLabel lblResultEsp10;
    private javax.swing.JLabel lblResultEsp2;
    private javax.swing.JLabel lblResultEsp3;
    private javax.swing.JLabel lblResultEsp4;
    private javax.swing.JLabel lblResultEsp5;
    private javax.swing.JLabel lblResultEsp6;
    private javax.swing.JLabel lblResultEsp7;
    private javax.swing.JLabel lblResultGlob;
    private javax.swing.JLabel lblResultPercntCons;
    private javax.swing.JLabel lblResultPercntConsSimbolo;
    private javax.swing.JLabel lblSugMelh1;
    private javax.swing.JLabel lblSugMelh2;
    private javax.swing.JLabel lblSugMelh3;
    private javax.swing.JLabel lblSugMelh4;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTopCons;
    private javax.swing.JLabel lblTopEsp1;
    private javax.swing.JLabel lblTopEsp2;
    private javax.swing.JLabel lblTopGlob;
    private javax.swing.JLabel lblTopGlob1;
    private javax.swing.JPanel pnlEsp1;
    private javax.swing.JPanel pnlEsp2;
    private javax.swing.JPanel pnlGlob;
    private javax.swing.JPanel pnlGlob1;
    // End of variables declaration//GEN-END:variables
}
