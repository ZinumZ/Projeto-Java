CREATE DATABASE IF NOT EXISTS BDpadaria;
USE BDpadaria;

CREATE TABLE produtos_padaria (
    produtoID INT NOT NULL AUTO_INCREMENT,
    nomeProduto VARCHAR(255),
    saborProduto VARCHAR(255),
    PRIMARY KEY(produtoID)
);
