package com.example.Bank_IBM.model;

public class ContaBanco{
    private int numConta;
    private String tipo;
    private String nome;
    private float saldo;
    private boolean status;

    // Construtor
    public ContaBanco(int numConta, String tipo, String nome) {
        this.numConta = numConta;
        this.tipo = tipo;
        this.nome = nome;
        this.saldo = 0;
        this.status = false;
    }

    // Getters e Setters
    public int getNumConta() {
        return numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public float getSaldo() {
        return saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}