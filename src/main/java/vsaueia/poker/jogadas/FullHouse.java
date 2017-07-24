package vsaueia.poker.jogadas;

import vsaueia.poker.modelo.MaoDoJogador;

import java.math.BigDecimal;

public class FullHouse extends Jogada {

    private Trinca trinca;
    private UmPar umPar;

    public FullHouse(MaoDoJogador maoDoJogador) {
        super(maoDoJogador);
        this.trinca = new Trinca(maoDoJogador);
        this.umPar = new UmPar(maoDoJogador);
    }

    @Override
    public boolean maoCasaComJogada() {
        return this.trinca.maoCasaComJogada() && this.umPar.maoCasaComJogada();
    }

    @Override
    public BigDecimal calcularRanking() {
        return Ranking.FULL_HOUSE.add(super.obterFator());
    }

    @Override
    protected String obterDescricao() {
        return "Full House";
    }
}
