package game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{ 
    
    //Layout
    private AnchorPane backPane = new AnchorPane();
    private AnchorPane rightPane = new AnchorPane();
    private VBox idleCards2 = new VBox();
    private VBox arenaCards2 = new VBox();
    private BorderPane center2 = new BorderPane();
    private Button endRound = new Button("Finalizar Rodada");
    private Button endRound2 = new Button("Finalizar Rodada");
    private AnchorPane leftPane = new AnchorPane();
    private VBox idleCards = new VBox();
    private VBox arenaCards = new VBox();
    private BorderPane center = new BorderPane();
    
    private Partida partida = new Partida();
    private Label mana = new Label("Mana Atual: " + partida.getJogador1().getMana());
    private Label mana2 = new Label("Mana Atual: " + partida.getJogador2().getMana());
    private Label ataque = new Label("Sua vez de atacar!");
    private Label vida1 = new Label("Vida: " + partida.getJogador1().getPontos());
    private Label vida2 = new Label("Vida: " + partida.getJogador2().getPontos());

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
        arenaCards.setPadding(new Insets(0, 10, 10, 0));

        
        endRound.setOnMouseClicked(e -> {
            endRound1();
        });
        endRound.setVisible(true);
        endRound.setId("endround1");
        endRound2.setId("endround2");
        center.setTop(endRound);
        center.setAlignment(endRound, Pos.TOP_CENTER);
        center.setBottom(mana);
        center.setRight(vida1);
        vida1.setAlignment(Pos.TOP_LEFT);
        vida1.setId("vida1");
        vida2.setId("vida2");
        center.setMargin(vida1, new Insets(0, 50, 0, 0));
        mana.setId("Mana1");
    }

    public void StartGameRight(){
        
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
        arenaCards2.setPadding(new Insets(0, 10, 10, 0));

        endRound2.setOnMouseClicked(e -> {
            endRound2();
        });
        endRound2.setVisible(true);
        center2.setTop(endRound2);
        center2.setBottom(mana2);
        mana2.setId("mana2");
        center2.setAlignment(endRound2, Pos.TOP_CENTER);
        center2.setAlignment(mana2, Pos.BOTTOM_RIGHT);
        center2.setLeft(vida2);
        center.setLeft(ataque);
        vida2.setAlignment(Pos.TOP_RIGHT);
        ataque.setId("ataque");
        center2.setMargin(vida2, new Insets(0, 0, 0, 50));

        
    }

    public void reStartGame(){
        int idlsize = idleCards.getChildren().size();
        int idl2size =idleCards2.getChildren().size();
        int arenasize = arenaCards.getChildren().size();
        int arena2size =arenaCards2.getChildren().size();
        if(idlsize!=0){
            for (int i = 0; i < idlsize; i++) {
                idleCards.getChildren().remove(0);
            }
        }

        if(idl2size!=0){
            for (int i = 0; i < idl2size; i++) {
                idleCards2.getChildren().remove(0);
            }
        }
        if(arenasize!=0){
            for (int i = 0; i < arenasize; i++) {
                arenaCards.getChildren().remove(0);
            }
        }
        if(arena2size!=0){
            for (int i = 0; i < arena2size; i++) {
                arenaCards2.getChildren().remove(0);
            }
        }

        partida = new Partida();
        startGame();
        atualizaMana();
        atualizaVida();
    }   

    public void atualizaVida(){
        vida1.setText("Vida: " + partida.getJogador1().getPontos());
        vida2.setText("Vida: " + partida.getJogador2().getPontos());
        if(partida.getJogador1().getPontos()<=0 || partida.getJogador1().getPontos()<=0){
            terminar();
        }
    }

    public void startGame(){

        int size1 = idleCards.getChildren().size();
        int size2 = idleCards2.getChildren().size();

        for (int i = 0; i < 5 - size1; i++) {
            Carta newcard = generateCard();
            newcard.setOnMouseClicked(e -> {
                if(!partida.getJogador1().roundState() && !newcard.cardState())
                trocararena(newcard);
            });
            idleCards.getChildren().add(newcard);

        }

        for (int i = 0; i < 5 - size2; i++) {
            Carta newcard = generateCard();
            newcard.setOnMouseClicked(e -> {
                if(!partida.getJogador2().roundState() && !newcard.cardState())
                trocararena(newcard);
            });
            idleCards2.getChildren().add(newcard);
        }
    }

    public void startRound(){

        if(partida.getJogador1().getPontos()<=0 || partida.getJogador2().getPontos()<=0){
            terminar();
        }
        int size1 = idleCards.getChildren().size();
        int size2 = idleCards2.getChildren().size();

        if(size1<5){
            Carta newcard = generateCard();
            newcard.setOnMouseClicked(e -> {
                if(!partida.getJogador1().roundState() && !newcard.cardState())
                trocararena(newcard);
            });
            idleCards.getChildren().add(newcard);
        }

        if(size2<5){
            Carta newcard = generateCard();
            newcard.setOnMouseClicked(e -> {
                if(!partida.getJogador2().roundState() && !newcard.cardState())
                trocararena(newcard);
            });
            idleCards2.getChildren().add(newcard);
        }
    }

    public Carta generateCard(){
        Random rand = new Random();
        return new Carta(rand.nextInt(10)+1);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

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
        startGame();

        Scene cena = new Scene(backPane);
        cena.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        cena.getStylesheets().add("https://fonts.googleapis.com/css2?family=Roboto+Condensed");
        
        primaryStage.setTitle("One Piece Card Game");
        primaryStage.setScene(cena);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void endRound1(){
        int tamanho = arenaCards.getChildren().size();
        if(partida.getRodada().getRound()%2 == 1 && !partida.getJogador1().roundState() || partida.getJogador2().roundState()){
            if(partida.getJogador2().roundState()){

                for (int i = 0; i < arenaCards.getChildren().size(); i++) {
                    ((Carta) arenaCards.getChildren().get(i)).setCardState(true);
                }
                if(arenaCards.getChildren().size() > arenaCards2.getChildren().size()){
                    tamanho = arenaCards2.getChildren().size();}
                if(partida.getJogador1().getPontos()<=0 || partida.getJogador1().getPontos()<=0){
                    terminar();
                }else{
                    for (int i = 0; i < tamanho; i++) {
                        Carta pog = (Carta) arenaCards.getChildren().get(i);
                        partida.getJogador1().getArena().pop(arenaCards.getChildren().get(i));
                        Carta pogger = (Carta) arenaCards2.getChildren().get(i);
                        partida.getJogador2().getArena().pop(arenaCards.getChildren().get(i));
                        pog.setVida(pog.getVida()-pogger.getForça());
                        pogger.setVida(pogger.getVida()-pog.getForça());
                        partida.getJogador1().getArena().push(pog);
                        partida.getJogador2().getArena().push(pogger);
                    }
                    if(arenaCards.getChildren().size() > arenaCards2.getChildren().size()){
                        tamanho = arenaCards2.getChildren().size();
                        for (int i = tamanho; i < arenaCards.getChildren().size(); i++) {
                            Carta card = partida.getJogador1().getArena().pop();
                            partida.getJogador2().tiraPonto(card.getForça()); 
                            partida.getJogador1().getArena().push(card);
                        }
                    
                    }else{
                        tamanho = arenaCards.getChildren().size();
                        for (int i = tamanho; i < arenaCards2.getChildren().size(); i++) {
                            Carta card = partida.getJogador2().getArena().pop();
                            partida.getJogador1().tiraPonto(card.getForça()); 
                            partida.getJogador2().getArena().push(card);
                        }
                    }
    
                    for (Carta pog : partida.getJogador1().getArena().getCartaList()) {
                        if(pog.getVida()<=0)
                        arenaCards.getChildren().remove(pog);
                    }
                    
                    for (Carta pog : partida.getJogador2().getArena().getCartaList()) {
                        if(pog.getVida()<=0)
                        arenaCards2.getChildren().remove(pog);
                    }
    
                    
                    startRound();
                }
            }
            atualizaVida();
            //Não mexe nessa parte
            partida.getJogador1().setRoundState(true);
            if(partida.getJogador1().roundState() && partida.getJogador2().roundState()){
                if(center.getLeft() != null)
                center2.setRight(ataque);
                else center.setLeft(ataque);
                partida.getRodada().passaRound();
                atualizaMana();
                atualizaVida();
                partida.getJogador1().setRoundState(false);
                partida.getJogador2().setRoundState(false);
            }
        }
    }

    public void endRound2(){
        int tamanho = arenaCards.getChildren().size();
        if(partida.getRodada().getRound()%2 == 0 && !partida.getJogador2().roundState() || partida.getJogador1().roundState()){
            if(partida.getJogador1().roundState()){

                for (int i = 0; i < arenaCards2.getChildren().size(); i++) {
                    ((Carta) arenaCards2.getChildren().get(i)).setCardState(true);
                }
                if(arenaCards.getChildren().size() > arenaCards2.getChildren().size()){
                    tamanho = arenaCards2.getChildren().size();}
                    if(partida.getJogador2().getPontos()<=0 || partida.getJogador1().getPontos()<=0){
                        System.exit(1);
                    }else{
                        if(partida.getJogador1().roundState()){
                            if(arenaCards.getChildren().size() > arenaCards2.getChildren().size()){
                                tamanho = arenaCards2.getChildren().size();
                                for (int i = tamanho; i < arenaCards.getChildren().size(); i++) {
                                    Carta card = partida.getJogador1().getArena().pop();
                                    partida.getJogador2().tiraPonto(card.getForça()); 
                                    partida.getJogador1().getArena().push(card);
                                }
                            
                            }else{
                                tamanho = arenaCards.getChildren().size();
                                for (int i = tamanho; i < arenaCards2.getChildren().size(); i++) {
                                    Carta card = partida.getJogador2().getArena().pop();
                                    partida.getJogador1().tiraPonto(card.getForça()); 
                                    partida.getJogador2().getArena().push(card);
                                }
                            }
                        for (int i = 0; i < tamanho; i++) {
                            Carta pog = (Carta) arenaCards.getChildren().get(i);
                            partida.getJogador1().getArena().pop(arenaCards.getChildren().get(i));
                            Carta pogger = (Carta) arenaCards2.getChildren().get(i);
                            partida.getJogador2().getArena().pop(arenaCards.getChildren().get(i));
                            pog.setVida(pog.getVida()-pogger.getForça());
                            pogger.setVida(pogger.getVida()-pog.getForça());
                            partida.getJogador1().getArena().push(pog);
                            partida.getJogador2().getArena().push(pogger);
                        }
        
                        for (Carta pog : partida.getJogador1().getArena().getCartaList()) {
                            if(pog.getVida()<=0)
                            arenaCards.getChildren().remove(pog);
                        }
                        
                        for (Carta pog : partida.getJogador2().getArena().getCartaList()) {
                            if(pog.getVida()<=0)
                            arenaCards2.getChildren().remove(pog);
                        }
    
                        
                        startRound();
                    }
                }
            }
            atualizaVida();
            //Não mexe nessa parte
            partida.getJogador2().setRoundState(true);
            if(partida.getJogador1().roundState() && partida.getJogador2().roundState()){
                partida.getRodada().passaRound();
                if(center2.getRight() != null)
                center.setLeft(ataque);
                else center2.setRight(ataque);
                atualizaMana();
                atualizaVida();
                partida.getJogador1().setRoundState(false);
                partida.getJogador2().setRoundState(false);
            }
        }
    }

    public void atualizaMana(){
        mana.setText("Mana Atual: " + partida.getJogador1().getMana());
        mana2.setText("Mana Atual: "+ partida.getJogador2().getMana());
    }

    public void trocararena(Node obj){
        if(obj.getParent() == idleCards && !partida.getJogador1().roundState()){
            if(((Carta) obj).getCusto()<= partida.getJogador1().getMana()){
                arenaCards.getChildren().addAll(obj);
                partida.getJogador1().getArena().push((Carta) obj);
                partida.getJogador1().gastaMana((Carta) obj);
            }
        }else if(obj.getParent() == arenaCards && !partida.getJogador1().roundState()){
            idleCards.getChildren().add(obj);
            partida.getJogador1().getArena().pop(obj);
            partida.getJogador1().restoreMana((Carta) obj);
        }else if(obj.getParent() == idleCards2 && !partida.getJogador2().roundState()){
            if(((Carta) obj).getCusto()<= partida.getJogador2().getMana()){
                arenaCards2.getChildren().addAll(obj);
                partida.getJogador2().getArena().push((Carta) obj);
                partida.getJogador2().gastaMana((Carta) obj);
            }
        }else if(!partida.getJogador2().roundState()){
            idleCards2.getChildren().addAll(obj);
            partida.getJogador2().getArena().pop(obj);
            partida.getJogador2().restoreMana((Carta) obj);
        }
        atualizaMana();
        atualizaVida();
    }
    
    public void terminar(){
        
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
        if(partida.getJogador1().getPontos()>partida.getJogador2().getPontos())
        ganhador = "1";
        Label ganhou = new Label("Jogador "+ ganhador + " ganhou!");
        ganhou.setAlignment(Pos.CENTER);
        Button reStart = new Button("Jogar Novamente");
        Button sair = new Button("Sair do jogo");
        sair.setOnAction(e->{
            System.exit(1);
        });
        reStart.setOnAction(e->{
            pog.hide();
            reStartGame();
        });
        Scene finalScene = new Scene(finalPane);
        sair.setId("sair");
        reStart.setId("restart");
        ganhou.setId("ganhador");

        box.getChildren().addAll(ganhou,sair,reStart);
        sair.setAlignment(Pos.CENTER);
        reStart.setAlignment(Pos.CENTER);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(20);

        finalScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        finalScene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Oswald");
        pog.setTitle("Ganhador!");
        pog.setScene(finalScene);
        pog.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
