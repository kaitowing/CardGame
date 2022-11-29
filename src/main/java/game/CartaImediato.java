package game;

import javafx.scene.layout.Background;

public class CartaImediato extends Carta{

    public CartaImediato(int tipo) {
        super();
        setBackground(new Background(getImage(tipo)));
        this.tipoAtual = "PIRATA";
        switch(tipo){
            case 1:
            this.vida = 2;
            this.força = 4;
            break;

            case 2:
            this.vida = 3;
            this.força = 3;
            break;
        }
    }
}
