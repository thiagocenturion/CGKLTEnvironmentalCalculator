/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Classes.GerenciadorDados;
import Models.ModelEletronicos;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author thiagocenturion
 */
public class FormEletronicos extends ViewFormBase {
    
    /**
     * Creates new form ViewFormBase
     */
    public FormEletronicos() {
        super();
    }
    
    public FormEletronicos(int iPagAtual) {
        
        // Recebe como parametro o numero da pagina atual a ser ativada na construção da classe pai
        super(iPagAtual);
        
        // Inicia as configurações dos controles de tela
        iniciaControles();
    }
    
    /**
     * Métodos
     */
    private void iniciaControles() {
        
        // Titulo da página
        this.lblTitulo.setText("Eletrônicos");
        
        // Descrição é configurada em HTML para ter o efeito 'word wrap', o que torna a label multi-linhas
        // com alinhamento justificado na tag <p></p>
        this.lblDescricao.setText("<HTML><p align=\"justify\">O eletrônico, como smartphone, computador ou tablet, se tornou uma parte importante na troca de informações. Por conta disso, ele tem sido muito importante para as pessoas. O que muitos não sabem é que um simples aparelho, como esse, pode causar um enorme prejuízo ao meio ambiente.</p></HTML>");
        
        // Icone que acompanha o titulo e descricao da página
        this.lblIcon.setIcon(new ImageIcon( getClass().getResource("/img/IconEletronicos.png")) );
        
        // Configura primeira questão da página
        this.lblPerg1.setText("<HTML><p align=\"justify\">Quantos celulares você já teve?</p></HTML>");
        this.btnOpcao1A.setText("Nenhum ou 1");
        this.btnOpcao1B.setText("2 ou 3");
        this.btnOpcao1C.setText("4 ou mais");
        
        // Configura segunda questão da página
        this.lblPerg2.setText("<HTML><p align=\"justify\">Quantos computadores ou notebooks já existiram em sua casa?</p></HTML>");
        this.btnOpcao2A.setText("Nenhum ou 1 computador");
        this.btnOpcao2B.setText("2 a 4 computadores");
        this.btnOpcao2C.setText("5 computadores ou mais");
        
        // Configura terceira questão da página
        this.lblPerg3.setText("<HTML><p align=\"justify\">Quantas TVs você já teve?</p></HTML>");
        this.btnOpcao3A.setText("1 a 2 TVs");
        this.btnOpcao3B.setText("3 a 4 TVs");
        this.btnOpcao3C.setText("5 ou mais");
        
        // Expressão Lambda para evento de clique do botão Continuar
        this.btnContinuar.addActionListener((ActionEvent e) -> {
            
            // Cria a model de folhas e guarda os valores da tela
            ModelEletronicos modelEletronicos = new ModelEletronicos();
            modelEletronicos.setOpcaoQtdeCelulares(super.getSelecionado(1));
            modelEletronicos.setOpcaoQtdeComputadores(super.getSelecionado(2));
            modelEletronicos.setOpcaoQtdeTV(super.getSelecionado(3));
             
            // Armazena o modelo em um array list estático na memória
            GerenciadorDados.getModels().put(GerenciadorDados.ELETRONICOS, modelEletronicos);
            
            // Cria uma instância da nova tela a ser aberta
            FormRoupa formRoupas = new FormRoupa(4);

            // Seta que ela deve ser visível
            formRoupas.setVisible(true);

            // Seta que ESTA tela não deve ser mais visível
            this.setVisible(false);

            // Para todas as telas secundárias, ou seja, que não são as principais, utilizar este método também
            this.dispose();
        });
    }
    
}
