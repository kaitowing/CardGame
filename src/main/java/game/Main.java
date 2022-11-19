package game;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{ 
    
    private AnchorPane backPane = new AnchorPane();

    private AnchorPane rightPane = new AnchorPane();

    private Jogador jogador1 = new Jogador();

    private Jogador jogador2 = new Jogador();

    private VBox idleCards2 = new VBox();

    private VBox arenaCards2 = new VBox();

    private BorderPane center2 = new BorderPane();
    
    private Button endRound = new Button("Finalizar Rodada");

    private Button endRound2 = new Button("Finalizar Rodada");

    private AnchorPane leftPane = new AnchorPane();

    private VBox idleCards = new VBox();

    private VBox arenaCards = new VBox();

    private BorderPane center = new BorderPane();

    private Rodada rodada = new Rodada();

    public void startGameLeft(){
        ArrayList<Carta> cartasteste = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            Carta quadr = new Carta();
            quadr.setOnMouseClicked(e -> {
                trocararena(quadr);
            });
            cartasteste.add(quadr);
        }

        
        backPane.minHeight(720);
        backPane.minWidth(1280);
        backPane.maxHeight(720);
        backPane.maxWidth(1280);
        
        backPane.getChildren().add(leftPane);
        backPane.setRightAnchor(leftPane, 640.0);
        leftPane.prefHeight(720);
        leftPane.prefWidth(640);
        
        center.setPrefHeight(720);
        center.setPrefWidth(400);
        leftPane.getChildren().add(center);
        leftPane.setLeftAnchor(center, 120.0);
        
        leftPane.getChildren().add(idleCards);
        leftPane.setRightAnchor(idleCards, 520.0);
        idleCards.setAlignment(Pos.TOP_CENTER);
        idleCards.setLayoutX(19.0);
        idleCards.setLayoutY(11);
        idleCards.setPrefHeight(720);
        idleCards.setPrefWidth(120);
        idleCards.setSpacing(10);
        idleCards.setPadding(new Insets(0, 10, 10, 0));
        
        leftPane.getChildren().add(arenaCards);
        leftPane.setLeftAnchor(arenaCards,520.0);
        arenaCards.setAlignment(Pos.TOP_CENTER);
        arenaCards.setLayoutX(19);
        arenaCards.setLayoutY(11);
        arenaCards.setPrefHeight(720);
        arenaCards.setPrefWidth(120);
        arenaCards.setSpacing(10);

        
        endRound.setOnMouseClicked(e -> {
            endRound1();
        });
        endRound.setVisible(true);
        center.setTop(endRound);
        center.setAlignment(endRound, Pos.TOP_CENTER);


        

        for (int i = 0; i < 5; i++) {
            idleCards.getChildren().add(cartasteste.get(i));
        }
    }

    public void startGameRight(){

        ArrayList<Carta> cartasteste = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            Carta quadr = new Carta();
            quadr.setOnMouseClicked(e -> {
                trocararena(quadr);
            });
            cartasteste.add(quadr);
        }

        
        backPane.minHeight(720);
        backPane.minWidth(1280);
        backPane.maxHeight(720);
        backPane.maxWidth(1280);
        
        backPane.getChildren().add(rightPane);
        backPane.setLeftAnchor(rightPane, 640.0);
        rightPane.prefHeight(720);
        rightPane.prefWidth(640);
        
        center2.setPrefHeight(720);
        center2.setPrefWidth(400);
        rightPane.getChildren().add(center2);
        rightPane.setRightAnchor(center2, 120.0);
        
        rightPane.getChildren().add(idleCards2);
        rightPane.setLeftAnchor(idleCards2, 520.0);
        idleCards2.setAlignment(Pos.TOP_CENTER);
        idleCards2.setLayoutX(19.0);
        idleCards2.setLayoutY(11);
        idleCards2.setPrefHeight(720);
        idleCards2.setPrefWidth(120);
        idleCards2.setSpacing(10);
        idleCards2.setPadding(new Insets(0, 10, 10, 0));
        
        rightPane.getChildren().add(arenaCards2);
        rightPane.setRightAnchor(arenaCards2,520.0);
        arenaCards2.setAlignment(Pos.TOP_CENTER);
        arenaCards2.setLayoutX(19);
        arenaCards2.setLayoutY(11);
        arenaCards2.setPrefHeight(720);
        arenaCards2.setPrefWidth(120);
        arenaCards2.setSpacing(10);

        endRound2.setOnMouseClicked(e -> {
            endRound2();
        });
        endRound2.setVisible(true);
        center2.setTop(endRound2);
        center2.setAlignment(endRound2, Pos.TOP_CENTER);
        

        for (int i = 0; i < 5; i++) {
            idleCards2.getChildren().add(cartasteste.get(i));
        }
        
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        startGameLeft();
        startGameRight();

        Scene cena = new Scene(backPane);
        
        primaryStage.setTitle("Poggers");
        primaryStage.setScene(cena);
        primaryStage.setResizable(false);
        primaryStage.show();
    
    }

    public void endRound1(){
        if(rodada.getRoundState() == 1){
            
        }
    }

    public void endRound2(){

    }

    public void trocararena(Node obj){
        if(obj.getParent() == idleCards){
            arenaCards.getChildren().addAll(obj);
        }else if(obj.getParent() == arenaCards){
            idleCards.getChildren().add(obj);
        }else if(obj.getParent() == idleCards2){
            arenaCards2.getChildren().addAll(obj);
        }else{
            idleCards2.getChildren().addAll(obj);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }


}
