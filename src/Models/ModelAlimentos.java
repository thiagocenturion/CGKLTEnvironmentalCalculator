/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Classes.Resposta;

/**
 *
 * @author thiagocenturion
 */
public class ModelAlimentos {
    
    private Resposta respMassaCarne;
    private Resposta respFreqRefeicaoCarne;
    private Resposta respMassaArroz;
    
    public Resposta getRespMassaCarne() {
        return respMassaCarne;
    }
    
    public Resposta getRespFreqRefeicaoCarne() {
        return respFreqRefeicaoCarne;
    }
    
    public Resposta getRespMassaArroz() {
        return respMassaArroz;
    }
    
    /**
     * Quantidade medida em Kg.
     * Multiplica a massa encontrada aqui pela frequencia de refeiçoes com carne
     * REGRA ESPECÍFICA: 1kg de carne - 225kg CO2
     * REGRA GLOBAL (água): 1 Kg de carne - 15 mil litros
     * @param iMassaCarne Valor do radio button digitado
     */
    public void setMassaCarne(int iMassaCarne) {
        
        switch (iMassaCarne) {
            case 1:
                // 110g = 0,11Kg
                this.respMassaCarne = new Resposta(10, 0.11f);
                break;
            case 2:
                // 220g = 0,22Kg
                this.respMassaCarne = new Resposta(6, 0.22f);
                break;
            case 3:
                // 440g = 0,44Kg
                this.respMassaCarne = new Resposta(3, 0.44f);
                break;
            default:
                break;
        }
    }
    
    /**
     * Quantidade medida em unidades de refeições.
     * Foi adotado como base que uma pessoa realiza 2 refeições com carnes por cada dia respondido.
     * REGRA ESPECÍFICA: 1kg de carne - 225kg CO2
     * REGRA GLOBAL (água): 1 Kg de carne - 15 mil litros
     * @param iFreqRefeicaoCarne Valor do radio button digitado
     */
    public void setFreqRefeicaoCarne(int iFreqRefeicaoCarne) {
        int iRefeicoesDiarias = 2;
        int iDias = 0;
        
        switch (iFreqRefeicaoCarne) {
            case 1:
                // Todos os dias da semana: 7 dias de refeições
                iDias = 7;
                this.respFreqRefeicaoCarne = new Resposta(3, iDias * iRefeicoesDiarias);
                break;
            case 2:
                // Algumas vezes na semana: média aproximada de 4 dias de refeições
                iDias = 4;
                this.respFreqRefeicaoCarne = new Resposta(6, iDias * iRefeicoesDiarias);
                break;
            case 3:
                // Raramente: média aproximada de 2 dias de refeições
                iDias = 2;
                this.respFreqRefeicaoCarne = new Resposta(10, iDias * iRefeicoesDiarias);
                break;
            default:
                break;
        }
    }
    
    /**
     * Quantidade medida em Kg.
     * Multiplica a massa encontrada aqui pela frequencia de refeiçoes com carne
     * REGRA GLOBAL (água): 0,1Kg de arroz - 260 litros
     * @param iMassaArroz Valor do radio button digitado
     */
    public void setMassaArroz(int iMassaArroz) {
        
        switch (iMassaArroz) {
            case 1:
                // Todas as refeiçõe: Pega todas as refeições que a pessoa faz. Cada porção de arroz é 100g
                this.respMassaArroz = new Resposta( 3, (this.respFreqRefeicaoCarne.getQuantidadeValor() * 0.1f) );
                break;
            case 2:
                // Metade as refeições: Pega todas as refeições que a pessoa faz e divide por 2. Cada porção de arroz é 100g
                this.respMassaArroz = new Resposta( 6, (this.respFreqRefeicaoCarne.getQuantidadeValor() * 0.1f) / 2 );
                break;
            case 3:
                // Nenhuma das refeições: 0
                this.respMassaArroz = new Resposta( 10, 0.0f );
                break;
            default:
                break;
        }
    }
}
