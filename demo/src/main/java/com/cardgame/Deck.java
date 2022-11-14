package com.cardgame;

import java.util.ArrayList;

public class Deck {
    private int tamanhoDeck;
    private ArrayList<Carta> cartas;

    public Deck(){
        tamanhoDeck = 0;
        cartas = new ArrayList<>();
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }
}
