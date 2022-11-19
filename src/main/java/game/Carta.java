package game;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Carta extends GridPane{
    
    private String[] tipos = {
        "PIRATA","ALMIRANTE","YONKOU", "SHISHIBUKAI", "CAPITÃO"
    };

    private String tipoAtual;

    private int vida;

    private int força;

    public Carta(){
        this(120,100,1);
    }

    public Object getImage(int i){
        try {
            Image img = new Image(getClass().getResourceAsStream(i + ".png"));
            return new BackgroundImage(img, null, null, null, null);
        } catch (Exception e) {
            return new BackgroundFill(Color.RED, null, null);
        }
    }

    public String getTipoAtual() {
        return tipoAtual;
    }

    public Carta(int i, int j, int tipo) {
        setHeight(i);
        setWidth(j);
        tipoAtual = tipos[tipo];
        setBackground(new Background((BackgroundFill[]) getImage(tipo)));
    }
}
