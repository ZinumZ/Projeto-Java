package com.example.controller;

import com.example.model.*; // import do Modelo
import com.example.view.ProdutoPadariaView; // import da Visão

//imports Java
import java.sql.Connection;
import java.util.ArrayList;

public class ProdutoPadariaController {
    ProdutoPadariaDAOImpl ProdutoPadariaModel;
    ProdutoPadariaView ProdutoPadariaView;

    public ProdutoPadariaController(Connection conexao) {
        this.ProdutoPadariaView = new ProdutoPadariaView(); // inicia a Visão
        this.ProdutoPadariaModel = new ProdutoPadariaModel(conexao); // inicia o Model
        this.iniciarControl();
    }

    public void iniciarControl() { // controle de funcionalidades CRUD 
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

     // métodos controle do CRUD de ProdutoPadaria
     public void mostrarProdutos() {
        ArrayList<ProdutoPadaria> listaProdutos = this.ProdutoPadariaModel.buscarProdutos(); // busca no modelo
        this.ProdutoPadariaView.mostrarProdutos(listaProdutos); // mostra na visão
    }

    public void inserirProduto() {
        this.ProdutoPadariaView.inserirProduto(); // mostra na visão
        ProdutoPadaria produto = new ProdutoPadaria(this.ProdutoPadariaView.getnomeProduto(), this.ProdutoPadariaView.getProdutoID()); // recebe na visão
        this.ProdutoPadariaModel.inserir(produto); // grava no modelo
        this.ProdutoPadariaView.confirmarInsercaoProduto(produto.getID()); // mostra na visão
    }

    public void excluirProdutoID() {
        this.ProdutoPadariaView.inserirProduto(); // mostra na visão
        String ID = this.ProdutoPadariaView.getProdutoID();
        if (this.ProdutoPadariaModel.buscarPorID(ID) != null) {
            this.ProdutoPadariaModel.excluir(ID); // grava no modelo
            this.ProdutoPadariaModel.confirmarExclusaoProduto(ID); // mostra na visão
        }
    }

    public void atualizarProduto() {
        this.ProdutoPadariaView.atualizarProduto(); // mostra na visão
        String ID = this.ProdutoPadariaView.getProdutoID(); // recebe na visão
        if (this.ProdutoPadariaModel.buscarPorID(ID) != null) { // verifica no modelo
            String nomeProduto = this.ProdutoPadariaView.getnomeProduto(ID);
            this.ProdutoPadariaModel.excluir(ID); // grava no modelo
            this.ProdutoPadariaView.confirmarExclusaoProduto(ID); // mostra na visão
        }
    }

    public void pesquisarProdutoID() {
        this.ProdutoPadariaView.pesquisarProdutoID(); // mostra na visão
        String RGA = this.ProdutoPadariaView.getProdutoID(); // recebe na visão
        if (this.ProdutoPadariaModel.buscarPorID(ID) != null) { // verifica no modelo
            this.ProdutoPadariaView.mostrarProdutos(this.ProdutoPadariaModel.buscarPorID(ID));  // busca no modelo e mostra na visão
        }
}
