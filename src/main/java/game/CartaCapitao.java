package game;

import javafx.scene.layout.Background;

public class CartaCapitao extends Carta{

    public CartaCapitao(int tipo) {
        super();
        setBackground(new Background(getImage(tipo)));
        this.tipoAtual = "CAPITÃO";
        switch(tipo){
            case 9:
            this.vida = 4;
            this.força = 4;
            break;

            case 10:
            this.vida = 2;
            this.força = 4;
            break;
        }
        build();
    }
}
