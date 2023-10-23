package com.example.model;

public class Salgado extends ProdutoPadaria {
    private boolean FritoAssado; //1 para frito 0 para assado

    public Salgado(String NomeProduto, String sabor, String id, boolean FritoAssado){
        super(NomeProduto, sabor, id);
        this.FritoAssado = FritoAssado;
    }

    @Override
    public double calcularPreco() {
        if (FritoAssado) { // Se for verdadeiro (for frito)
            return 3.00;   // Preço para salgado frito
        } else {           // Se não for frito (for assado)
            return 2.50;   // Preço para salgado assado
        }
    }
}
