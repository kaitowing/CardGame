package game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class Mao extends VBox{
    public Mao(String lado){
        if(lado.equals("direita")){

        }else{
            this.setAlignment(Pos.TOP_CENTER);
            this.setLayoutX(19.0);
            this.setLayoutY(11);
            this.setPrefHeight(720);
            this.setPrefWidth(120);
            this.setSpacing(10);
            this.setPadding(new Insets(0, 10, 10, 0));
        }
    }
}
