package com.cardgame;

public class Partida {
    private Jogador jogador1;
    private Jogador jogador2;
    private Rodada rodadaAtual;

    public Partida(){
        jogador1 = new Jogador();
        jogador2 = new Jogador();
        rodadaAtual = new Rodada();
    }
}
