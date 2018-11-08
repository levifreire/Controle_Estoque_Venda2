/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Date;

/**
 *
 * @author levi
 */
public class ModelProdutos {
    
    private int idProduto;
    private String proNome;
    private Double proValorEntrada;
    private Double proValorSaida;
    private int proEstoque;
    private Date proValidade;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getProNome() {
        return proNome;
    }

    public void setProNome(String proNome) {
        this.proNome = proNome;
    }

    public Double getProValorEntrada() {
        return proValorEntrada;
    }

    public void setProValorEntrada(Double proValorEntrada) {
        this.proValorEntrada = proValorEntrada;
    }

    public Double getProValorSaida() {
        return proValorSaida;
    }

    public void setProValorSaida(Double proValorSaida) {
        this.proValorSaida = proValorSaida;
    }

    public int getProEstoque() {
        return proEstoque;
    }

    public void setProEstoque(int proEstoque) {
        this.proEstoque = proEstoque;
    }

    public Date getProValidade() {
        return proValidade;
    }

    public void setProValidade(Date proValidade) {
        this.proValidade = proValidade;
    }
    
    
    
}
