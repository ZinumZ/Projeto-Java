package com.example.controller;

import com.example.model.ProdutoPadaria;
import com.example.model.ProdutoPadariaDAOImpl;
import com.example.view.ProdutoPadariaView;

import java.sql.Connection;
import java.util.ArrayList;

public class ProdutoPadariaController {
    private ProdutoPadariaDAOImpl ProdutoPadariaModel;
    private ProdutoPadariaView ProdutoPadariaView;

    public ProdutoPadariaController(Connection conexao) {
        this.ProdutoPadariaModel = new ProdutoPadariaDAOImpl(conexao); // Inicializa ProdutoPadariaModel com a conexão
        this.ProdutoPadariaView = new ProdutoPadariaView(); // Inicializa ProdutoPadariaView
        this.iniciarControl();
    }

    public void iniciarControl() {
        int menu;
        do {
            menu = this.ProdutoPadariaView.mostrarMenu();
            switch (menu) {
                case 1:
                    this.mostrarProdutos();
                    break;
                case 2:
                    this.inserirProduto();
                    break;
                case 3:
                    this.atualizarProduto();
                    break;
                case 4:
                    this.excluirProdutoID();
                    break;
                case 5:
                    this.pesquisarProdutoID();
                    break;
                case 0:
                    this.ProdutoPadariaView.encerrarView();
                    break;
                default:
                    this.ProdutoPadariaView.opcaoInvalida();
                    break;
            }
        } while (menu != 0);
    }

    public void mostrarProdutos() {
        ArrayList<ProdutoPadaria> listaProdutos = this.ProdutoPadariaModel.buscarProdutos();
        System.out.println("PRODUTOS NO CATÁLOGO:");
        for (ProdutoPadaria produto : listaProdutos) {
            double preco = produto.calcularPreco();
            System.out.println(produto.getNomeProduto() + " - " + produto.getID() + " (Sabor: " + produto.getSabor() + ")");
            System.out.println("Preço: R$" + preco);
            System.out.println("=========================");
        }
        // Restante do código...
    
        this.ProdutoPadariaView.mostrarProdutos(listaProdutos);
    }

    public void inserirProduto() {
        this.ProdutoPadariaView.inserirProduto();
        ProdutoPadaria produto = new ProdutoPadaria(this.ProdutoPadariaView.getNomeProduto(), this.ProdutoPadariaView.getProdutoID(), this.ProdutoPadariaView.getSaborProduto());
        
        if (this.ProdutoPadariaModel != null) {
            this.ProdutoPadariaModel.inserir(produto);
            this.ProdutoPadariaView.confirmarInsercaoProduto(produto.getID());
        } else {
            System.out.println("Erro: ProdutoPadariaModel não foi inicializado corretamente.");
        }
    }

    public void excluirProdutoID() {
        this.ProdutoPadariaView.excluirProdutoID();
        String ID = this.ProdutoPadariaView.getProdutoID();
        if (this.ProdutoPadariaModel.buscarPorID(ID) != null) {
            this.ProdutoPadariaModel.excluir(ID);
            this.ProdutoPadariaView.confirmarExclusaoProduto(ID);
        } else {
            System.out.println("Produto não encontrado com o ID fornecido.");
        }
    }

    public void atualizarProduto() {
        this.ProdutoPadariaView.atualizarProduto();
        String ID = this.ProdutoPadariaView.getProdutoID();
        ProdutoPadaria produtoExistente = this.ProdutoPadariaModel.buscarPorID(ID);
    
        if (produtoExistente != null) {
            String novoNome = this.ProdutoPadariaView.getNomeProduto();
            String novoSabor = this.ProdutoPadariaView.getSaborProduto();
    
            produtoExistente.setNomeProduto(novoNome);
            produtoExistente.setSabor(novoSabor);
    
            this.ProdutoPadariaModel.atualizar(produtoExistente);
            this.ProdutoPadariaView.confirmarAtualizacaoProduto(novoNome, ID);
        } else {
            System.out.println("Produto não encontrado com o ID fornecido.");
        }
    }
    

    public void pesquisarProdutoID() {
        this.ProdutoPadariaView.pesquisarProdutoID();
        String ID = this.ProdutoPadariaView.getProdutoID();
        ProdutoPadaria produto = this.ProdutoPadariaModel.buscarPorID(ID);
        if (produto != null) {
            this.ProdutoPadariaView.mostrarProduto(produto);
        } else {
            System.out.println("Produto não encontrado com o ID fornecido.");
        }
    }
}
