/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import RelatoriosDAO.RelatorioClientes;
import java.io.IOException;

/**
 *
 * @author levi
 */
public class ControllerRelatorios {
    
    private RelatorioClientes relatorioClientes = new RelatorioClientes();
    
    public boolean relatorioClienteController() throws IOException{
        return this.relatorioClientes.gerarRelatorio();
    }
    
}
