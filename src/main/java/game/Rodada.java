package game;

public class Rodada {
    private int round = 1;
    private Jogador jogador1;
    private Jogador jogador2;

    public Rodada(Jogador jog1, Jogador jog2){
        jogador1 = jog1;
        jogador2 = jog2;
    }
    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void passaRound(){
        this.round++;
        jogador1.upaMana();
        jogador2.upaMana();
    }

    public void reset(){
        round = 1;
    }
}
