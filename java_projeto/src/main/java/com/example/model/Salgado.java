package com.example.model;

public class Salgado extends ProdutoPadaria {
    private boolean FritoAssado; //1 para frito 0 para assado

    public Salgado(String NomeProduto, String sabor, String id, boolean FritoAssado){
        super(NomeProduto, sabor, id);
        this.FritoAssado = FritoAssado;
    }

}
