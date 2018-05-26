/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author thiagocenturion
 */
public class GerenciadorDados {
    
    /**
     * Variável estática armazenada na memória para
     * gerenciar os dados de uma tela para outra
     */
    static private ArrayList arrModels;
    
    public static void setModels(ArrayList arrNewModels) {
        arrModels = arrNewModels;
    }
    
    public static ArrayList getModels() {
        
        // Inicialização do tipo "folgada" (lazy initialization)
        if (arrModels == null) {
            
            // Caso ainda não exista o modelo, cria sua instância
            arrModels = new ArrayList();
        }
        
        return arrModels;
    }
}
