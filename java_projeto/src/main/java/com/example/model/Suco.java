package com.example.model;

public class Suco extends ProdutoPadaria {
    private float tamanho;


    public Suco(String sabor, String id, float tamanho) {
        super(sabor, id);
        this.tamanho = tamanho;
    }


    public float getTamanho() {
        return tamanho;
    }
    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }


    @Override
    public double calcularPreco() {
        double preco250ML = 1.50; 
        double preco500ML = 3.00;
        double preco700ML = 4.50;

        if (tamanho == 250) {
            return preco250ML;
        } else if (tamanho == 500) {
            return preco500ML;
        } else if (tamanho == 700) {
            return preco700ML;
        } else {
                throw new IllegalArgumentException("Tamanho de suco inválido: " + tamanho + " mL"); //testar dps
        }
    }
}
