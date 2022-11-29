package game;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;


import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;

import javafx.scene.layout.Pane;


public abstract class Carta extends Pane{

    protected String tipoAtual;

    private Label labelvida = new Label();

    private int custo;

    private Label labelforça = new Label();

    private boolean cardState;

    protected int vida;

    protected int força;

    public Carta(){
        this(120,100);
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

    public Carta(int i, int j) {
        setMinHeight(i);
        setMinWidth(j);
    }

    public void build(){
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
        custo = vida/2 + força;
        Label mana = new Label(custo+"");
        getChildren().add(mana);
        mana.setLayoutX(10);
        mana.setLayoutY(3);
        mana.setId("manaCarta");
    }
}
