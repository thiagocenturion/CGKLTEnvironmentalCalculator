/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Models.ModelFolhas;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author thiagocenturion
 */
public class FormFolha extends ViewFormBase {
    
    /**
     * Creates new form ViewFormBase
     */
    public FormFolha() {
        super();
    }
    
    public FormFolha(int iPagAtual) {
        
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
        this.lblTitulo.setText("Folhas");
        
        // Descrição é configurada em HTML para ter o efeito 'word wrap', o que torna a label multi-linhas
        // com alinhamento justificado na tag <p></p>
        this.lblDescricao.setText("<HTML><p align=\"justify\">A utilização da folha está intrinscamente ligada ao nosso cotidiano de maneira direta e indireta. Consequentemente, são gastos 10 litros d’água e 0,013% de uma árvore de Eucalipto para a produção de 1 folha A4.</p></HTML>");
        
        // Icone que acompanha o titulo e descricao da página
        this.lblIcon.setIcon(new ImageIcon( getClass().getResource("/img/IconFolhas.png")) );
        
        // Configura primeira questão da página
        this.lblPerg1.setText("<HTML><p align=\"justify\">Quantas das suas faturas são entregues por correspondências, ou seja, em casa?</p></HTML>");
        this.btnOpcao1A.setText("Todas");
        this.btnOpcao1B.setText("Algumas");
        this.btnOpcao1C.setText("Nenhuma");
        
        // Configura segunda questão da página
        this.lblPerg2.setText("<HTML><p align=\"justify\">Na maioria dos casos, você costuma solicitar a segunda via do pagamento ao realizar com cartão?</p></HTML>");
        this.btnOpcao2A.setText("Sim");
        this.btnOpcao2B.setText("Não");
        this.btnOpcao2C.setText("Não sei");
        
        // Configura terceira questão da página
        this.lblPerg3.setText("<HTML><p align=\"justify\">Quantos cadernos tem em sua casa?</p></HTML>");
        this.btnOpcao3A.setText("1 a 2 cadernos");
        this.btnOpcao3B.setText("3 a 4 cadernos");
        this.btnOpcao3C.setText("5 ou mais");
        
        // Expressão Lambda para evento de clique do botão Continuar
        this.btnContinuar.addActionListener((ActionEvent e) -> {
            
            // Cria a model de folhas e guarda os valores da tela
            ModelFolhas modelFolhas = new ModelFolhas();
            modelFolhas.setOpcaoFaturas(super.getSelecionado(1));
            modelFolhas.setOpcaoSegundaVia(super.getSelecionado(2));
            modelFolhas.setOpcaoCadernos(super.getSelecionado(3));
            
            // Cria uma instância da nova tela a ser aberta
            FormAutomovel formAutomoveis = new FormAutomovel(2);
            
            // Caso tenhamos o gerenciador de dados
            if ( this.getGerenciadorDados() != null ) {
                
                // Guarda o modelo de folhas nele e passa para a próxima tela
                this.getGerenciadorDados().setModelFolhas(modelFolhas);
                formAutomoveis.setGerenciadorDados(this.getGerenciadorDados());
            }
            
            // Seta que ela deve ser visível
            formAutomoveis.setVisible(true);

            // Seta que ESTA tela não deve ser mais visível
            this.setVisible(false);

            // Para todas as telas secundárias, ou seja, que não são as principais, utilizar este método também
            this.dispose();
        });
    }
}
