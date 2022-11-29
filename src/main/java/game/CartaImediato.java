package game;

import javafx.scene.layout.Background;

public class CartaImediato extends Carta{

    public CartaImediato(int tipo) {
        super();
        setBackground(new Background(getImage(tipo)));
        this.tipoAtual = "IMEDIATO";
        switch(tipo){
            case 3:
            this.vida = 4;
            this.força = 2;
            break;
            
            case 4:
            this.vida = 3;
            this.força = 4;
            break;
        }
        build();
    }
}
