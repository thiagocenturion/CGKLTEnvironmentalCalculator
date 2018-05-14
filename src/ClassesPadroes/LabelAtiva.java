/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesPadroes;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author thiagocenturion
 */
public class LabelAtiva extends JLabel {
    
    private Color tinta;
    public Color getTinta() {
        return tinta;
    }
    public void setTinta(Color tinta) {
        this.tinta = tinta;
    }
    
    private boolean ativa;
    public boolean isAtiva() {
        return ativa;
    }
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
        
        // Atualiza estado atual da label
        atualizaEstadoAtivacao();
    }
    
    // Construtor padrão
    public LabelAtiva() {
 
        // Sobrecarga do construtor principal sem passar nenhuma cor de tinta
        this( null );
    }
    
    // Construtor principal
    public LabelAtiva( Color tinta ) {
        
        super();
        
        // Caso tenhamos uma tinta
        if ( tinta != null ) {
            
            // Guardamos o valor para ser utilizada no toggle de ativação da label
            this.tinta = tinta;
        }
        
        // Inicialmente não está ativa
        this.ativa = false;
        atualizaEstadoAtivacao();
        
        // Fonte da label
        this.setFont(new java.awt.Font("Myriad Pro", Font.PLAIN, 18)); // NOI18N
    }
    
    private void atualizaEstadoAtivacao() {
        
        // Se configurou para ativar
        if ( this.ativa == true ) {
            
            // Altera sua cor para aquela atribuida na construção, caso exista
            if ( this.tinta != null ) {
                
                this.setForeground(this.tinta);
                
            } else {
                
                // Atribui valor padrão
                this.setForeground(Color.BLACK);
            }
            
        } else {
            
            // Como está desativada, a cor é cinza
            this.setForeground( new Color(211, 211, 211) );
        }
    }
}
