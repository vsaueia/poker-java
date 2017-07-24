package vsaueia.poker.jogadas;

import vsaueia.poker.modelo.MaoDoJogador;

import java.math.BigDecimal;

public class Flush extends Jogada {

    public Flush(MaoDoJogador maoDoJogador) {
        super(maoDoJogador);
    }

    @Override
    public boolean maoCasaComJogada() {
        return getMaoDoJogador().obterNaipesDaMao().stream().distinct().count() == 1;
    }

    @Override
    public BigDecimal calcularRanking() {
        return Ranking.FLUSH.add(super.obterFator());
    }

    @Override
    protected String obterDescricao() {
        return "Flush";
    }
}
