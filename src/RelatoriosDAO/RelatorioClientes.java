/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RelatoriosDAO;

import conexoes.ConexaoMySql;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author levi
 */
public class RelatorioClientes extends ConexaoMySql{
    
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
            //String caminhoRelatorio1 = "relatorios/relatorioClientes.jasper";
            Map parametro = new HashMap();
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/relatorioClientes.jasper");
            //JasperReport caminhoRelatorio = (JasperReport) JRLoader.loadObject("relatorios/relatorioClientes.jasper");
            
            JasperPrint jasperPrint =  JasperFillManager.fillReport(caminhoRelatorio, parametro, jrRS);
            
            //JasperViewer jrviewer = new JasperViewer(jasperPrint, false);
            //jrviewer.setVisible(true);  
            
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Users/levif/Documents/NetBeansProjects/Controle_Estoque_Venda2/rel/relatorio.pdf");
            
            File file = new File("C:/Users/levif/Documents/NetBeansProjects/Controle_Estoque_Venda2/rel/relatorio.pdf");
            
            try {
                Desktop.getDesktop().print(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
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
