package com.cardgame;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class AreaCartas {
    
    private LinkedList<Carta> cartas;

    public AreaCartas(){
        cartas = new LinkedList<Carta>();
    }

    public void addCarta(Carta e){
        cartas.add(e);
    }

    public Carta getCarta(){
        return cartas.getFirst();
    }
}
