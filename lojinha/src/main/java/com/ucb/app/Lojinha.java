/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ucb.app;

/**
 *
 * @author kurok
 */

import com.ucb.service.ControladorDaLoja;
import com.ucb.model.Cliente;
import java.util.Scanner;

public class Lojinha {
    
    public static void main(String[] args) {
        
        // Inicializando sistema
        
        Scanner scanner = new Scanner(System.in);

        
        ControladorDaLoja loja = new ControladorDaLoja();
        loja.adicionarProdutos();
        // ---------------------------------------------------------------------
        
        // Começo da aplicação
        Cliente c = new Cliente(1, "Vinicius", "vrp@gmail.com", "12345", "03575");
        loja.adicionarClientes(c);
        
        while(true) {
            
            System.out.println(
            """
                Escolha uma opção:
                1-Listar Produtos
                2-Adicionar produto ao carrinho pelo id
                3-Visualizar Carrinho
                4-Remover Item do Carrinho
                5-Finalizar Compra
                6-Sair
            """);
            
            int escolha = scanner.nextInt();
            
            if(escolha == 1) loja.listarProdutos();
            else if(escolha == 2) {

                System.out.println("Qual o id do produto desejado? ");
                int id = scanner.nextInt();
                    
                if(loja.buscarProdutoPorId(id) == null) {
                    
                    System.out.println("O produto escolhido não existe");
                    continue;
                }
                
               int quantidade = 0;
                
                while(true){
                
                    System.out.println("Qual a quantidade desejada do produto escolhido? ");
                    quantidade = scanner.nextInt();
                    
                    if(quantidade <= 0) {
                        
                        System.out.println("Quantidade dever ser 1 ou mais!");
                        
                    } else break;
                }
                
                loja.adicionarAoCarrinho(id, quantidade);
                
            } else if(escolha == 3) {
                boolean temItens = loja.visualizarCarrinho();
                
                if(temItens == false) System.out.println("O carrinho está vazio!");
            }
            else if(escolha == 4) {
                
                System.out.println("Qual o id do produto a ser removido? ");
                int id = scanner.nextInt();
                
                if(loja.removerDoCarrinho(id) == false) {
                    System.out.println("O produto escolhido não existe ou ja foi removido");
                    
                } else {
                    
                    System.out.println("Produto Removido!");
                }
                
            } else if(escolha == 5) {
                
                System.out.println("Detalhes do pedido:");
                
                if(loja.visualizarCarrinho() == false) {
                    
                    System.out.println("O carrinho está vazio!");
                    continue;
                }
                
                double precoTotal = loja.calcularTotal();
                
                System.out.println("O total da compra é de R$" + String.format("%.2f", precoTotal) + "\n\n");
                
                int prosseguir = 0;
                
                while(true){
                    
                    System.out.println("\nDeseja prosseguir para o pagamento? (1- sim/ 0 - não)");
                    prosseguir = scanner.nextInt();
                    
                    if(prosseguir != 1 && prosseguir != 0) {
                        
                        System.out.println("Opção Invalida\n");
                        
                    } else break;                   
                }
                
                int escolhaPagamento;
                
                if(prosseguir == 1){
                    
                    while(true){
                        System.out.println("""
                          Qual a forma de pagamento:
                                1-Cartão
                                2-Dinheiro
                                3-Pix
                        """);
                        
                        escolhaPagamento = scanner.nextInt();
                        
                        if(escolhaPagamento != 1 && escolhaPagamento != 2 && escolhaPagamento != 3) {                         
                            System.out.println("Opção Invalida\n");
                            
                        } else break;
                    }
                                   
                    loja.finalizarPedido(c.getIdCliente(), escolhaPagamento);
                            
                } 
                
            } else if(escolha == 6) break;
            
            else System.out.println("Opção Invalida\n");
     
        }
        
        
        // ---------------------------------------------------------------------
    }
}
