package com.cardgame;

public class Unidade extends Carta{
    private int vida;
    private int attack;
    private String tipo;

    public Unidade(int vida, int attack, String tipo, String nome, int custo){
        super(nome, custo);
        this.vida = vida;
        this.attack = attack;
        this.tipo = tipo;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    public String getTipo() {
        return tipo;
    }

    public int getVida() {
        return vida;
    }
}
