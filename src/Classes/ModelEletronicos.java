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
public class ModelEletronicos {
    
    private Resposta respQtdeCelulares;
    private Resposta respQtdeComputadores;

    public Resposta getRespQtdeCelulares() {
        return respQtdeCelulares;
    }

    public Resposta getRespQtdeComputadores() {
        return respQtdeComputadores;
    }
    
    /**
     * Quantidade medida em unidades.
     * REGRA ESPECÍFICA: Gás Carbonico 1 smarphone - 16 kg
     * REGRA GLOBAL (água): 1 smartphone - 12760 L
     * @param iQtdeCelulares Valor do radio button digitado
     */
    public void setOpcaoQtdeCelulares(int iQtdeCelulares) {
        
        switch (iQtdeCelulares) {
            case 1:
                this.respQtdeCelulares = new Resposta(10, 1.0f);
                break;
            case 2:
                this.respQtdeCelulares = new Resposta(6, 2.5f);
                break;
            case 3:
                this.respQtdeCelulares = new Resposta(3, 5.0f);
                break;
            default:
                break;
        }
    }
    
    /**
     * Quantidade medida em unidades.
     * REGRA ESPECÍFICA: 1 computador - 240kg combustivel fossil e 22kg de produtos quimicos
     * REGRA GLOBAL (água): 1 computador - 1,5 toneladas de água
     * @param iQtdeComputadores Valor do radio button digitado
     */
    public void setOpcaoQtdeComputadores(int iQtdeComputadores) {
        
        switch (iQtdeComputadores) {
            case 1:
                this.respQtdeComputadores = new Resposta(10, 1.0f);
                break;
            case 2:
                this.respQtdeComputadores = new Resposta(6, 3.0f);
                break;
            case 3:
                this.respQtdeComputadores = new Resposta(3, 6.0f);
                break;
            default:
                break;
        }
    }
}
