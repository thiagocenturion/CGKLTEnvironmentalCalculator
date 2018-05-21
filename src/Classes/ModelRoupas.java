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
     * Quantidade medida em unidades.
     * REGRA ESPECÍFICA: 1 Calça Jeans - 160 kgCO2
     * REGRA GLOBAL (água): 1 Calça jeans - 10.000 Litros
     * @param iJeans do radio button digitado
     */
    public void setOpcaoJeans(int iJeans) {
        
        switch (iJeans) {
            case 1:
                this.respQtdeJeans = new Resposta(10, 3.0f);
                break;
            case 2:
                this.respQtdeJeans = new Resposta(6, 7.5f);
                break;
            case 3:
                this.respQtdeJeans = new Resposta(3, 15.0f);
                break;
            default:
                break;
        }
    }
    
    /**
     * Quantidade medida em unidades.
     * TODO: Na conta final, não deixar ser menor que 0.
     * REGRA ESPECÍFICA: 1 Calça Jeans - 160 kgCO2
     * REGRA GLOBAL (água): 1 Calça jeans - 10.000 Litros
     * @param iSustentaveis radio button digitado
     */
    public void setQtdeSustentaveis(int iSustentaveis) {
        
        switch (iSustentaveis) {
            case 1:
                this.respQtdeSustentaveis = new Resposta(10, -15.0f);
                break;
            case 2:
                this.respQtdeSustentaveis = new Resposta(6, -7.5f);
                break;
            case 3:
                this.respQtdeSustentaveis = new Resposta(3, 0.0f);
                break;
            default:
                break;
        }
    }
    
    /**
     * Quantidade medida em unidades. 
     * Foi adotado como padrão que a pessoa compra pelo menos, no periodo determinado, o equivalente a: 1 camiseta, 1 jeans, 1 jaqueta, 1 vestido e 1 short.
     * TODO: Multiplicar a quantidade por cada uma das regras especificas a baixo
     * REGRA ESPECÍFICA: 1 Camiseta - 40kgCO2. 1 Calça Jeans - 160 kgCO2, 1 Jaqueta - 80kgCO2, 1 Vestido - 70kgCO2, 1 Shorts - 100kgCO2 
     * REGRA GLOBAL (água): 1 Calça jeans - 10mil Litros, 1 Camiseta - 2.495 litros, 1 Jaqueta - 6.000 litros, 1  Vestido - 5.850 litros e 1 Shorts - 7 mil litros.
     * @param iFrequencia Valor do radio button digitado
     */
    public void setFrequenciaCompraRoupas(int iFrequencia) {
        
        switch (iFrequencia) {
            case 1:
                // Se a pessoa compra mensalmente, ao decorrer de um semestre ela consome 6 vezes este valor
                this.respFreqCompraRoupas = new Resposta(3, 6.0f);
                break;
            case 2:
                // Se a pessoa compra trimestralmente, ao decorrer de um semestre ela consome 2 vezes este valor
                this.respFreqCompraRoupas = new Resposta(6, 2.0f);
                break;
            case 3:
                // Se a pessoa compra semestralmente, ao decorrer de um semestre ela consome 1 vez este valor
                this.respFreqCompraRoupas = new Resposta(10, 1.0f);
                break;
            default:
                break;
        }
    }
}
