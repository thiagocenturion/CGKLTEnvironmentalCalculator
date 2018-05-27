/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author thiagocenturion
 */
public class Calculadora {
    
    
    private int pontuacao;
    private float resultadoAgua;
    private Map<String, Resposta[]> mapSaidaResultados;
    private String consciencia;
    private Color corConsciencia;
    
    public Integer getPontuacao() {
        return pontuacao;
    }
    
    public Map<String, Resposta[]> getResultados() {
        return mapSaidaResultados;
    }
    
    public String getConsciencia() {
        String sRetorno = "";
        
        // Se a pontuação estiver entre 61% a 100%, é um consumidor consciente
        if ( this.pontuacao > 60.0f && this.pontuacao <= 100.0f ) {
            sRetorno = "Consciente";
        }
        // Se a pontuação estiver entre 31% a 60%, é um consumidor indiferente
        else if ( this.pontuacao > 30.0f && this.pontuacao <= 60.0f ) {
            sRetorno = "Indiferente";
        }
        // Se a pontuação estiver entre 0% a 30%, é um consumidor não consciente
        else if ( this.pontuacao <= 30.0f ) {
            sRetorno = "Não Consciente";
        }
        
        return sRetorno;
    }
    
    public Color getCorConsciencia() {
        Color colorRetorno = null;
        
        // Se a pontuação estiver entre 61% a 100%, a cor é verde
        if ( this.pontuacao > 60.0f && this.pontuacao <= 100.0f ) {
            colorRetorno = new Color(0, 153, 102);
        }
        // Se a pontuação estiver entre 31% a 60%, a cor é amarela
        else if ( this.pontuacao > 30.0f && this.pontuacao <= 60.0f ) {
            colorRetorno = new Color(204, 204, 0);
        }
        // Se a pontuação estiver entre 0% a 30%, a cor é vermelha
        else if ( this.pontuacao <= 30.0f ) {
            colorRetorno = new Color(204, 0, 51);
        }
        
        return colorRetorno;
    }
    
    public void estimarResultados(Map<String, Object> mapEntradaModels) {
        
        Resposta resultadoAux = null;
        int iPontuacaoTotalAux = 0;
        float fQuantidadeAux = 0.0f;
        this.pontuacao = 0;
        this.resultadoAgua = 0.0f;
        int iTotalPontuacao = 0;
        float fAux = 0.0f;
        Resposta[] arrResultados;
        
        // Instancia do Map que obterá os resultados de saída
        this.mapSaidaResultados = new HashMap<>();
        
        // Obtem os modelos
        Models.ModelFolhas modelFolhas = (Models.ModelFolhas) mapEntradaModels.get(GerenciadorDados.FOLHAS);
        Models.ModelAutomoveis modelAutomoveis = (Models.ModelAutomoveis) mapEntradaModels.get(GerenciadorDados.AUTOMOVEIS);
        Models.ModelEletronicos modelEletronicos = (Models.ModelEletronicos) mapEntradaModels.get(GerenciadorDados.ELETRONICOS);
        Models.ModelRoupas modelRoupas = (Models.ModelRoupas) mapEntradaModels.get(GerenciadorDados.ROUPAS);
        Models.ModelAlimentos modelAlimentos = (Models.ModelAlimentos) mapEntradaModels.get(GerenciadorDados.ALIMENTOS);
        
        // Caso tenha pegado o modelo de folhas
        if ( modelFolhas != null ) {
            
            // Soma a contagem dos pontos
            iPontuacaoTotalAux = modelFolhas.getRespSegundaVia().getPontuacao();
            iPontuacaoTotalAux += modelFolhas.getRespFaturas().getPontuacao();
            iPontuacaoTotalAux += modelFolhas.getRespCadernos().getPontuacao();
            
            // Faz a iteração da pontuação geral
            iTotalPontuacao += iPontuacaoTotalAux;
            
            // Cria a instância de 'Resposta' passando como pontuacao o seu valor em PERCENTUAL sobre seu desempenho no tema
            // A pontuação é em relação ao valor máximo possivel das questões, que é 30, e estamos trabalhando com arredondamento para armazenar em tipo de dado INT
            resultadoAux = new Resposta();
            resultadoAux.setPontuacao( (iPontuacaoTotalAux * 100) / 30 );
            
            // Como a quantidade total de folhas possui a mesma unidade de medida da regra específica, então apenas
            // somamos tudo e adicionamos na sua fórmula
            fQuantidadeAux = modelFolhas.getRespSegundaVia().getQuantidadeValor();
            fQuantidadeAux += modelFolhas.getRespFaturas().getQuantidadeValor();
            fQuantidadeAux += modelFolhas.getRespCadernos().getQuantidadeValor();
            
            // Regra Específica: A cada um A4 gasta 0,013% de uma arvore de eucalipto
            resultadoAux.setQuantidadeValor( fQuantidadeAux * 0.013f );
            
            // Calcula a regra global (água): A cada um A4 gasta 10 L de agua
            this.resultadoAgua += fQuantidadeAux * 10.0f;
            
            // Adiciona o resultado das folhas dentro do map
            this.mapSaidaResultados.put(GerenciadorDados.FOLHAS, new Resposta[]{resultadoAux});
        }
        
        // Caso tenha pegado o modelo de automoveis
        if ( modelAutomoveis != null ) {
            
            // Soma a contagem dos pontos
            iPontuacaoTotalAux = modelAutomoveis.getRespQtdeAutomoveis().getPontuacao();
            iPontuacaoTotalAux += modelAutomoveis.getRespSairCarro().getPontuacao();
            iPontuacaoTotalAux += modelAutomoveis.getRespTipoCombustivel().getPontuacao();
            
            // Faz a iteração da pontuação geral
            iTotalPontuacao += iPontuacaoTotalAux;
            
            // Cria a instância de 'Resposta' passando como pontuacao o seu valor em PERCENTUAL sobre seu desempenho no tema
            // A pontuação é em relação ao valor máximo possivel das questões, que é 30, e estamos trabalhando com arredondamento para armazenar em tipo de dado INT
            resultadoAux = new Resposta();
            resultadoAux.setPontuacao( (iPontuacaoTotalAux * 100) / 30 );
            
            /**
            * Quantidade medida em Litros para cada 1h de percurso. Foi adotado como padrão que a pessoa possua um carro popular de motor 1.0.
            * Multiplica esta quantidade pela quantidade de 'respSairCarro' antes de entrar na regra especifica.
            */
            fQuantidadeAux = modelAutomoveis.getRespTipoCombustivel().getQuantidadeValor();
            
            // Obtem-se os litros totais
            fQuantidadeAux = fQuantidadeAux * modelAutomoveis.getRespSairCarro().getQuantidadeValor();
            
            // Regra Específica: Gasolina 2,55 KgCO2/L - Diesel 3,37 KgCO2/L - Etanol 0,55 KgCO2/L
            // Obtem o valor total em Kg de CO2
            // Se a pontuação é 10, significa que escolheu ETANOL
            if ( modelAutomoveis.getRespTipoCombustivel().getPontuacao() == 10 ) {
                fQuantidadeAux = fQuantidadeAux * 0.55f;
            }
            // Se a pontuação é 6, significa que escolheu GASOLINA
            else if ( modelAutomoveis.getRespTipoCombustivel().getPontuacao() == 6 ) {
                fQuantidadeAux = fQuantidadeAux * 2.55f;
            }
            // Se a pontuação é 3, significa que escolheu DIESEL
            else if ( modelAutomoveis.getRespTipoCombustivel().getPontuacao() == 3 ) {
                fQuantidadeAux = fQuantidadeAux * 3.37f;
            }
            
            // Agora multiplica este valor pela quantidade de carros que ela possui
            resultadoAux.setQuantidadeValor( fQuantidadeAux * modelAutomoveis.getRespQtdeAutomoveis().getQuantidadeValor() );
            
            // Calcula a regra global (água): 13 L / km
            // Obtem a quantidade total de horas que a pessoa dirige e multiplica por uma média de 50 km/h, para cada carro que ela possui
            this.resultadoAgua += modelAutomoveis.getRespSairCarro().getQuantidadeValor() * 50.0f * modelAutomoveis.getRespQtdeAutomoveis().getQuantidadeValor();
            
            // Adiciona o resultado dentro do map
            this.mapSaidaResultados.put(GerenciadorDados.AUTOMOVEIS, new Resposta[]{resultadoAux});
        }
        
        // Caso tenha pegado o modelo de eletronicos
        if ( modelEletronicos != null ) {
            
            // Soma a contagem dos pontos
            iPontuacaoTotalAux = modelEletronicos.getRespQtdeCelulares().getPontuacao();
            iPontuacaoTotalAux += modelEletronicos.getRespQtdeComputadores().getPontuacao();
            iPontuacaoTotalAux += modelEletronicos.getRespQtdeTV().getPontuacao();
            
            // Faz a iteração da pontuação geral
            iTotalPontuacao += iPontuacaoTotalAux;
            
            // Cria a instância de 'Resposta' passando como pontuacao o seu valor em PERCENTUAL sobre seu desempenho no tema
            // A pontuação é em relação ao valor máximo possivel das questões, que é 30, e estamos trabalhando com arredondamento para armazenar em tipo de dado INT
            resultadoAux = new Resposta();
            resultadoAux.setPontuacao( (iPontuacaoTotalAux * 100) / 30 );
            
            // Como a quantidade total de TVs, computadores e notebooks possui a mesma unidade de medida da regra específica, então apenas
            // somamos e adicionamos na sua fórmula
            fQuantidadeAux = modelEletronicos.getRespQtdeTV().getQuantidadeValor();
            fQuantidadeAux += modelEletronicos.getRespQtdeComputadores().getQuantidadeValor();
            
            // Regra Específica: 1 TV/computador/notebook - 240kg combustivel fossil
            resultadoAux.setQuantidadeValor( fQuantidadeAux * 240.0f );
            
            // Instancia um array novo já que precisaremos de mais de uma resposta para esta seção (2 respostas)
            // Indice 1 : Combustivel fóssil em Kg
            // Indice 2 : CO2 em Kg
            arrResultados = new Resposta[2];
            arrResultados[1] = resultadoAux;
            
            // Cria uma nova instância de 'Resposta', agora para o resultado em CO2 dos celulares
            // Passa como pontuacao o seu valor em PERCENTUAL novamente, pois continua o mesmo
            resultadoAux = new Resposta();
            resultadoAux.setPontuacao( (iPontuacaoTotalAux * 100) / 30 );
            
            // Regra Específica para celulares: 16 Kg de CO2 por 1 smartphone
            fQuantidadeAux = modelEletronicos.getRespQtdeCelulares().getQuantidadeValor();
            resultadoAux.setQuantidadeValor( fQuantidadeAux * 16.0f );
            
            // Indice 2 : CO2 em Kg
            arrResultados[2] = resultadoAux;
            
            // Calcula a regra global (água) 1 : 1.500kg por 1 notebook/computador ou por 1 TV
            // Como a densidade da água é 0,997kg/L, então 1.500kg de água = 1.504,5 L por 1 notebook/computador ou por 1 TV
            this.resultadoAgua += 1504.5f * (modelEletronicos.getRespQtdeComputadores().getQuantidadeValor() + modelEletronicos.getRespQtdeTV().getQuantidadeValor());
            
            // Calcula a regra global (água) 2 : 12.760 L por 1 Smartphone
            this.resultadoAgua += modelEletronicos.getRespQtdeCelulares().getQuantidadeValor() * 12760.0f;
            
            // Adiciona o resultado dentro do map
            this.mapSaidaResultados.put(GerenciadorDados.ELETRONICOS, arrResultados);
        }
        
        // Caso tenha pegado o modelo de roupas
        if ( modelRoupas != null ) {
            
            // Soma a contagem dos pontos
            iPontuacaoTotalAux = modelRoupas.getRespFreqCompraRoupas().getPontuacao();
            iPontuacaoTotalAux += modelRoupas.getRespQtdeJeans().getPontuacao();
            iPontuacaoTotalAux += modelRoupas.getRespQtdeSustentaveis().getPontuacao();
            
            // Cria a instância de 'Resposta' passando como pontuacao o seu valor em PERCENTUAL sobre seu desempenho no tema
            // A pontuação é em relação ao valor máximo possivel das questões, que é 30, e estamos trabalhando com arredondamento para armazenar em tipo de dado INT
            resultadoAux = new Resposta();
            resultadoAux.setPontuacao( (iPontuacaoTotalAux * 100) / 30 );
            
            // Faz a iteração da pontuação geral
            iTotalPontuacao += iPontuacaoTotalAux;
            
            // Adiciona o resultado dentro do map
            this.mapSaidaResultados.put(GerenciadorDados.ROUPAS, new Resposta[]{resultadoAux});
        }
        
        // Caso tenha pegado o modelo de alimentos
        if ( modelAlimentos != null ) {
            
            // Soma a contagem dos pontos
            iPontuacaoTotalAux = modelAlimentos.getRespFreqRefeicaoCarne().getPontuacao();
            iPontuacaoTotalAux += modelAlimentos.getRespMassaCarne().getPontuacao();
//            iPontuacaoTotalAux += modelAlimentos.getRespQtdeSustentaveis().getPontuacao();
            
            // Cria a instância de 'Resposta' passando como pontuacao o seu valor em PERCENTUAL sobre seu desempenho no tema
            // A pontuação é em relação ao valor máximo possivel das questões, que é 30, e estamos trabalhando com arredondamento para armazenar em tipo de dado INT
            resultadoAux = new Resposta();
            resultadoAux.setPontuacao( (iPontuacaoTotalAux * 100) / 30 );

            // Faz a iteração da pontuação geral
            iTotalPontuacao += iPontuacaoTotalAux;
            
            // Adiciona o resultado dentro do map
            this.mapSaidaResultados.put(GerenciadorDados.ALIMENTOS, new Resposta[]{resultadoAux});
        }
        
        // Monta a pontuação, de valor em PERCENTUAL, sobre seu desempenho total de todos os temas
        // A pontuação é em relação ao valor máximo possivel das questões, que ao total é 150, e estamos trabalhando com arredondamento para armazenar em tipo de dado INT
        this.pontuacao = (iTotalPontuacao * 100) / 150;
    }
}
