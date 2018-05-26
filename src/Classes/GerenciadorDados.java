/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Models.ModelFolhas;
import Models.ModelAutomoveis;
import Models.ModelEletronicos;
import Models.ModelRoupas;
import Models.ModelAlimentos;

/**
 *
 * @author thiagocenturion
 */
public class GerenciadorDados {
    
    private ModelFolhas modelFolhas;
    private ModelAutomoveis modelAutomoveis;
    private ModelEletronicos modelEletronicos;
    private ModelRoupas modelRoupas;
    private ModelAlimentos modelAlimentos;

    public ModelEletronicos getModelEletronicos() {
        return modelEletronicos;
    }

    public void setModelEletronicos(ModelEletronicos modelEletronicos) {
        this.modelEletronicos = modelEletronicos;
    }

    public ModelRoupas getModelRoupas() {
        return modelRoupas;
    }

    public void setModelRoupas(ModelRoupas modelRoupas) {
        this.modelRoupas = modelRoupas;
    }

    public ModelAlimentos getModelAlimentos() {
        return modelAlimentos;
    }

    public void setModelAlimentos(ModelAlimentos modelAlimentos) {
        this.modelAlimentos = modelAlimentos;
    }

    public ModelFolhas getModelFolhas() {
        return modelFolhas;
    }

    public void setModelFolhas(ModelFolhas modelFolhas) {
        this.modelFolhas = modelFolhas;
    }

    public ModelAutomoveis getModelAutomoveis() {
        return modelAutomoveis;
    }

    public void setModelAutomoveis(ModelAutomoveis modelAutomoveis) {
        this.modelAutomoveis = modelAutomoveis;
    }
    
}
