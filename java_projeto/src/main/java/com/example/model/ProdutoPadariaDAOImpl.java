package com.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProdutoPadariaDAOImpl implements ProdutoPadariaDAO {

    private Connection conexao;

    public ProdutoPadariaDAOImpl(Connection conexao) {
        this.conexao = conexao; // conexão com o banco
    }

    @Override
    public void inserir(ProdutoPadaria produto) {
    String inserir = "INSERT INTO produtos_padaria (nomeProduto, saborProduto, produtoID) VALUES (?, ?, ?)";
    try {
        PreparedStatement statementInserir = this.conexao.prepareStatement(inserir);
        statementInserir.setString(1, produto.getNomeProduto());
        statementInserir.setString(2, produto.getSabor());
        statementInserir.setString(3, produto.getID());
        statementInserir.executeUpdate();
        System.out.println("Produto inserido com sucesso: " + produto.getNomeProduto());
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    @Override
    public void atualizar(ProdutoPadaria produto) {
        String atualizar = "UPDATE produtos_padaria SET nomeProduto=?, saborProduto=? WHERE produtoID=?";
        try (PreparedStatement statementAtualizar = this.conexao.prepareStatement(atualizar)) {
            statementAtualizar.setString(1, produto.getNomeProduto());
            statementAtualizar.setString(2, produto.getSabor());
            statementAtualizar.setString(3, produto.getID());
            statementAtualizar.executeUpdate();
            System.out.println("Produto atualizado com sucesso: " + produto.getNomeProduto());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(String ID) {
        String excluir = "DELETE FROM produtos_padaria WHERE produtoID=?";
        try {
            PreparedStatement statementExcluir = this.conexao.prepareStatement(excluir);
            statementExcluir.setString(1, ID);
            statementExcluir.executeUpdate();
            System.out.println("Produto excluído com sucesso: ID " + ID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public ProdutoPadaria buscarPorID(String ID) {
    String buscarPorID = "SELECT * FROM produtos_padaria WHERE produtoID=?";
    ProdutoPadaria produto = null;
    try {
        PreparedStatement statementBuscarPorID = this.conexao.prepareStatement(buscarPorID);
        statementBuscarPorID.setString(1, ID);
        ResultSet registros = statementBuscarPorID.executeQuery();
        
        if (registros.next()) {
            produto = new ProdutoPadaria(registros.getString("saborProduto"), 
                    registros.getString("produtoID"),
                    registros.getString("nomeProduto"));
            System.out.println("Produto encontrado com sucesso: " + produto.getNomeProduto());
        } else {
            System.out.println("Produto não encontrado.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return produto;
}


    @Override
    public ArrayList<ProdutoPadaria> buscarProdutos() {
        String buscarTodos = "SELECT * FROM produtos_padaria";
        ArrayList<ProdutoPadaria> listaProdutos = new ArrayList<>();
        try {
            Statement statementBuscarTodos = this.conexao.createStatement();
            ResultSet registros = statementBuscarTodos.executeQuery(buscarTodos);
            while (registros.next()) {
                ProdutoPadaria produto = new ProdutoPadaria(
                        registros.getString("nomeProduto"), // Nome da coluna na tabela: 'nomeProduto'
                        registros.getString("saborProduto"), // Nome da coluna na tabela: 'saborProduto'
                        registros.getString("produtoID") // Nome da coluna na tabela: 'produtoID'
                );
                listaProdutos.add(produto);
            }
            System.out.println("Número de produtos encontrados no banco de dados: " + listaProdutos.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProdutos;
    }
    
    
}
