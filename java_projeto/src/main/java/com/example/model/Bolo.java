package com.example.model;

public class Bolo extends ProdutoPadaria {
    private float peso;
    private int fatias;

    public Bolo(String NomeProduto, String sabor, String id, float peso, int fatias){
        super(NomeProduto, sabor, id);
        this.peso = peso;
        this.fatias = fatias;
    }


    public int getFatias() {
        return fatias;
    }
    public void setFatias(int fatias) {
        this.fatias = fatias;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }


    @Override
    public double calcularPreco() {
        double precoPorFatia = 1.50;
        double precoPorQuilo = 5.00;

        double precoPorFatias = fatias * precoPorFatia;
        double precoPorPeso = (peso / 1000) * precoPorQuilo;


        return precoPorFatias + precoPorPeso;
    }
}
