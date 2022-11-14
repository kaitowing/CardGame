package com.cardgame;

import java.util.ArrayList;
import java.util.Optional;

public class Mao {
    private ArrayList<Carta> cartas;

    public Mao(){
        cartas = new ArrayList<>();
    }

    public void addNaMao(Optional<Carta> optional){
        cartas.add(optional.get());
    }
}
