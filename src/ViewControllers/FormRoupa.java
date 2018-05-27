/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Classes.GerenciadorDados;
import Models.ModelRoupas;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author thiagocenturion
 */
public class FormRoupa extends ViewFormBase {
    
    /**
     * Creates new form ViewFormBase
     */
    public FormRoupa() {
        super();
    }
    
    public FormRoupa(int iPagAtual) {
        
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
        this.lblTitulo.setText("Roupas");
        
        // Descrição é configurada em HTML para ter o efeito 'word wrap', o que torna a label multi-linhas
        // com alinhamento justificado na tag <p></p>
        this.lblDescricao.setText("<HTML><p align=\"justify\">As roupas são acessórios utilizados pela sociedade há séculos, assim como seus impactos no meio ambiente. A fabricação de apenas uma calça jeans são gastos 10 mil litros de água.</p></HTML>");
        
        // Icone que acompanha o titulo e descricao da página
        this.lblIcon.setIcon(new ImageIcon( getClass().getResource("/img/IconRoupas.png")) );
        
        // Configura primeira questão da página
        this.lblPerg1.setText("<HTML><p align=\"justify\">Quantas calças jeans você possui?</p></HTML>");
        this.btnOpcao1A.setText("Até 3");
        this.btnOpcao1B.setText("5 a 10");
        this.btnOpcao1C.setText("10 em diante");
        
        // Configura segunda questão da página
        this.lblPerg2.setText("<HTML><p align=\"justify\">Você tem roupas de bréchos, bazares e/ou sustentáveis? </p></HTML>");
        this.btnOpcao2A.setText("Sim, todas");
        this.btnOpcao2B.setText("Sim, algumas");
        this.btnOpcao2C.setText("Minoria ou nenhuma");
        
        // Configura terceira questão da página
        this.lblPerg3.setText("<HTML><p align=\"justify\">Com qual frequência você compra roupas?</p></HTML>");
        this.btnOpcao3A.setText("Mensalmente");
        this.btnOpcao3B.setText("Trimestralmente");
        this.btnOpcao3C.setText("Semestralmente");
        
        // Expressão Lambda para evento de clique do botão Continuar
        this.btnContinuar.addActionListener((ActionEvent e) -> {
            
            // Cria a model de folhas e guarda os valores da tela
            ModelRoupas modelRoupas = new ModelRoupas();
            modelRoupas.setOpcaoJeans(super.getSelecionado(1));
            modelRoupas.setQtdeSustentaveis(super.getSelecionado(2));
            modelRoupas.setFrequenciaCompraRoupas(super.getSelecionado(3));
            
            // Cria uma instância da nova tela a ser aberta
            FormAlimento formAlimentos = new FormAlimento(5);
            
            // Armazena o modelo em um array list estático na memória
            GerenciadorDados.getModels().put(GerenciadorDados.ROUPAS, modelRoupas);

            // Seta que ela deve ser visível
            formAlimentos.setVisible(true);

            // Seta que ESTA tela não deve ser mais visível
            this.setVisible(false);

            // Para todas as telas secundárias, ou seja, que não são as principais, utilizar este método também
            this.dispose();
        });
    }
    
}
