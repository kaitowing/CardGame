package game;

public class Rodada {
    private int round = 1;
    private int roundState = 1;

    public int getRoundState() {
        return roundState;
    }
    
    public void setRoundState(int roundState) {
        this.roundState = roundState;
    }
    
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
