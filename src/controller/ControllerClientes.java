/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOClientes;
import java.io.IOException;

/**
 *
 * @author levi
 */
public class ControllerClientes {
    
    DAOClientes daoClientes = new DAOClientes();
    
    public boolean relatorioClienteController() throws IOException{
        return this.daoClientes.gerarRelatorio();
    }
    
}
