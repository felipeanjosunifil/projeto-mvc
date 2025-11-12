package com.github.felipeanjosunifil.projeto_mvc.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cidade;
    private String rua;
    private int numero;


    public Endereco(String cidade, String rua, int numero) {
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
    }

    public Endereco() {

    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
