package com.example.model;

import java.util.ArrayList;

public interface ProdutoPadariaDAO {
    void inserir(ProdutoPadaria ProdutoPadaria);

    void atualizar(ProdutoPadaria ProdutoPadaria, String sabor);

    void excluir(String id);

    ProdutoPadaria buscarPorID(String id); //Falta implementar

    ArrayList<ProdutoPadaria> buscarProdutos(); //Falta implementar
}
