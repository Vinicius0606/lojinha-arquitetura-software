/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucb.service;

import com.ucb.model.Pagamento;

/**
 *
 * @author kurok
 */
public class GatewayPagamento {
    
    private static GatewayPagamento instanciaUnica;
    
    private GatewayPagamento() {
        System.out.println("Conectado ao sistema externo de pagamento...");
    }

    public static GatewayPagamento getInstancia() {

        if (instanciaUnica == null) {
            instanciaUnica = new GatewayPagamento();
        }

        return instanciaUnica;
    }
    
    public void verificarSaldo(double saldo, double precoTotal) {
        
        if (saldo >= precoTotal) {
                System.out.println("Pagamento confirmado!\n");
               
                
            } else {
                
                System.out.println("Transação malsucedida.\n");
            }
    }
    
    public void confirmarPagamento(Pagamento p, double precoTotal){
        
        double limiteCartao = 5000.00;
        double saldoDinheiro = 1000.00;
        double saldoPix = 10000.00;

        
        String formaPagamento = p.getFormaPagamento();
        
        if("Cartão".equals(formaPagamento)) verificarSaldo(limiteCartao, precoTotal);
        else if("Dinheiro".equals(formaPagamento)) verificarSaldo(saldoDinheiro, precoTotal);
        else verificarSaldo(saldoPix, precoTotal);
    }
}
