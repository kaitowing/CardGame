package game;

import java.util.LinkedList;

public class Arena {
    private LinkedList<Carta> cartaList = new LinkedList<Carta>();

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
