package com.example.model;

import java.util.ArrayList;

public interface ProdutoPadariaDAO {
    void inserir(ProdutoPadaria ProdutoPadaria);

    void atualizar(ProdutoPadaria produto);

    void excluir(String ID);

    ProdutoPadaria buscarPorID(String ID);
    
    ArrayList<ProdutoPadaria> buscarProdutos();
}
