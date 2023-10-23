package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.controller.ProdutoPadariaController;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Hello, Meu projeto JDBC!");


        String mySQLURL = "jdbc:mysql://localhost:3306/BDpadaria";
        String usuario = "root";
        String senha = "123456";

        // realiza a conexão com o banco

        try (Connection conexao = DriverManager.getConnection(mySQLURL, usuario, senha)) {

            if (conexao != null) {
                System.out.println("Conectado com sucesso à instância MySQL!");
            }
            ProdutoPadariaController produtoPadariaController = new ProdutoPadariaController(conexao);

            conexao.close(); // fecha a conexão com o banco

        } catch (SQLException ex) {

            System.out.println("Houve um problema com a conexão.");

            ex.printStackTrace();
        }
    }
}