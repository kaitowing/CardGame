package com.cardgame;

public class Jogador {
    private int vida;
    private int mana;
    private boolean tokenAtaque;
    private Deck deck;
    private Mao mao;
    private Campo campo;
    private Arena arena;


    public Jogador(){
        this.vida = 10;
        this.mana = 10;
        this.tokenAtaque = false;
        this.deck = new Deck();
        this.mao = new Mao();
        this.campo = new Campo();
        this.arena = new Arena();
    }

    public Jogador(int vida, int mana, boolean tokenAtaque){
        this.vida = vida;
        this.mana = mana;
        this.tokenAtaque = tokenAtaque;
        this.deck = new Deck();
        this.mao = new Mao();
        this.campo = new Campo();
        this.arena = new Arena();
    }

    public int getMana() {
        return mana;
    }

    public int getVida() {
        return vida;
    }

    public boolean getTokenAtaque(){
        return tokenAtaque;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setTokenAtaque(boolean tokenAtaque) {
        this.tokenAtaque = tokenAtaque;
    }

    public void addNaMao(Object carta){
       mao.addNaMao(deck.getCartas().stream().filter(c-> c.equals(carta)).findFirst());
    }
}
