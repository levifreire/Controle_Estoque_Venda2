/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOProdutos;
import java.util.ArrayList;
import model.ModelProdutos;

/**
 *
 * @author levi
 */
public class ControllerProdutos {
    
    private DAOProdutos daoProdutos = new DAOProdutos();
    
    /**
     * SALVAR UM PRODUTO
     * @param pModelProduto
     * @return 
     */
    public int salvarProdutoController(ModelProdutos pModelProduto){
        return this.daoProdutos.salvarProdutosDAO(pModelProduto);
    }
    
    /**
     * EXCLUIR UM PRODUTO
     * @param pCodigo
     * @return 
     */
    public boolean excluirProdutoController(int pCodigo){
        return this.daoProdutos.excluirProdutoDAO(pCodigo);
    }
    
    /**
     * ALTERAR UM PRODUTO
     * @param pModelProduto
     * @return 
     */
    public boolean alterarProdutoController(ModelProdutos pModelProduto){
        return this.daoProdutos.alterarProdutoDAO(pModelProduto);
    }
    
    /**
     * RETORNAR UM PRODUTO
     * @param pCodigo
     * @return 
     */
    public ModelProdutos retornarUmProdutoController(int pCodigo){
        return this.daoProdutos.retornarUmProdutoDAO(pCodigo);
    }
    
    /**
     * LISTAR TODOS OS PRODUTOS
     * @return 
     */
    public ArrayList<ModelProdutos> listarProdutosController(){
        return this.daoProdutos.listarProdutosDAO();
    }
    
}
