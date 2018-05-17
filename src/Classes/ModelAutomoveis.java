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
public class ModelAutomoveis {
    
    private Resposta respQtdeAutomoveis;
    private Resposta respSairCarro;
    private Resposta respTipoCombustivel;

    public Resposta getRespQtdeAutomoveis() {
        return respQtdeAutomoveis;
    }
    public Resposta getRespSairCarro() {
        return respSairCarro;
    }
    public Resposta getRespTipoCombustivel() {
        return respTipoCombustivel;
    }
    
    
    /**
     * Pontuação máxima é 10 e mínima 3. Quantidade máxima é 4 e mínima é 0.
     * @param sAutomoveis Valor do radio button digitado
     */
    public void setOpcaoAutomoveis(String sAutomoveis) {
        
        // Se o usuário selecionou 'Todas'
        switch (sAutomoveis) {
            case "Mais que 3 automóveis":
                // Sua pontuação é minima e a quantidade é máxima
                this.respQtdeAutomoveis = new Resposta(3, 4.0f);
                break;
            case "1 a 2 automóveis":
                // Sua pontuação é média e a quantidade é média
                this.respQtdeAutomoveis = new Resposta(6, 1.5f);
                break;
            default:
                // Sua pontuação é máxima e a quantidade é mínima
                this.respQtdeAutomoveis = new Resposta(10, 0.0f);
                break;
        }
    }
    
    /**
     * Pontuação máxima é 10 e mínima 3. Quantidade máxima é 3 e mínima é 1.
     * @param sSairCarro Valor do radio button digitado
     */
    public void setOpcaoSairCarro(String sSairCarro) {
        
        switch (sSairCarro) {
            case "Trabalhar e sair socialmente":
                // Sua pontuação é minima e a quantidade é máxima
                this.respSairCarro = new Resposta(3, 3);
                break;
            case "Só para ir trabalhar":
                // Sua pontuação é média e a quantidade é média
                this.respSairCarro = new Resposta(6, 2);
                break;
            default:
                // Sua pontuação é máxima e a quantidade é mínima
                this.respSairCarro = new Resposta(10, 1);
                break;
        }
    }
    
    /**
     * Pontuação máxima é 10 e mínima 3. Quantidade máxima é 1000 e mínima é 300.
     * @param sCombustivel Valor do radio button digitado
     */
    public void setOpcaoTipoCombustivel(String sCombustivel) {
        
        switch (sCombustivel) {
            case "Gasolina":
                // Sua pontuação é minima e a quantidade é máxima
                this.respTipoCombustivel = new Resposta(3, 1000);
                break;
            case "Etanol":
                // Sua pontuação é média e a quantidade é média
                this.respTipoCombustivel = new Resposta(6, 700);
                break;
            default:
                // Sua pontuação é máxima e a quantidade é mínima
                this.respTipoCombustivel = new Resposta(10, 300);
                break;
        }
    }
}
