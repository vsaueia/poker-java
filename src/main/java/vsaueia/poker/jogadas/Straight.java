package vsaueia.poker.jogadas;

import vsaueia.poker.modelo.MaoDoJogador;

import java.math.BigDecimal;

public class Straight extends Jogada {

    public Straight(MaoDoJogador maoDoJogador) {
        super(maoDoJogador);
    }

    @Override
    public boolean maoCasaComJogada() {
        int quantidadeDeCartasEmSequencia = 1;
        for(int i = 0; i < getMaoDoJogador().obterValoresDasCartas().size() - 1; i++) {
            if ((getMaoDoJogador().obterValoresDasCartas().get(i) + 1) == getMaoDoJogador().obterValoresDasCartas().get(i + 1)) {
                quantidadeDeCartasEmSequencia++;
            }
        }

        if (quantidadeDeCartasEmSequencia == 5) {
            return true;
        }
        return false;
    }

    @Override
    public BigDecimal calcularRanking() {
        return Ranking.STRAIGHT.add(obterFator());
    }

    @Override
    protected String obterDescricao() {
        return "Straight";
    }
}
