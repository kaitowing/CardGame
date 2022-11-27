package game;

public class Jogador {
    private int vidas;
    private boolean roundState;
    private int mana = 6;
    private Partida partida;
    private Arena arena = new Arena();

    public Jogador(Partida partida){
        this.partida = partida;
        vidas = 20;
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

    public void restoreMana(Carta card){
        mana += card.getCusto();
    }

    public void upaMana(){
        if(partida.getRodada().getRound()<11)
       mana = 4 + partida.getRodada().getRound();
       else mana = 10;
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
