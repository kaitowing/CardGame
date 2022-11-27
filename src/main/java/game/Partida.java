package game;

public class Partida {
    private Jogador jogador1 = new Jogador(this);

    private Jogador jogador2 = new Jogador(this);

    private Rodada rodada = new Rodada(jogador1,jogador2);

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

}
