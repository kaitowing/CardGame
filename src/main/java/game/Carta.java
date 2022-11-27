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


public class Carta extends Pane{
    
    private String[] tipos = {
        "","PIRATA","IMEDIATO","YONKOU","SHISHIBUKAI", "CAPITÃO"
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
        if(tipo<3)
        tipoAtual = tipos[1];
        else if(tipo <5)
        tipoAtual = tipos[2];
        else if(tipo<7)
        tipoAtual = tipos[3];
        else if(tipo<9)
        tipoAtual = tipos[4];
        else tipoAtual = tipos[5];

        switch(tipo){
            case 1:
            this.vida = 2;
            this.força = 4;
            break;

            case 2:
            this.vida = 3;
            this.força = 3;
            break;
            
            case 3:
            this.vida = 4;
            this.força = 2;
            break;

            case 4:
            this.vida = 3;
            this.força = 4;
            break;

            case 5:
            this.vida = 5;
            this.força = 5;
            break;

            case 6:
            this.vida = 5;
            this.força = 4;
            break;

            case 7:

            this.vida = 3;
            this.força = 5;
            break;

            case 8:

            this.vida = 3;
            this.força = 3;
            break;

            case 9:
            this.vida = 4;
            this.força = 4;
            break;

            case 10:
            this.vida = 2;
            this.força = 4;
            break;

        }
        
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
        mana.setLayoutY(5);
        setBackground(new Background(getImage(tipo)));
        mana.setId("manaCarta");

    }
}
