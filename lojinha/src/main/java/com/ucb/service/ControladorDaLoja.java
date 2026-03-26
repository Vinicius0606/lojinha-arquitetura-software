/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucb.service;

import com.ucb.model.Cliente;
import com.ucb.model.ItemPedido;
import com.ucb.model.Pagamento;
import com.ucb.model.Pedido;
import com.ucb.model.Produto;
import java.util.ArrayList;

/**
 *
 * @author kurok
 */
public class ControladorDaLoja {
    
    // Clientes:
    ArrayList<Cliente> clientes = new ArrayList<>();
   
    public void adicionarClientes(Cliente c){
        
        if(clientes.contains(c)) {
            
            System.out.println("Bem vindo de volta" + c.getNome() + "!");
            
        } else {
         
            System.out.println("Seja bem-vindo " + c.getNome() + "!");
            clientes.add(c);
        }
    }
    // -------------------------------------------------------------------------
    
    // Produtos:
    
    ArrayList<Produto> produtos = new ArrayList<>();
    
    public void adicionarProdutos(){
        
        Produto p1 = new Produto(1, "Mouse Gamer", 89.90, 50);
        Produto p2 = new Produto(2, "Teclado Mecânico", 249.90, 30);
        Produto p3 = new Produto(3, "Monitor 24 polegadas", 899.90, 15);
        Produto p4 = new Produto(4, "Headset", 199.90, 25);
        Produto p5 = new Produto(5, "Notebook", 3500.00, 8);
        Produto p6 = new Produto(6, "Webcam Full HD", 159.90, 40);
        Produto p7 = new Produto(7, "Cadeira Gamer", 1200.00, 10);
    
        produtos.add(p1);
        produtos.add(p2);
        produtos.add(p3);
        produtos.add(p4);
        produtos.add(p5);
        produtos.add(p6);
        produtos.add(p7);
    }
    
    public void listarProdutos(){
        
        int i = 1;
         
        for(Produto p : produtos) {
            
            System.out.println("Produto " + i);
            
            System.out.println("ID: " + p.getIdProduto());
            System.out.println("Nome: " + p.getNome());
            System.out.println("Valor: " + p.getValor());
            System.out.println("Estoque: " + p.getEstoque());
            
            i += 1;
            
            System.out.println("==============================================");
        }
    }
    
    public Produto buscarProdutoPorId(long idProduto) {

        for (Produto p : produtos) {
            if (p.getIdProduto() == idProduto) {
                return p; 
            }
        }
        
       return null; 
    }
    // -------------------------------------------------------------------------
    
    // ItemPedido(Carrinho):
    
    ArrayList<ItemPedido> carrinho = new ArrayList<>();
    
    public void adicionarAoCarrinho(long idProduto, int quantidade){                     
        
        ItemPedido item = new ItemPedido(1, idProduto, quantidade);
        
        carrinho.add(item);
    }
    
    public boolean removerDoCarrinho(long idProduto) {
        
          for(ItemPedido ip: carrinho) {
            
            if (ip.getIdProduto() == idProduto) {
                
                carrinho.remove(ip);
                return true;
            }
        }
        
        return false;
    }
    
    public boolean visualizarCarrinho(){
       
        
        if (carrinho.isEmpty())return false;
    
        
        for(ItemPedido ip : carrinho){
            
            System.out.println("ID do Pedido: " + ip.getIdPedido());
            System.out.println("ID do Produto: " + ip.getIdProduto());
            System.out.println("Quantidade: " + ip.getQuantidade());
            
            System.out.println("===============================================");
        }
        
        return true;
    }
    
    // Pedido:
    
    public double calcularTotal(){
        
        double total = 0;
        
        for(ItemPedido ip : carrinho) {
        
            for(Produto p : produtos) {

                if(p.getIdProduto() == ip.getIdProduto()) {

                    total += p.getValor() * ip.getQuantidade();
                }
            }
        }
        
        return total;
    }
    
    public void finalizarPedido(long idCliente, int escolhaPagamento){
             
        double precoTotal = calcularTotal();
        
        Pedido p = new Pedido(1, idCliente, precoTotal);
        
        realizarPagamento(p, escolhaPagamento);
    }
    
    // Pagamento:
    
    public void realizarPagamento(Pedido p, int escolhaPagamento) {
        
        String formaPagamento;
        
        if (escolhaPagamento == 1) formaPagamento = "Cartão";
        else if(escolhaPagamento == 2) formaPagamento = "Dinheiro";
        else formaPagamento = "Pix";
        
        Pagamento pagamento = new Pagamento(1, p.getIdPedido(), formaPagamento);
        
        GatewayPagamento gateway = GatewayPagamento.getInstancia();
        gateway.confirmarPagamento(pagamento, p.getPrecoTotal());
    }
}
