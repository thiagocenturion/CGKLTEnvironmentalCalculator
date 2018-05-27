/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewControllers;

import Classes.GerenciadorDados;
import Models.ModelAutomoveis;
import java.awt.event.ActionEvent;
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
        this.lblDescricao.setText("<HTML><p align=\"justify\">Os automóveis são essências para qualquer pessoa no século XXI, utilizados para transporte de pessoas, cargas entre outros. Porém, o mesmo automóvel que ajuda a população também está contribuindo para o fim do planeta aos poucos. Hoje, ele já é a invenção do homem que mais polui o planeta, não só por suas carcaças, mas também por precisar de bateria, combustível e água.</p></HTML>");
        
        // Icone que acompanha o titulo e descricao da página
        this.lblIcon.setIcon(new ImageIcon( getClass().getResource("/img/IconAutomoveis.png")) );
        
        // Configura primeira questão da página
        this.lblPerg1.setText("<HTML><p align=\"justify\">Quantos automóveis você tem?</p></HTML>");
        this.btnOpcao1A.setText("Nenhum");
        this.btnOpcao1B.setText("1 a 2 automóveis");
        this.btnOpcao1C.setText("Mais que 3 automóveis");
        
        // Configura segunda questão da página
        this.lblPerg2.setText("<HTML><p align=\"justify\">Se você tivesse ou possui carro, o usaria para ir trabalhar ou só para sair nos finais de semana?</p></HTML>");
        this.btnOpcao2A.setText("Só para ir trabalhar");
        this.btnOpcao2B.setText("Só para sair socialmente");
        this.btnOpcao2C.setText("Trabalhar e sair socialmente");
        
        // Configura terceira questão da página
        this.lblPerg3.setText("<HTML><p align=\"justify\">Qual o tipo de combustível que você utiliza para abastecer o seu automóvel principal?</p></HTML>");
        this.btnOpcao3A.setText("Etanol");
        this.btnOpcao3B.setText("Gasolina");
        this.btnOpcao3C.setText("Diesel");
        
        // Expressão Lambda para evento de clique do botão Continuar
        this.btnContinuar.addActionListener((ActionEvent e) -> {
            
            // Cria a model de automoveis e guarda os valores da tela
            ModelAutomoveis modelAutomoveis = new ModelAutomoveis();
            modelAutomoveis.setOpcaoAutomoveis(super.getSelecionado(1));
            modelAutomoveis.setOpcaoSairCarro(super.getSelecionado(2));
            modelAutomoveis.setOpcaoTipoCombustivel(super.getSelecionado(3));
            
            // Armazena o modelo em um array list estático na memória
            GerenciadorDados.getModels().put(GerenciadorDados.AUTOMOVEIS, modelAutomoveis);
            
            // Cria uma instância da nova tela a ser aberta
            FormEletronicos formEletronicos = new FormEletronicos(3);

            // Seta que ela deve ser visível
            formEletronicos.setVisible(true);

            // Seta que ESTA tela não deve ser mais visível
            this.setVisible(false);

            // Para todas as telas secundárias, ou seja, que não são as principais, utilizar este método também
            this.dispose();
        });
    }
    
}
