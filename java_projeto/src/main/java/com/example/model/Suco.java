package com.example.model;

public class Suco extends ProdutoPadaria {
    private float tamanho;


    public Suco(String NomeProduto, String sabor, String id, float tamanho) {
        super(NomeProduto,sabor, id);
        this.tamanho = tamanho;
    }


    public float getTamanho() {
        return tamanho;
    }
    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }
}
