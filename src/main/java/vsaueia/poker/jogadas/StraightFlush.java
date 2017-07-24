package vsaueia.poker.jogadas;

import vsaueia.poker.modelo.MaoDoJogador;

import java.math.BigDecimal;

public class StraightFlush extends Jogada {
    private Straight straight;
    private Flush flush;

    public StraightFlush(MaoDoJogador maoDoJogador) {
        super(maoDoJogador);
        this.straight = new Straight(maoDoJogador);
        this.flush = new Flush(maoDoJogador);
    }

    @Override
    public boolean maoCasaComJogada() {
        return straight.maoCasaComJogada() && flush.maoCasaComJogada();
    }

    @Override
    public BigDecimal calcularRanking() {
        return Ranking.STRAIGHT_FLUSH.add(super.obterFator());
    }

    @Override
    protected String obterDescricao() {
        return "Straight Flush";
    }
}
