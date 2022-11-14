package com.cardgame;

public class Rodada {
    private int turno;
    private int numRodada;

    public Rodada(){
        turno = 0;
        numRodada = 0;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
}
