/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucb.model;

/**
 *
 * @author kurok
 */

import java.time.LocalDate;

public class Pagamento {
    
    private long idPagamento;
    private long idPedido;
    private String formaPagamento;
    private LocalDate data;

    public Pagamento(long idPagamento, long idPedido, String formaPagamento) {
        this.idPagamento = idPagamento;
        this.idPedido = idPedido;
        this.formaPagamento = formaPagamento;
        this.data = LocalDate.now();
    }

    public long getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(long idPagamento) {
        this.idPagamento = idPagamento;
    }

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
    
    
}
