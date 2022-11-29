package game;

import javafx.scene.layout.Background;

public class CartaShishibukai extends Carta{

    public CartaShishibukai(int tipo) {
        super();
        setBackground(new Background(getImage(tipo)));
        this.tipoAtual = "IMEDIATO";
        switch(tipo){
            case 7:

            this.vida = 3;
            this.força = 5;
            break;

            case 8:

            this.vida = 3;
            this.força = 3;
            break;
        }
        build();
    }
}
