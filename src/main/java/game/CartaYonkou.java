package game;

import javafx.scene.layout.Background;

public class CartaYonkou extends Carta{

    public CartaYonkou(int tipo) {
        super();
        setBackground(new Background(getImage(tipo)));
        this.tipoAtual = "IMEDIATO";
        switch(tipo){
            case 5:
            this.vida = 5;
            this.força = 5;
            break;

            case 6:
            this.vida = 5;
            this.força = 4;
            break;
        }
        build();
    }
}
