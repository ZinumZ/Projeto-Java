package com.example.model;

public class Baguette extends ProdutoPadaria {
    private String tipo;

    public Baguette(String NomeProduto, String sabor, String id, String tipo){
        super(NomeProduto, sabor, id);
        this.tipo = tipo;
    }

    public void tipoBaguette(){
        System.out.println("Tipo de Baguette: " + tipo);
    }
}
