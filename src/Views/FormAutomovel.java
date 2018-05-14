/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import javax.swing.ImageIcon;

/**
 *
 * @author thiagocenturion
 */
public class FormAutomovel extends ViewFormBase {
    
    /**
     * Creates new form ViewFormBase
     */
    public FormAutomovel() {
        super();
    }
    
    public FormAutomovel(int iPagAtual) {
        
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
        this.lblTitulo.setText("Automóveis");
        
        // Descrição é configurada em HTML para ter o efeito 'word wrap', o que torna a label multi-linhas
        // com alinhamento justificado na tag <p></p>
        this.lblDescricao.setText("<HTML><p align=\"justify\">A utilização da folha está intrinscamente ligada ao nosso cotidiano de maneira direta e indireta. Consequentemente, são gastos 10 litros d’água e 0,013% de uma árvore de Eucalipto para a produção de 1 folha A4.</p></HTML>");
        
        // Icone que acompanha o titulo e descricao da página
        this.lblIcon.setIcon(new ImageIcon( getClass().getResource("/img/IconAutomoveis.png")) );
        
        // Configura primeira questão da página
        this.lblPerg1.setText("<HTML><p align=\"justify\">Quantas das suas faturas são entregues por correspondências, ou seja, em casa?</p></HTML>");
        this.btnOpcao1A.setText("Todas");
        this.btnOpcao1B.setText("Algumas");
        this.btnOpcao1C.setText("Nenhuma");
        
        // Configura segunda questão da página
        this.lblPerg1.setText("<HTML><p align=\"justify\">Na maioria dos casos, você costuma solicitar a segunda via do pagamento ao realizar com cartão?</p></HTML>");
        this.btnOpcao1A.setText("Sim");
        this.btnOpcao1B.setText("Não");
        this.btnOpcao1C.setText("Não sei");
        
        // Configura terceira questão da página
        this.lblPerg1.setText("<HTML><p align=\"justify\">Quantos cadernos tem em sua casa?</p></HTML>");
        this.btnOpcao1A.setText("1 a 2 cadernos");
        this.btnOpcao1B.setText("3 a 4 cadernos");
        this.btnOpcao1C.setText("5 ou mais");
    }
    
}
