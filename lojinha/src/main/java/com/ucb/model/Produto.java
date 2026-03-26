/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucb.model;

/**
 *
 * @author kurok
 */
public class Produto {
    
    private long idProduto;
    private String nome;
    private double valor;
    private int estoque;
    
    public Produto(long idProduto, String nome, double valor, int estoque){
        
        this.idProduto = idProduto;
        this.nome = nome;
        this.valor = valor;
        this.estoque = estoque;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    
    
}
