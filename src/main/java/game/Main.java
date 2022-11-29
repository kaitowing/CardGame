package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{ 
    
    private Partida partida = new Partida();
    //Layout
    private AnchorPane backPane = new AnchorPane();
    private AnchorPane rightPane = new AnchorPane();
    private VBox idleCards2 = partida.getJogador2().getMao();
    private VBox arenaCards2 = partida.getJogador2().getArena();
    private BorderPane center2 = new BorderPane();
    private Button endRound = new Button("Finalizar Rodada");
    private Button endRound2 = new Button("Finalizar Rodada");
    private AnchorPane leftPane = new AnchorPane();
    private VBox idleCards = partida.getJogador1().getMao();
    private VBox arenaCards = partida.getJogador1().getArena();
    private BorderPane center = new BorderPane();
    
    private Label mana = partida.getJogador1().getMostraMana();
    private Label mana2 = partida.getJogador2().getMostraMana();
    private Label ataque = new Label("Sua vez de atacar!");
    private Label vida1 = partida.getJogador1().getMostraVida();
    private Label vida2 = partida.getJogador2().getMostraVida();

    //Métodos
    public void StartGameLeft() throws FileNotFoundException{
        backPane.setMinHeight(720);
        backPane.setMinWidth(1280);
        
        FileInputStream file = new FileInputStream("src\\main\\java\\game\\images\\fundo.png");
        Image fundo = new Image(file);
        BackgroundSize size = new BackgroundSize(1.0, 1.0, true, true, false, false);
        backPane.setBackground(new Background(new BackgroundImage(fundo, null, null, null, size)));
        
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
        
        
        leftPane.getChildren().add(arenaCards);
        leftPane.setLeftAnchor(arenaCards,520.0);
        
        
        endRound.setOnMouseClicked(e -> {
            partida.endRound1(center, ataque, center2);
        });
        endRound.setVisible(true);
        endRound.setId("endround1");
        endRound2.setId("endround2");
        center.setTop(endRound);
        center.setAlignment(endRound, Pos.TOP_CENTER);
        center.setBottom(mana);
        center.setRight(vida1);
        vida1.setAlignment(Pos.TOP_LEFT);
        vida1.setId("vida");
        vida2.setId("vida");
        center.setMargin(vida1, new Insets(0, 50, 0, 0));
        mana.setId("mana");
        mana2.setId("mana");
    }

    public void StartGameRight(){
        
        backPane.minHeight(720);
        backPane.minWidth(1280);
        
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
        idleCards2.setPadding(new Insets(0, 0, 10, 10));
        
        rightPane.getChildren().add(arenaCards2);
        rightPane.setRightAnchor(arenaCards2,520.0);
        arenaCards2.setAlignment(Pos.TOP_CENTER);
        arenaCards2.setLayoutX(19);
        arenaCards2.setLayoutY(11);
        arenaCards2.setPrefHeight(720);
        arenaCards2.setPrefWidth(120);
        arenaCards2.setSpacing(10);
        arenaCards2.setPadding(new Insets(0, 0, 10, 10));

        endRound2.setOnMouseClicked(e -> {
            partida.endRound2(center, ataque, center2);
        });
        endRound2.setVisible(true);
        center2.setTop(endRound2);
        center2.setBottom(mana2);
        center2.setAlignment(endRound2, Pos.TOP_CENTER);
        center2.setAlignment(mana2, Pos.BOTTOM_RIGHT);
        center2.setLeft(vida2);
        center.setLeft(ataque);
        vida2.setAlignment(Pos.TOP_RIGHT);
        ataque.setId("ataque");
        center2.setMargin(vida2, new Insets(0, 0, 0, 50));

        
    }

   

    public void atualizaVida(){
        vida1.setText("Vida: " + partida.getJogador1().getPontos());
        vida2.setText("Vida: " + partida.getJogador2().getPontos());
        if(partida.getJogador1().getPontos()<=0){
            String style = getClass().getResource("style.css").toExternalForm();
            terminar(2,style);
        }else if(partida.getJogador2().getPontos()<=0){
            String style = getClass().getResource("style.css").toExternalForm();
            terminar(1,style);
        }
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AudioClip media = new AudioClip(new File("src\\main\\java\\game\\music\\X2Download.com - The Witcher 3 Wild Hunt Soundtrack - Gwent Full Mix (192 kbps).mp3").toURI().toString());
        media.setVolume(0.25);
        media.play();
        media.setCycleCount(100);
        primaryStage();
    
    }

    public void primaryStage(){

        Stage primaryStage = new Stage();
        try {
            StartGameLeft();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        StartGameRight();

        Scene cena = new Scene(backPane);
        cena.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        cena.getStylesheets().add("https://fonts.googleapis.com/css2?family=Roboto+Condensed");
        cena.getStylesheets().add("https://fonts.googleapis.com/css2?family=Rubik+Distressed");
        
        primaryStage.setTitle("One Piece Card Game");
        primaryStage.setScene(cena);
        primaryStage.setResizable(false);
        primaryStage.show();
    }  

    public static void terminar(int i,Object style){
        
        Stage pog = new Stage();
        AnchorPane finalPane = new AnchorPane();
        finalPane.setMinHeight(200);
        finalPane.setMinWidth(200);
        VBox box = new VBox();
        finalPane.getChildren().addAll(box);
        finalPane.setRightAnchor(box, 50.0);
        finalPane.setLeftAnchor(box, 50.0);
        finalPane.setTopAnchor(box, 50.0);
        finalPane.setBottomAnchor(box, 50.0);
        String ganhador = "2";
        if(i == 1)
        ganhador = "1";
        else ganhador = "2";
        Label ganhou = new Label("Jogador "+ ganhador + " ganhou!");
        ganhou.setAlignment(Pos.CENTER);
        Button sair = new Button("Sair do jogo");
        sair.setOnAction(e->{
            System.exit(1);
        });
        Scene finalScene = new Scene(finalPane);
        sair.setId("sair");
        ganhou.setId("ganhador");

        box.getChildren().addAll(ganhou,sair);
        sair.setAlignment(Pos.CENTER);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(20);

        finalScene.getStylesheets().add((String) style);
        finalScene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Oswald");
        pog.setTitle("Ganhador!");
        pog.setScene(finalScene);
        pog.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
