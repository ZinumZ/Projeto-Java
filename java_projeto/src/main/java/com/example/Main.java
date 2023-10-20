package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Hello, Meu projeto JDBC!");

        // organizar seus dados de conexão em strings é uma boa ideia!

        String mySQLURL = "jdbc:mysql://localhost:3306/"; // informar o nome do banco no final da URL é opcional
        String usuario = "root";
        String senha = "123456";

        // realiza a conexão com o banco

        try (Connection conexao = DriverManager.getConnection(mySQLURL, usuario, senha)) {

            if (conexao != null) {
                System.out.println("Conectado com sucesso à instância MySQL!");
            }

            conexao.close(); // fecha a conexão com o banco - sempre fechar após o uso!

        } catch (SQLException ex) {

            System.out.println("Houve um problema com a conexão.");

            ex.printStackTrace();
        }
    }
}