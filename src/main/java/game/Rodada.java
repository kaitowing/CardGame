package game;

public class Rodada {
    private int round = 1;
    
    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void passaRound(){
        this.round++;
    }

    public void reset(){
        round = 1;
    }
}
