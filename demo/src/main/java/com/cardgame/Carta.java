package com.cardgame;

public abstract class Carta {
    private String nome;
    private int custo;

    public Carta(String nome,int custo){
        this.nome = nome;
        this.custo = custo;
    }

    public String getNome() {
        return nome;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
