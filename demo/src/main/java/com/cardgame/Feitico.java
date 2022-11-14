package com.cardgame;

public class Feitico extends Carta{

    private String efeito;

    public Feitico(String nome, int custo,String efeito) {
        super(nome, custo);
        this.efeito = efeito;
    }
    
    public String getEfeito() {
        return efeito;
    }
}
