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
     * Quantidade medida em média entre as duas opções dadas dentro de uma mesma alternativa (exemplo: "3 a 5" a quantidade utilizada é 4).
     * REGRA ESPECÍFICA: Vida util de 1 Automóvel - 361,1Kg de CO2
     * REGRA GLOBAL: Massa do automóvel x 13 litros de agua x quantidade = total de agua gasto
     * @param iAutomoveis Valor do radio button digitado
     */
    public void setOpcaoAutomoveis(int iAutomoveis) {
                
        switch (iAutomoveis) {
            case 1:
                // Sua pontuação é máxima e a quantidade é mínima
                this.respQtdeAutomoveis = new Resposta(10, 0.0f);
                break;
            case 2:
                // Sua pontuação é média e a quantidade é média
                this.respQtdeAutomoveis = new Resposta(6, 1.5f);
                break;
            case 3:
                // Sua pontuação é minima e a quantidade é máxima
                this.respQtdeAutomoveis = new Resposta(3, 4.0f);
                break;
            default:
                break;
        }
    }
    
    /**
     * Quantidade medida em horas. Foi adotado como padrão que a cada viagem de ida ou volta dura em média 1 hora e 30 min.
     * REGRA ESPECÍFICA: Gasolina 2,55 KgCO2/L - Diesel 3,37 KgCO2/L - Etanol 0,55 KgCO2/L
     * REGRA GLOBAL (água): 13 L / km
     * @param iSairCarro Valor do radio button digitado
     */
    public void setOpcaoSairCarro(int iSairCarro) {
        
        float fHorasPorPercurso = 1.5f;
        int iViagensPorDia;
        int iDias; // Quantos dias possui a opção selecionada (fim de semana são 2, dias de semana são 5).
        
        switch (iSairCarro) {
            case 1:
                // Dias de semanas consideramos 1 viagem com ida (1h30) e volta (1h30)
                // Uso moderado (nota mediana)
                iViagensPorDia = 2;
                iDias = 5;
                this.respSairCarro = new Resposta(6, iDias * iViagensPorDia * fHorasPorPercurso);
                break;
            case 2:
                // Finais de semanas consideramos 1 viagem com ida (1h30) e volta (1h30)
                // Uso consciente (nota alta)
                iViagensPorDia = 2;
                iDias = 2;
                this.respSairCarro = new Resposta(10, iDias * iViagensPorDia * fHorasPorPercurso);
                break;
            case 3:
                // Saindo a semana inteira consideramos 1 viagem com ida (1h30) e volta (1h30)
                // Uso exacerbado (nota baixa)
                iViagensPorDia = 2;
                iDias = 7;
                this.respSairCarro = new Resposta(3, iDias * iViagensPorDia * fHorasPorPercurso);
                break;
            default:
                break;
        }
    }
    
    /**
     * Quantidade medida em Litros para cada 1h de percurso. Foi adotado como padrão que a pessoa possua um carro popular de motor 1.0.
     * TODO: É necessário multiplicar esta quantidade pela quantidade de 'respSairCarro' antes de entrar na regra especifica.
     * REGRA ESPECÍFICA: Gasolina 2,55 KgCO2/L - Diesel 3,37 KgCO2/L - Etanol 0,55 KgCO2/L
     * REGRA GLOBAL (água): 13 L / km
     * @param iCombustivel Valor do radio button digitado
     */
    public void setOpcaoTipoCombustivel(int iCombustivel) {
        
        float fKmPorPercurso = 50.0f; // Kilometragem média por percurso de 1h (50km/h)
        float fKmPorLitro; // Km/L para cada tipo de combustivel. Carro utilizado para cálculo, com fonte em http://www.inmetro.gov.br/consumidor/pbe/veiculos_leves_2017.pdf: HB20 Hyundai Compacto Style Flex com câmbio manual M-6
        
        switch (iCombustivel) {
            case 1:
                // Gasolina polui mas não tanto quanto diesel (nota mediana)
                // Gasto: 11,6 km/L
                fKmPorLitro = 11.6f;
                this.respTipoCombustivel = new Resposta(6, fKmPorPercurso / fKmPorLitro);
                break;
            case 2:
                // Etanol é o mais renovável e polui menos (nota alta)
                // Gasto: 8,1 km/L
                fKmPorLitro = 8.1f;
                this.respTipoCombustivel = new Resposta(10, fKmPorPercurso / fKmPorLitro);
                break;
            case 3:
                // Diesel é o mais poluente (nota baixa)
                // Gasto: 11,6 km/L
                fKmPorLitro = 11.6f;
                this.respTipoCombustivel = new Resposta(3, fKmPorPercurso / fKmPorLitro);
                break;
            default:
                break;
        }
    }
}
