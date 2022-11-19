package game;

public class Jogador {
    private int vidas = 0;
    private boolean roundState;

    public int getPontos() {
        return vidas;
    }
    public void setPontos(int pontos) {
        this.vidas = pontos;
    }

    public void tiraPonto(){
        vidas--;
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
