/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author thiagocenturion
 */
public class GerenciadorDados {
    
    /**
     * Chaves de acesso
     */
    public static String FOLHAS = "FOLHAS";
    public static String AUTOMOVEIS = "AUTOMOVEIS";
    public static String ELETRONICOS = "ELETRONICOS";
    public static String ROUPAS = "ROUPAS";
    public static String ALIMENTOS = "ALIMENTOS";
    
    /**
     * Variável estática armazenada na memória para
     * gerenciar os dados de uma tela para outra
     */
    static private Map<String, Object> mapModels;
    
    public static Map<String, Object> getModels() {
        
        // Inicialização do tipo "folgada" (lazy initialization)
        if (mapModels == null) {
            
            // Caso ainda não exista o modelo, cria sua instância
            mapModels = new HashMap<>();
        }
        
        return mapModels;
    }
}
