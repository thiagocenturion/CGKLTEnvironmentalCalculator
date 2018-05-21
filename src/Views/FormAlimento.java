/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author thiagocenturion
 */
public class FormAlimento extends ViewFormBase {
    
    /**
     * Creates new form ViewFormBase
     */
    public FormAlimento() {
        super();
    }
    
    public FormAlimento(int iPagAtual) {
        
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
        this.lblTitulo.setText("Alimentos");
        
        // Descrição é configurada em HTML para ter o efeito 'word wrap', o que torna a label multi-linhas
        // com alinhamento justificado na tag <p></p>
        this.lblDescricao.setText("<HTML><p align=\"justify\">A alimentação faz parte da essência da dieta do ser humano. Entretanto, pouco é o acesso ao conhecimento dos valores impactantes ao meio ambiente quanto à produção de cada um deles.</p></HTML>");
        
        // Icone que acompanha o titulo e descricao da página
        this.lblIcon.setIcon(new ImageIcon( getClass().getResource("/img/IconAlimentos.png")) );
        
        // Configura primeira questão da página
        this.lblPerg1.setText("<HTML><p align=\"justify\">Com qual frequencia você come carne bovina?</p></HTML>");
        this.btnOpcao1A.setText("Todos os dias");
        this.btnOpcao1B.setText("Algumas vezes na semana");
        this.btnOpcao1C.setText("Raramente");
        
        // Configura segunda questão da página
        this.lblPerg2.setText("<HTML><p align=\"justify\">Com qual frequencia você come frutas, legumes e verduras ? </p></HTML>");
        this.btnOpcao2A.setText("Todos os dias");
        this.btnOpcao2B.setText("Algumas vezes na semana");
        this.btnOpcao2C.setText("Raramente");
        
        // Configura terceira questão da página
        this.lblPerg3.setText("<HTML><p align=\"justify\">Quantas vezes por dia costuma fazer refeição?</p></HTML>");
        this.btnOpcao3A.setText("1 a 2 cadernos");
        this.btnOpcao3B.setText("3 a 4 cadernos");
        this.btnOpcao3C.setText("5 ou mais");
        
        // Setup do texto apresentado no botão para 'finalizar' e ir para a tela final
        this.btnContinuar.setText("Finalizar");
        
        // Expressão Lambda para evento de clique do botão Continuar
        this.btnContinuar.addActionListener((ActionEvent e) -> {
            System.out.println("Teste!");
        });
    }
    
}
