package com.example.view;

import com.example.model.ProdutoPadaria;
import java.util.ArrayList;
import java.util.Scanner;


public class ProdutoPadariaView {
    Scanner menu, entrada;

    public ProdutoPadariaView(){
        this.menu = new Scanner(System.in); //Menu de opções
        this.entrada = new Scanner(System.in); //Menu de entradas
    }

public void encerrarView() { // método para encerramento da interface da console
        System.out.println("Encerrando o programa...");
        this.entrada.close();
        this.menu.close();
    }

    public int mostrarMenu() { // método do menu da console
        System.out.println("=====MENU DA PADARIA:=====");
        System.out.println("[1] Mostrar Produtos;");
        System.out.println("[2] Inserir Produtos;");
        System.out.println("[3] Atualizar Produtos;");
        System.out.println("[4] Excluir Produtos;");
        System.out.println("[5] Pesquisar Produtos;");
        System.out.println("[0] Encerrar sistema.");
        System.out.print("-> Informe uma opção: ");

        int opcao = menu.nextInt();
        return opcao;
    }

    // métodos de impressão de dados na console
    public void mostrarEstudantes(ArrayList<ProdutoPadaria> listaEstudantes) {
        System.out.println("------ESTUDANTES DO SISTEMA:------");

        for (int i = 0; i < listaEstudantes.size(); i++) {
            Estudante estudante = listaEstudantes.get(i);
            this.mostrarEstudante(estudante);
        }
    }

    public void mostrarEstudante(Estudante estudante) {
        System.out.println(estudante.getRGA() + ": " + estudante.getNome());
    }

}