package game;

import java.io.File;
import java.util.Random;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;

public class Partida {
    private Jogador jogador1 = new Jogador("Pog");

    private Jogador jogador2 = new Jogador("direita");

    private AudioClip player;

    private AudioClip battle;

    private Rodada rodada = new Rodada();

    public Partida(){
        startGame();
        player = new AudioClip(new File("src\\main\\java\\game\\music\\CardSound.mp3").toURI().toString());
        battle = new AudioClip(new File("src\\main\\java\\game\\music\\battle.mp3").toURI().toString());
        battle.setVolume(0.2);
    }

    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }

    public void setRodada(Rodada rodada) {
        this.rodada = rodada;
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public Rodada getRodada() {
        return rodada;
    }

    public void passaRound(){
        int mana;
        rodada.passaRound();
        if(getRodada().getRound()<11)
        mana = 3 + getRodada().getRound();
        else mana = 14;
        jogador1.upaMana(mana);
        jogador2.upaMana(mana);
    }

    public Carta generateCarta(int i){
        switch(i){
            case 1:
            return new CartaPirata(i);

            case 2:
            return new CartaPirata(i);
          
            
            case 3:
            return new CartaImediato(i);
        

            case 4:
            return new CartaImediato(i);
            

            case 5:
            return new CartaYonkou(i);
            

            case 6:
            return new CartaYonkou(i);
            

            case 7:

            return new CartaShishibukai(i);
           

            case 8:

            return new CartaShishibukai(i);
          

            case 9:
            return new CartaCapitao(i);


            case 10:
            return new CartaCapitao(i);


        }
        return null;
    }

    public void startGame(){
        Random rand = new Random();
        int size1 = jogador1.getMao().getChildren().size();
        int size2 = jogador2.getMao().getChildren().size();

        for (int i = 0; i < 5 - size1; i++) {
            Carta newcard = generateCarta(rand.nextInt(10)+1);
            newcard.setOnMouseClicked(e -> {
                if(!getJogador1().roundState() && !newcard.cardState())
                trocararena(newcard);
            });
            jogador1.getMao().getChildren().add(newcard);

        }

        for (int i = 0; i < 5 - size2; i++) {
            Carta newcard = generateCarta(rand.nextInt(10)+1);
            newcard.setOnMouseClicked(e -> {
                if(!getJogador2().roundState() && !newcard.cardState())
                trocararena(newcard);
            });
            jogador2.getMao().getChildren().add(newcard);
        }
    }

    public void trocararena(Node obj){
        if(obj.getParent() == jogador1.getMao() && !getJogador1().roundState()){
            if(((Carta) obj).getCusto()<= getJogador1().getMana()){
                jogador1.getArena().getChildren().addAll(obj);
                player.play();
                getJogador1().getArena().push((Carta) obj);
                getJogador1().gastaMana((Carta) obj);
            }
        }else if(obj.getParent() == jogador1.getArena() && !getJogador1().roundState()){
            jogador1.getMao().getChildren().add(obj);
            player.play();
            getJogador1().getArena().pop(obj);
            getJogador1().restoreMana((Carta) obj);
        }else if(obj.getParent() == jogador2.getMao() && !getJogador2().roundState()){
            if(((Carta) obj).getCusto()<= getJogador2().getMana()){
                jogador2.getArena().getChildren().addAll(obj);
                player.play();
                getJogador2().getArena().push((Carta) obj);
                getJogador2().gastaMana((Carta) obj);
            }
        }else if(!getJogador2().roundState()){
            jogador2.getMao().getChildren().addAll(obj);
            player.play();
            getJogador2().getArena().pop(obj);
            getJogador2().restoreMana((Carta) obj);
        }
        jogador1.atualizaMana();
        jogador1.atualizaVida();
        jogador2.atualizaMana();
        jogador2.atualizaVida();
    }

    public void endRound1(BorderPane center, Label ataque, BorderPane center2){
        int tamanho = jogador1.getArena().getChildren().size();
        if(getRodada().getRound()%2 == 1 && !getJogador1().roundState() || getJogador2().roundState()){
            if(getJogador2().roundState()){

                for (int i = 0; i < jogador1.getArena().getChildren().size(); i++) {
                    ((Carta) jogador1.getArena().getChildren().get(i)).setCardState(true);
                }
                if(jogador1.getArena().getChildren().size() > jogador2.getArena().getChildren().size()){
                    tamanho = jogador2.getArena().getChildren().size();}
                if(getJogador1().getPontos()<=0){
                    String style = getClass().getResource("style.css").toExternalForm();
                        Main.terminar(2,style);
                }else if(getJogador2().getPontos()<=0){
                    String style = getClass().getResource("style.css").toExternalForm();
                        Main.terminar(1,style);
                }
                else{
                    for (int i = 0; i < tamanho; i++) {
                        Carta pog = (Carta) jogador1.getArena().getChildren().get(i);
                        getJogador1().getArena().pop(jogador1.getArena().getChildren().get(i));
                        Carta pogger = (Carta) jogador2.getArena().getChildren().get(i);
                        getJogador2().getArena().pop(jogador1.getArena().getChildren().get(i));
                        pog.setVida(pog.getVida()-pogger.getForça());
                        pogger.setVida(pogger.getVida()-pog.getForça());
                        getJogador1().getArena().push(pog);
                        getJogador2().getArena().push(pogger);
                    }
                    if(jogador1.getArena().getChildren().size() > jogador2.getArena().getChildren().size()){
                        tamanho = jogador2.getArena().getChildren().size();
                        for (int i = tamanho; i < jogador1.getArena().getChildren().size(); i++) {
                            Carta card = getJogador1().getArena().pop();
                            getJogador2().tiraPonto(card.getForça()); 
                            getJogador1().getArena().push(card);
                        }
                    
                    }else{
                        tamanho = jogador1.getArena().getChildren().size();
                        for (int i = tamanho; i < jogador2.getArena().getChildren().size(); i++) {
                            Carta card = getJogador2().getArena().pop();
                            getJogador1().tiraPonto(card.getForça()); 
                            getJogador2().getArena().push(card);
                        }
                    }
    
                    for (Carta pog : getJogador1().getArena().getCartaList()) {
                        if(pog.getVida()<=0)
                        jogador1.getArena().getChildren().remove(pog);
                    }
                    
                    for (Carta pog : getJogador2().getArena().getCartaList()) {
                        if(pog.getVida()<=0)
                        jogador2.getArena().getChildren().remove(pog);
                    }
    
                    
                    startRound();
                    battlesound();
                }
            }
            jogador1.atualizaVida();
            jogador2.atualizaVida();
            //Não mexe nessa parte
            getJogador1().setRoundState(true);
            if(getJogador1().roundState() && getJogador2().roundState()){
                if(center.getLeft() != null)
                center2.setRight(ataque);
                else center.setLeft(ataque);
                passaRound();
                jogador1.atualizaMana();
                jogador2.atualizaVida();
                getJogador1().setRoundState(false);
                getJogador2().setRoundState(false);
            }
        }
    }

    public void battlesound(){
        battle.play();
    }

    public void endRound2(BorderPane center, Label ataque, BorderPane center2){
        int tamanho = jogador1.getArena().getChildren().size();
        if(getRodada().getRound()%2 == 0 && !getJogador2().roundState() || getJogador1().roundState()){
            if(getJogador1().roundState()){

                for (int i = 0; i < jogador2.getArena().getChildren().size(); i++) {
                    ((Carta) jogador2.getArena().getChildren().get(i)).setCardState(true);
                }
                if(jogador1.getArena().getChildren().size() > jogador2.getArena().getChildren().size()){
                    tamanho = jogador2.getArena().getChildren().size();}
                    if(getJogador1().getPontos()<=0){
                        String style = getClass().getResource("style.css").toExternalForm();
                        Main.terminar(2,style);
                    }else if(getJogador2().getPontos()<=0){
                        String style = getClass().getResource("style.css").toExternalForm();
                        Main.terminar(1,style);
                    }
                    else{
                        if(getJogador1().roundState()){
                            if(jogador1.getArena().getChildren().size() > jogador2.getArena().getChildren().size()){
                                tamanho = jogador2.getArena().getChildren().size();
                                for (int i = tamanho; i < jogador1.getArena().getChildren().size(); i++) {
                                    Carta card = getJogador1().getArena().pop();
                                    getJogador2().tiraPonto(card.getForça()); 
                                    getJogador1().getArena().push(card);
                                }
                            
                            }else{
                                tamanho = jogador1.getArena().getChildren().size();
                                for (int i = tamanho; i < jogador2.getArena().getChildren().size(); i++) {
                                    Carta card = getJogador2().getArena().pop();
                                    getJogador1().tiraPonto(card.getForça()); 
                                    getJogador2().getArena().push(card);
                                }
                            }
                        for (int i = 0; i < tamanho; i++) {
                            Carta pog = (Carta) jogador1.getArena().getChildren().get(i);
                            getJogador1().getArena().pop(jogador1.getArena().getChildren().get(i));
                            Carta pogger = (Carta) jogador2.getArena().getChildren().get(i);
                            getJogador2().getArena().pop(jogador1.getArena().getChildren().get(i));
                            pog.setVida(pog.getVida()-pogger.getForça());
                            pogger.setVida(pogger.getVida()-pog.getForça());
                            getJogador1().getArena().push(pog);
                            getJogador2().getArena().push(pogger);
                        }
        
                        for (Carta pog : getJogador1().getArena().getCartaList()) {
                            if(pog.getVida()<=0)
                            jogador1.getArena().getChildren().remove(pog);
                        }
                        
                        for (Carta pog : getJogador2().getArena().getCartaList()) {
                            if(pog.getVida()<=0)
                            jogador2.getArena().getChildren().remove(pog);
                        }
    
                        
                        startRound();
                        battlesound();
                    }
                }
            }
            jogador1.atualizaVida();
            jogador2.atualizaVida();
            //Não mexe nessa parte
            getJogador2().setRoundState(true);
            if(getJogador1().roundState() && getJogador2().roundState()){
                if(center2.getRight() != null)
                center.setLeft(ataque);
                else center2.setRight(ataque);
                passaRound();
                jogador1.atualizaMana();
                jogador2.atualizaMana();
                jogador1.atualizaVida();
                jogador2.atualizaVida();
                getJogador1().setRoundState(false);
                getJogador2().setRoundState(false);
            }
        }
    }

    public void startRound(){
        Random rand = new Random();
        if(getJogador1().getPontos()<=0){
            String style = getClass().getResource("style.css").toExternalForm();
            Main.terminar(2,style);
        }else if(getJogador2().getPontos()<=0){
            String style = getClass().getResource("style.css").toExternalForm();
            Main.terminar(1,style);
        }
        else{

            int size1 = jogador1.getMao().getChildren().size();
            int size2 = jogador2.getMao().getChildren().size();
    
            if(size1<5){
                Carta newcard = generateCarta(rand.nextInt(10)+1);
                newcard.setOnMouseClicked(e -> {
                    if(!getJogador1().roundState() && !newcard.cardState())
                    trocararena(newcard);
                });
                jogador1.getMao().getChildren().add(newcard);
            }
    
            if(size2<5){
                Carta newcard = generateCarta(rand.nextInt(10)+1);
                newcard.setOnMouseClicked(e -> {
                    if(!getJogador2().roundState() && !newcard.cardState())
                    trocararena(newcard);
                });
                jogador2.getMao().getChildren().add(newcard);
            }
        }
    }
}
