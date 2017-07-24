package vsaueia.poker.jogadas;

import vsaueia.poker.modelo.MaoDoJogador;

import java.math.BigDecimal;

public class RoyalStraightFlush extends Jogada {
    private Straight straight;
    private Flush flush;

    public RoyalStraightFlush(MaoDoJogador maoDoJogador) {
        super(maoDoJogador);
        this.straight = new Straight(maoDoJogador);
        this.flush = new Flush(maoDoJogador);
    }

    @Override
    public boolean maoCasaComJogada() {
        boolean ehAMaiorSequencia = getMaoDoJogador().obterValorDaPrimeiraCarta() == 10;
        return this.straight.maoCasaComJogada() && this.flush.maoCasaComJogada() && ehAMaiorSequencia;
    }

    @Override
    public BigDecimal calcularRanking() {
        return Ranking.ROYAL_STRAIGHT_FLUSH;
    }

    @Override
    protected String obterDescricao() {
        return "Royal Straight Flush";
    }

}
