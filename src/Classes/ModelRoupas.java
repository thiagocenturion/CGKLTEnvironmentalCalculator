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
public class ModelRoupas {
    
    private Resposta respQtdeJeans;
    private Resposta respQtdeSustentaveis;
    private Resposta respFreqCompraRoupas;

    public Resposta getRespQtdeJeans() {
        return respQtdeJeans;
    }
    public Resposta getRespQtdeSustentaveis() {
        return respQtdeSustentaveis;
    }
    public Resposta getRespFreqCompraRoupas() {
        return respFreqCompraRoupas;
    }
    
    /**
     * Pontuação máxima é 10 e mínima 3. Quantidade máxima é 15 e mínima é 3.
     * @param sJeans do radio button digitado
     */
    public void setOpcaoJeans(String sJeans) {
        
        // Se o usuário selecionou 'Todas'
        switch (sJeans) {
            case "Até 3":
                // Sua pontuação é maxima e a quantidade é minima
                this.respQtdeJeans = new Resposta(10, 3.0f);
                break;
            case "5 a 10":
                // Sua pontuação é média e a quantidade é média
                this.respQtdeJeans = new Resposta(6, 7.5f);
                break;
            default:
                // Sua pontuação é máxima e a quantidade é mínima
                this.respQtdeJeans = new Resposta(3, 15.0f);
                break;
        }
    }
    
    /**
     * Pontuação máxima é 10 e mínima 3. Quantidade máxima é 15 e mínima é 3.
     * @param sSustentaveis do radio button digitado
     */
    public void setQtdeSustentaveis(String sSustentaveis) {
        
        switch (sSustentaveis) {
            case "Sim, todas":
                // Sua pontuação é maxima e a quantidade é máxima
                this.respQtdeSustentaveis = new Resposta(10, -15.0f);
                break;
            case "Não sei":
                // Sua pontuação é média e a quantidade é média
                this.respQtdeSustentaveis = new Resposta(6, -7.5f);
                break;
            default:
                // Sua pontuação é máxima e a quantidade é mínima
                this.respQtdeSustentaveis = new Resposta(3, 0.0f);
                break;
        }
    }
    
    /**
     * Pontuação máxima é 10 e mínima 3. Quantidade máxima é 150 e mínima é 0.
     * @param sFrequencia Valor do radio button digitado
     */
    public void setFrequenciaCompraRoupas(String sFrequencia) {
        
        switch (sFrequencia) {
            case "Mensalmente":
                // Sua pontuação é maxima e a quantidade é máxima
                this.respFreqCompraRoupas = new Resposta(3, 30.0f);
                break;
            case "Trimestralmente":
                // Sua pontuação é média e a quantidade é média
                this.respFreqCompraRoupas = new Resposta(6, 10.0f);
                break;
            default:
                // Sua pontuação é máxima e a quantidade é mínima
                this.respFreqCompraRoupas = new Resposta(10, 5.0f);
                break;
        }
    }
}
