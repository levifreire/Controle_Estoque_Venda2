/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import model.ModelClientes;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

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
                    + "cli_cpf"
                    + ") VALUES ("
                        + "'" + pModelCliente.getCliNome() + "', "
                        + "'" + pModelCliente.getCliEndereco()+ "', "
                        + "'" + pModelCliente.getCliBairro()+ "', "
                        + "'" + pModelCliente.getCliUF()+ "', "
                        + "'" + pModelCliente.getCliCEP()+ "', "
                        + "'" + pModelCliente.getCliTelefone() + "'"                    
                    
            );
            
        } catch (Exception e) {
            return 0;
        } finally {
            this.fecharConexao();
        }
        
    }
    
    public boolean gerarRelatorio() throws IOException{
        
        try {
            
            this.conectar();
            this.executarSQL("SELECT "
                    + "tb_clientes.pk_id_cliente AS tb_clientes_pk_id_cliente, "
                    + "tb_clientes.cli_nome AS tb_clientes_cli_nome, "
                    + "tb_clientes.cli_endereco AS tb_clientes_cli_endereco, "
                    + "tb_clientes.cli_bairro AS tb_clientes_cli_bairro, "
                    + "tb_clientes.cli_cidade AS tb_clientes_cli_cidade, "
                    + "tb_clientes.cli_uf AS tb_clientes_cli_uf, "
                    + "tb_clientes.cli_cep AS tb_clientes_cli_cep, "
                    + "tb_clientes.cli_telefone AS tb_clientes_cli_telefone, "
                    + "tb_clientes.cli_cpf AS tb_clientes_cli_cpf "
                        + "FROM tb_clientes");
            
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            //String caminhoRelatorio = 
            
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioCliente.jasper");
            
            JasperPrint jasperPrint =  JasperFillManager.fillReport(caminhoRelatorio, new HashMap<>(), jrRS);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Users/levi/Documents/NetBeansProjects/Controle_Estoque_Venda2/relatorio.pdf");
            
            File file = new File("C:/Users/levi/Documents/NetBeansProjects/Controle_Estoque_Venda2/relatorio.pdf");
            
            try {
                
            } catch (Exception e) {
                Desktop.getDesktop().print(file);
            }
            file.deleteOnExit();
            return true;
        } catch (JRException e){
            e.printStackTrace();
            return false;
        }finally {
            this.fecharConexao();
        }
        
    }
    
   
    
}
