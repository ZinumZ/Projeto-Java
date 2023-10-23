package com.example.model;

public class ProdutoPadaria {
    private String sabor, ID, NomeProduto;

    // Construtor
    public ProdutoPadaria(String sabor, String ID, String NomeProduto) {
        this.sabor = sabor;
        this.ID = ID;
        this.NomeProduto = NomeProduto;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNomeProduto() {
        return NomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        NomeProduto = nomeProduto;
    }


}
