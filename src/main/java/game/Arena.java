package game;

import java.util.LinkedList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class Arena extends VBox{
    private LinkedList<Carta> cartaList = new LinkedList<Carta>();

    public Arena(){
        setAlignment(Pos.TOP_CENTER);
        setLayoutX(19);
        setLayoutY(11);
        setPrefHeight(720);
        setPrefWidth(120);
        setSpacing(10);
        setPadding(new Insets(0, 10, 10, 0));

    }

    public boolean push(Carta e){
        try {
            cartaList.push(e);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public LinkedList<Carta> getCartaList() {
        return cartaList;
    }

    public int size(){
        return cartaList.size();
    }

    public Carta getLast(){
       return cartaList.getLast();
    }

    public Carta pop(){
        return cartaList.removeLast();
    }

    public void pop(Object obj){
        cartaList.remove(obj);
    }
    public void clear(){
        cartaList.removeAll(cartaList);
    }
}
