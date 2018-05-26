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
public class Resposta {
    
    private float quantidadeValor;
    private int pontuacao;

    public float getQuantidadeValor() {
        return quantidadeValor;
    }

    public void setQuantidadeValor(float quantidadeValor) {
        this.quantidadeValor = quantidadeValor;
    }

    public float getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
    
    public Resposta(int iPontuacao, float fQtdeValor) {
        super();
        
        this.quantidadeValor = fQtdeValor;
        this.pontuacao = iPontuacao;
    }
    
}
