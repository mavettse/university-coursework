package principal;

import java.util.Scanner;

public class Caixa {
    public static void main (String[] args){
        //itens produtos do estoque
        Produto p1 = new Produto("Detergente ABC", 11111, 1);
        ItemProduto detergente = new ItemProduto(p1, 10);
        Produto p2 = new Produto("Sabao em po OMO", 22222, 6.5);
        ItemProduto sabao = new ItemProduto(p2, 10);
        Produto p3 = new Produto("Shampoo Beleza Facil", 33333, 12);
        ItemProduto shampoo = new ItemProduto(p3, 10);
        Produto p4 = new Produto("Creme dental Colgate", 44444, 3.5);
        ItemProduto colgate = new ItemProduto(p4, 10);
        Produto p5 = new Produto("Sabonete nivea", 55555, 1.8);
        ItemProduto sabonete = new ItemProduto(p5, 10);
        Produto p6 = new Produto("Biscoito Maizena", 66666, 2);
        ItemProduto biscoito = new ItemProduto(p6, 10);
        Produto p7 = new Produto("Leite desnatado Parmalat", 77777, 3);
        ItemProduto leite = new ItemProduto(p7, 10);
        
        //estoque fixo
        Estoque es = new Estoque(100);
        es.addItemProduto(detergente);
        es.addItemProduto(sabao);
        es.addItemProduto(shampoo);
        es.addItemProduto(colgate);
        es.addItemProduto(sabonete);
        es.addItemProduto(biscoito);
        es.addItemProduto(leite);
        
        Scanner entrada = new Scanner(System.in);
        
        Venda venda = new Venda(20);
                
        System.out.println("Bem vindo ao Supermercado Tessera!\n");
        
        while(true){
            System.out.println(es.listarProdutos()); //listando os produtos disponíveis no estoque
            System.out.print("Digite o codigo do produto que deseja comprar: ");
                        
            int codigo = entrada.nextInt();
            entrada.nextLine();
            
            ItemProduto temp = es.consultarItemProduto(codigo);
            
            if(temp != null){
                System.out.print("Digite a quantidade: ");
                int quantidade = entrada.nextInt();
                entrada.nextLine();
                venda.addItemProduto(temp, quantidade);
                System.out.println("Produto adicionado com sucesso!");
                System.out.println("Deseja adicionar mais um item?");
                System.out.println("1. Sim\n2. Nao");
            } else {
                System.out.println("Nao foi encontrado nenhum produto com esse codigo");
                System.out.println("Deseja tentar novamente?");
                System.out.println("1. Sim\n2. Nao");
            }
            
            int opcao = entrada.nextInt();
            entrada.nextLine();
            if(opcao == 2)
                break;
            }
        
            System.out.println(venda.listarProdutos() + "\nObrigado por comprar conosco! Volte sempre!");
            
    }
}