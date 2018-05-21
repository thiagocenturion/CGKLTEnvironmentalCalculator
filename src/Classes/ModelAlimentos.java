/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author thiagocenturion
 */
public class ModelAlimentos {
    
    private Resposta respQtdeCarneBovina;
    
    /**
     * Quantidade medida em gramas.
     * Foi adotado como padrão que a pessoa possua um carro popular de motor 1.0.
     * TODO: É necessário multiplicar esta quantidade pela quantidade de 'respSairCarro' antes de entrar na regra especifica.
     * REGRA ESPECÍFICA: Um gado bovino chega a emitir 4.486.709toneladas de CO2
     * REGRA GLOBAL (água): 
     * @param iQtdeCarneBovina Valor do radio button digitado
     */
    public void setQtdeCarneBovina(int iQtdeCarneBovina) {
        
        switch (iQtdeCarneBovina) {
            case 1:
                this.respQtdeCarneBovina = new Resposta(3, 1.0f);
                break;
            case 2:
                this.respQtdeCarneBovina = new Resposta(6, 1.0f);
                break;
            case 3:
                this.respQtdeCarneBovina = new Resposta(10, 1.0f);
                break;
            default:
                break;
        }
    }
    
}
