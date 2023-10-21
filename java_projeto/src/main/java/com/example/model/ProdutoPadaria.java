package com.example.model;

public abstract class ProdutoPadaria {
    private String sabor;
    private String id;

    // Construtor
    public ProdutoPadaria(String sabor, String id) {
        this.sabor = sabor;
        this.id = id;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public abstract double calcularPreco();
}
