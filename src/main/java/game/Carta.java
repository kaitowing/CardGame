package game;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Carta extends Pane{
    
    private String[] tipos = {
        "PIRATA","ALMIRANTE","YONKOU", "SHISHIBUKAI", "CAPITÃO"
    };

    private String tipoAtual;

    private Label labelvida = new Label();

    private int custo;

    private Label labelforça = new Label();

    private boolean cardState;

    private int vida;

    private int força;

    public Carta(int tipo){
        this(120,100,tipo);
    }

    public int getVida() {
        return vida;
    }
    public int getForça() {
        return força;
    }
    public void setVida(int vida) {
        this.vida = vida;
        labelvida.setText(this.vida +"");
    }
    public void setForça(int força) {
        this.força = força;
        labelforça.setText(this.força + "");
    }

    public void setCardState(boolean cardState) {
        this.cardState = cardState;
    }

    public boolean cardState(){
        return cardState;
    }

    public BackgroundImage getImage(int i){
            try (FileInputStream file = new FileInputStream("src\\main\\java\\game\\images\\"+ i +".png")) {
                Image img = new Image(file);
                BackgroundSize size = new BackgroundSize(1.0, 1.0, true, true, false, false);
                return new BackgroundImage(img, null, null, null, size);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
    }

    public int getCusto() {
        return custo;
    }

    public String getTipoAtual() {
        return tipoAtual;
    }

    public Carta(int i, int j, int tipo) {
        Random rand = new Random();
        setMinHeight(i);
        setMinWidth(j);
        tipoAtual = tipos[tipo];
        this.vida = rand.nextInt(5)+1;
        this.força = rand.nextInt(5)+1;
        
        labelvida.setText(this.vida +"");
        labelforça.setText(this.força + "");
        getChildren().add(labelforça);
        getChildren().add(labelvida);
        labelvida.setLayoutX(23);    
        labelforça.setLayoutX(80); 
        labelvida.setLayoutY(95); 
        labelforça.setLayoutY(95);

        labelvida.setId("labelVida");
        labelforça.setId("labelForca");
        
        setBackground(new Background(getImage(tipo)));
        
        custo = vida/2 + força;

    }
}
