package game;

import java.io.FileInputStream;
import java.io.IOException;

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

    public Carta(int tipo){
        this(120,100,tipo);
    }

    public BackgroundImage getImage(int i){
            try (FileInputStream file = new FileInputStream("src\\main\\java\\game\\images\\"+ i +".png")) {
                Image img = new Image(file);
                return new BackgroundImage(img, null, null, null, null);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
    }

    public String getTipoAtual() {
        return tipoAtual;
    }

    public Carta(int i, int j, int tipo) {
        setMinHeight(i);
        setMinWidth(j);
        tipoAtual = tipos[tipo];
        setBackground(new Background(getImage(tipo)));
    }
}
