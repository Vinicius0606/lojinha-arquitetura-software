# lojinha-arquitetura-software

## Descrição

O sistema simula o funcionamento de uma loja online onde um cliente pode:

- visualizar produtos
- adicionar produtos ao carrinho
- remover produtos do carrinho
- visualizar o carrinho
- finalizar a compra
- realizar pagamento

A aplicação foi desenvolvida em Java, utilizando orientação a objetos e organização em pacotes.

O sistema segue uma arquitetura cliente-servidor monolítica, onde toda a lógica da aplicação está concentrada no backend, representado pelo ControladorDaLoja.

## Estrutura do Projeto

O projeto foi organizado em pacotes para separar responsabilidades:

### com.ucb.app
Contém a classe principal:
- Lojinha - responsável por iniciar a aplicação e simular a interação do cliente via console.

### com.ucb.model
Contém as entidades do sistema:
- Cliente - representa o cliente da loja
- Produto - representa os produtos disponíveis
- Pedido - representa uma compra realizada
- ItemPedido - representa um produto dentro de um pedido
- Pagamento - representa as informações do pagamento

### com.ucb.service
Contém a lógica do sistema:
- ControladorDaLoja - responsável por controlar o fluxo da aplicação, gerenciar carrinho, pedidos e pagamentos
- GatewayPagamento - simula o sistema externo de pagamento

## Arquitetura

A aplicação segue o modelo cliente-servidor monolítico.

O cliente é representado pela classe Lojinha, que interage com o usuário via console.

O backend é representado pela classe ControladorDaLoja, que centraliza todas as regras de negócio do sistema.

O sistema externo de pagamento é simulado pela classe GatewayPagamento, representando uma integração externa.

## Funcionalidades

O sistema permite:

- identificação de cliente (dados criados estaticamente)
- listagem de produtos disponíveis
- adição de produtos ao carrinho
- remoção de produtos do carrinho
- visualização do carrinho
- cálculo do valor total do pedido
- escolha da forma de pagamento
- simulação de pagamento aprovado ou recusado

## Uso do padrão Singleton

O padrão Singleton foi aplicado na classe GatewayPagamento.

O objetivo é garantir que exista apenas uma instância responsável pela comunicação com o sistema externo de pagamento durante toda a execução da aplicação.

Isso simula o comportamento de um gateway de pagamento real, onde normalmente existe apenas uma conexão centralizada responsável por processar transações.

A instância única é obtida através do método getInstancia(), impedindo a criação de múltiplos objetos da classe.

## Tecnologias Utilizadas

- Java
- Orientação a Objetos
- Estruturas de dados (ArrayList)
- Padrão de projeto Singleton

