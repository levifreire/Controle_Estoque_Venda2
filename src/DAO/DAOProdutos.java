/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelProdutos;

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
            + "pk_idProduto, "
            + "produtoNome, "
            + "produtoValorEntrada, "
            + "produtoValorSaida, "
            + "produtoEstoque, "
            + "produtoValidade"
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
                    "DELETE FROM tb_produto WHERE pk_idProduto = '" + pIdProduto + "'" 
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
                    + "produtoNome = '" +pModelProduto.getProNome()+ "', "
                    + "produtoValorEntrada = '" +pModelProduto.getProValorEntrada()+"', "
                    + "produtoValorSaida = '" +pModelProduto.getProValorSaida()+ "', "
                    + "produtoEstoque = '" +pModelProduto.getProEstoque()+ "', "
                    + "produtoValidade = '" +pModelProduto.getProValidade()+ "'"
                    + "WHERE pk_idProduto = " +pModelProduto.getIdProduto()+ ";");
            
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
                    + "pk_idProduto, "
                    + "produtoNome, "
                    + "produtoValorEntrada, "
                    + "produtoValorSaida, "
                    + "produtoEstoque, "
                    + "produtoValidade "
                    + "FROM tb_produto WHERE pk_idProduto = " +pIdProduto+ ";"
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
                    + "PK_idProduto, "
                    + "produtoNome, "
                    + "produtoValorEntrada, "
                    + "produtoValorSaida, "
                    + "produtoEstoque, "
                    + "produtoValidade FROM tb_produto");
            
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
