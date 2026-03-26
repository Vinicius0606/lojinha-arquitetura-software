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

public class Pedido {
    
    private long idPedido;
    private long idCliente;
    private double precoTotal;
    private LocalDate data;

    public Pedido(long idPedido, long idCliente, double precoTotal) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.precoTotal = precoTotal;
        this.data = LocalDate.now();
    }

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }  
}
