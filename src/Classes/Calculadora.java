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
    private Map<String, Resposta> mapSaidaResultados;
    private String consciencia;
    private Color corConsciencia;
    
    public Integer getPontuacao() {
        return pontuacao;
    }
    
    public Map<String, Resposta> getResultados() {
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
            this.mapSaidaResultados.put(GerenciadorDados.FOLHAS, resultadoAux);
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
            
            // Adiciona o resultado dentro do map
            this.mapSaidaResultados.put(GerenciadorDados.AUTOMOVEIS, resultadoAux);
        }
        
        // Caso tenha pegado o modelo de eletronicos
        if ( modelEletronicos != null ) {
            
            // Soma a contagem dos pontos
            iPontuacaoTotalAux = modelEletronicos.getRespQtdeCelulares().getPontuacao();
            iPontuacaoTotalAux += modelEletronicos.getRespQtdeComputadores().getPontuacao();
//            iPontuacaoTotalAux += modelEletronicos.getRespQtdeEletronicos().getPontuacao();
            
            // Faz a iteração da pontuação geral
            iTotalPontuacao += iPontuacaoTotalAux;
            
            // Cria a instância de 'Resposta' passando como pontuacao o seu valor em PERCENTUAL sobre seu desempenho no tema
            // A pontuação é em relação ao valor máximo possivel das questões, que é 30, e estamos trabalhando com arredondamento para armazenar em tipo de dado INT
            resultadoAux = new Resposta();
            resultadoAux.setPontuacao( (iPontuacaoTotalAux * 100) / 30 );
            
            // Adiciona o resultado dentro do map
            this.mapSaidaResultados.put(GerenciadorDados.ELETRONICOS, resultadoAux);
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
            this.mapSaidaResultados.put(GerenciadorDados.ROUPAS, resultadoAux);
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
            this.mapSaidaResultados.put(GerenciadorDados.ALIMENTOS, resultadoAux);
        }
        
        // Monta a pontuação, de valor em PERCENTUAL, sobre seu desempenho total de todos os temas
        // A pontuação é em relação ao valor máximo possivel das questões, que ao total é 150, e estamos trabalhando com arredondamento para armazenar em tipo de dado INT
        this.pontuacao = (iTotalPontuacao * 100) / 150;
    }
}
