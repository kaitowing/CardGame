package game;

import javafx.scene.control.Label;

public class Jogador {
    private int vidas;
    private boolean roundState;
    private Mao mao;
    private int mana = 4;
    Label mostraMana = new Label();
    Label mostraVida = new Label();
    private Arena arena = new Arena();

    public Jogador(String mao){
        vidas = 20;
        this.mao = new Mao(mao);
        mostraMana.setId("mana");
        mostraVida.setId("vida");
        atualizaMana();
        atualizaVida();
    }
    public int getPontos() {
        return vidas;
    }
    public void setPontos(int pontos) {
        this.vidas = pontos;
    }

    public int getMana() {
        return mana;
    }

    public boolean gastaMana(Carta card){
        if(mana - card.getCusto()>=0){
            mana = mana - card.getCusto();
            return true;
        }else{
            return false;
        }
    }

    public Mao getMao() {
        return mao;
    }

    public void restoreMana(Carta card){
        mana += card.getCusto();
    }

    public Label getMostraMana() {
        return mostraMana;
    }

    public void atualizaMana(){
        mostraMana.setText("Mana Atual: "+mana);
    }

    public void atualizaVida(){
        mostraVida.setText("Vida: " + vidas);
    }

    public Label getMostraVida() {
        return mostraVida;
    }

    public void upaMana(int newmana){
        mana = newmana;
        atualizaMana();
        atualizaVida();
    }

    public void tiraPonto(int dano){
        vidas = vidas - dano;
    }

    public Arena getArena() {
        return arena;
    }

    public void setRoundState(boolean roundState) {
        this.roundState = roundState;
    }

    public boolean roundState(){
        return roundState;
    }

    public void botaPonto(){
        vidas++;
    }
}
