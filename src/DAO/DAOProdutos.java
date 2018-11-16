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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import static java.util.Objects.hash;
import model.ModelProdutos;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author levi
 */
public class DAOProdutos extends ConexaoMySql {
    
    /**
     * SALVAR PRODUTO NO BANCO
     * @param pModelProdutos
     * @return int
     */
    public int salvarProdutosDAO(ModelProdutos pModelProdutos){
       
        
        try {
            this.conectar();
            
            return this.insertSQL(
            "INSERT INTO tb_produto ("
            + "pk_id_produto, "
            + "pro_nome, "
            + "pro_valor, "
            + "pro_valor_final, "
            + "pro_estoque, "
            + "pro_validade"
            + ") VALUES ("
                    + "'" + pModelProdutos.getIdProduto() + "', "
                    + "'" + pModelProdutos.getProNome()+ "', "
                    + "'" + pModelProdutos.getProValorEntrada() + "', "
                    + "'" + pModelProdutos.getProValorSaida() + "', "
                    + "'" + pModelProdutos.getProEstoque() + "', "
                    + "'" + pModelProdutos.getProValidade() + "');"
                    
            );
        } catch (Exception e) {
            return 0;
            
        } finally {
            this.fecharConexao();
        }
        
    }
    
    /**
     * EXCLUIR PRODUTO NO BANCO
     * @param pIdProduto
     * @return 
     */
    public boolean excluirProdutoDAO(int pIdProduto){
        
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tb_produto WHERE pk_id_produto = '" + pIdProduto + "'" 
                    );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
            
        } finally{
            this.fecharConexao();
        }
    }
    
    /**
     * ALTERAR PRODUTO NO BANCO
     * @param pModelProduto
     * @return 
     */
    public boolean alterarProdutoDAO(ModelProdutos pModelProduto){
        
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tb_produto SET "
                    + "pro_nome = '" +pModelProduto.getProNome()+ "', "
                    + "pro_valor = '" +pModelProduto.getProValorEntrada()+"', "
                    + "pro_valor_final = '" +pModelProduto.getProValorSaida()+ "', "
                    + "pro_estoque = '" +pModelProduto.getProEstoque()+ "', "
                    + "pro_validade = '" +pModelProduto.getProValidade()+ "' "
                    + "WHERE pk_id_produto = " +pModelProduto.getIdProduto()+ ";");
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    /**
     * RETORNAR UM PRODUTO DO BANCO
     * @param pIdProduto
     * @return 
     */
    public ModelProdutos retornarUmProdutoDAO(int pIdProduto){
        
        ModelProdutos modelProduto = new ModelProdutos();
        
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_produto, "
                    + "pro_nome, "
                    + "pro_valor, "
                    + "pro_valor_final, "
                    + "pro_estoque, "
                    + "pro_validade "
                    + "FROM tb_produto WHERE pk_id_produto = " +pIdProduto+ ";"
            );
            
             while (this.getResultSet().next()) {     
                 
                modelProduto.setIdProduto(this.getResultSet().getInt(1));
                modelProduto.setProNome(this.getResultSet().getString(2));
                modelProduto.setProValorEntrada(this.getResultSet().getDouble(3));
                modelProduto.setProValorSaida(this.getResultSet().getDouble(4));
                modelProduto.setProEstoque(this.getResultSet().getInt(5));
                modelProduto.setProValidade(this.getResultSet().getDate(6));
                
        }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            this.fecharConexao();
        }
            
       return modelProduto;
    }
    
    /**
     * RETORNAR UMA LISTA DE PRODUTOS
     * @return 
     */
    public ArrayList<ModelProdutos> listarProdutosDAO(){
        ArrayList<ModelProdutos> listaModelProdutos = new ArrayList<>();
        ModelProdutos modelProduto = new ModelProdutos();
        
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_produto, "
                    + "pro_nome, "
                    + "pro_valor, "
                    + "pro_valor_final, "
                    + "pro_estoque, "
                    + "pro_validade "
                    + "FROM tb_produto");
            
            while (this.getResultSet().next()) {     
                modelProduto = new ModelProdutos();
                
                modelProduto.setIdProduto(this.getResultSet().getInt(1));
                modelProduto.setProNome(this.getResultSet().getString(2));
                modelProduto.setProValorEntrada(this.getResultSet().getDouble(3));
                modelProduto.setProValorSaida(this.getResultSet().getDouble(4));
                modelProduto.setProEstoque(this.getResultSet().getInt(5));
                modelProduto.setProValidade(this.getResultSet().getDate(6));
                
                listaModelProdutos.add(modelProduto);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        
        return listaModelProdutos;
    }
    
    
}
