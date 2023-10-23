package com.example.view;

import com.example.model.ProdutoPadaria;
import java.util.ArrayList;
import java.util.Scanner;


public class ProdutoPadariaView {
    Scanner menu, input;

    public ProdutoPadariaView(){
        this.menu = new Scanner(System.in); //Menu de opções
        this.input = new Scanner(System.in); //Menu de entradas
    }

    public void encerrarView() { // método para encerramento da interface da console
        System.out.println("Encerrando o programa...");
        this.input.close();
        this.menu.close();
    }

    public int mostrarMenu() { // método do menu da console
        System.out.println("=====MENU DA PADARIA:=====");
        System.out.println("[1] Mostrar Produtos;");
        System.out.println("[2] Inserir Produtos[Bolo, Salgado, Suco, Baguette];");
        System.out.println("[3] Atualizar Produtos;");
        System.out.println("[4] Excluir Produtos;");
        System.out.println("[5] Pesquisar Produtos;");
        System.out.println("[0] Encerrar sistema.");
        System.out.print("-> Informe uma opção: ");

        int opcao = menu.nextInt();
        return opcao;
    }

    // funções de impressão de dados no console
    public void mostrarProdutos(ArrayList<ProdutoPadaria> listaProdutos) {
        System.out.println("PRODUTOS NO CATÁLOGO:");
        
        for (ProdutoPadaria produto : listaProdutos) {
            System.out.println(produto.getID() + " - " + produto.getNomeProduto() + " (Sabor: " + produto.getSabor() + ")");
        }
    }
    

    public void mostrarProduto(ProdutoPadaria produto) {
        System.out.println(produto.getID() + " = " + produto.getNomeProduto());
    }    


    public String getProdutoID() {
        System.out.println("Escreva o ID do produto:");
        String ID = input.nextLine();
        return ID;
    }

    public String getNomeProduto() {
        System.out.println("Escreva o nome do produto:");
        String nomeProduto = input.nextLine();
        return nomeProduto;
    }

    public String getSaborProduto(){
        System.out.println("Escreva o sabor do produto:");
        String saborProduto = input.nextLine();
        return saborProduto;
    }

     // mensagens de títulos CRUD
     public void inserirProduto() {
        System.out.println("INSERIR PRODUTO NO CATALOGO:\n");
    }

    public void pesquisarProdutoID() {
        System.out.println("PESQUISAR PRODUTO DO CATALOGO:\n");
    }

    public void excluirProdutoID() {
        System.out.println("EXCLUIR PRODUTO DO CATALOGO:\n");
    }

    public void atualizarProduto() {
        System.out.println("ATUALIZAR PRODUTO DO CATALOGO:\n");
    }

    // mensagens de confirmação CRUD
    public void confirmarExclusaoProduto(String ID) {
        System.out.println("Produto " + ID + " excluído com sucesso!");
    }

    public void confirmarInsercaoProduto(String ID) {
        System.out.println("Produto " + ID + " inserido com sucesso!");
    }

    public void confirmarAtualizacaoProduto(String nomeProduto, String ID) {
        System.out.println("Produto " + ID + " atualizado com sucesso: " + nomeProduto);
    }

    // mensagens de alerta
    public void opcaoInvalida() {
        System.out.println("Opção inválida! Tente novamente.");
    }
}
