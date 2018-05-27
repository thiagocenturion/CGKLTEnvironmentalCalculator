/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Classes.GerenciadorDados;
import Models.ModelAlimentos;
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
        this.lblPerg1.setText("<HTML><p align=\"justify\">Para cada refeição, quanto de massa de carne você ingere, em média?</p></HTML>");
        this.btnOpcao1A.setText("Nada ou pouco (aprox. 110g)");
        this.btnOpcao1B.setText("Médio (aprox. 220g)");
        this.btnOpcao1C.setText("Muito (aprox. 440g)");
        
        // Configura segunda questão da página
        this.lblPerg2.setText("<HTML><p align=\"justify\">Quantos dias da semana você realiza uma refeição com carne?</p></HTML>");
        this.btnOpcao2A.setText("Todos os dias");
        this.btnOpcao2B.setText("Algumas vezes na semana");
        this.btnOpcao2C.setText("Raramente");
        
        // TODO: Colocar pergunta sobre doces
        // Configura terceira questão da página
        this.lblPerg3.setText("<HTML><p align=\"justify\">Quantas vezes por dia costuma fazer refeição?</p></HTML>");
        this.btnOpcao3A.setText("1 a 2");
        this.btnOpcao3B.setText("3 a 4");
        this.btnOpcao3C.setText("5 ou mais");
        
        // Setup do texto apresentado no botão para 'finalizar' e ir para a tela final
        this.btnContinuar.setText("Finalizar");
        
        // Expressão Lambda para evento de clique do botão Continuar
        this.btnContinuar.addActionListener((ActionEvent e) -> {
            // Cria a model de automoveis e guarda os valores da tela
            ModelAlimentos modelAlimentos = new ModelAlimentos();
            modelAlimentos.setMassaCarne(super.getSelecionado(1));
            modelAlimentos.setFreqRefeicaoCarne(super.getSelecionado(2));
//            modelAlimentos.setOpcaoTipoCombustivel(super.getSelecionado(3));

            // Armazena o modelo em um array list estático na memória
            GerenciadorDados.getModels().put(GerenciadorDados.ALIMENTOS, modelAlimentos);
            
            // Cria uma instância da tela final
            ViewFinal viewFinal = new ViewFinal();

            // Seta que ela deve ser visível
            viewFinal.setVisible(true);

            // Seta que ESTA tela não deve ser mais visível
            this.setVisible(false);

            // Para todas as telas secundárias, ou seja, que não são as principais, utilizar este método também
            this.dispose();
        });
    }
    
}
