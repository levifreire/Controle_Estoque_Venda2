/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import model.ModelClientes;

/**
 *
 * @author 344171019
 */
public class DAOClientes extends ConexaoMySql{
    
    /**
     * SALVAR PRODUTO NO BANCO
     * @param pModelCliente
     * @return 
     */
    public int salvarClienteDAO(ModelClientes pModelCliente){
        
        try {
            
            this.conectar();
            
            return this.insertSQL("INSERT INTO tb_clientes ("
                    + "cli_nome, "
                    + "cli_endereco, "
                    + "cli_bairro, "
                    + "cli_cidade, "
                    + "cli_uf, "
                    + "cli_cep, "
                    + "cli_telefone, "
                    + ") VALUES ("
                        + "'" + pModelCliente.getCliNome() + "', "
                        + "'" + pModelCliente.getCliEndereco()+ "', "
                        + "'" + pModelCliente.getCliBairro()+ "', "
                        + "'" + pModelCliente.getCliUF()+ "', "
                        + "'" + pModelCliente.getCliCEP()+ "', "
                        + "'" + pModelCliente.getCliTelefone() + "', "
                        
                    
                    
            );
            
        } catch (Exception e) {
            return 0;
        } finally {
            this.fecharConexao();
        }
        
    }
    
    public boolean excluirClienteDAO(pIdCliente){
        
    }
    
}
