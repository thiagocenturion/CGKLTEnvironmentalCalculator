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
public class ModelFolhas {
    
    private Resposta respFaturas;
    private Resposta respSegundaVia;
    private Resposta respCadernos;

    public Resposta getRespFaturas() {
        return respFaturas;
    }
    public Resposta getRespSegundaVia() {
        return respSegundaVia;
    }
    public Resposta getRespCadernos() {
        return respCadernos;
    }
    
    
    /**
     * Pontuação máxima é 10 e mínima 3. Quantidade máxima é 20 e mínima é 0.
     * @param sFaturas Valor do radio button digitado
     */
    public void setOpcaoFaturas(String sFaturas) {
        
        // Se o usuário selecionou 'Todas'
        switch (sFaturas) {
            case "Todas":
                // Sua pontuação é minima e a quantidade é máxima
                this.respFaturas = new Resposta(3, 20.0f);
                break;
            case "Algumas":
                // Sua pontuação é média e a quantidade é média
                this.respFaturas = new Resposta(6, 10.0f);
                break;
            default:
                // Sua pontuação é máxima e a quantidade é mínima
                this.respFaturas = new Resposta(10, 0.0f);
                break;
        }
    }
    
    /**
     * Pontuação máxima é 10 e mínima 3. Quantidade máxima é 150 e mínima é 0.
     * @param sSegundaVia Valor do radio button digitado
     */
    public void setOpcaoSegundaVia(String sSegundaVia) {
        
        switch (sSegundaVia) {
            case "Sim":
                // Sua pontuação é minima e a quantidade é máxima
                this.respSegundaVia = new Resposta(3, 150.0f);
                break;
            case "Não sei":
                // Sua pontuação é média e a quantidade é média
                this.respSegundaVia = new Resposta(6, 75.0f);
                break;
            default:
                // Sua pontuação é máxima e a quantidade é mínima
                this.respSegundaVia = new Resposta(10, 0.0f);
                break;
        }
    }
    
    /**
     * Pontuação máxima é 10 e mínima 3. Quantidade máxima é 1000 e mínima é 300.
     * @param sCadernos Valor do radio button digitado
     */
    public void setOpcaoCadernos(String sCadernos) {
        
        switch (sCadernos) {
            case "5 ou mais":
                // Sua pontuação é minima e a quantidade é máxima
                this.respSegundaVia = new Resposta(3, 1000.0f);
                break;
            case "3 a 4 cadernos":
                // Sua pontuação é média e a quantidade é média
                this.respSegundaVia = new Resposta(6, 700.0f);
                break;
            default:
                // Sua pontuação é máxima e a quantidade é mínima
                this.respSegundaVia = new Resposta(10, 300.0f);
                break;
        }
    }
}
