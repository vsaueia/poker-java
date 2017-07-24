package vsaueia.poker.jogadas;

import vsaueia.poker.modelo.MaoDoJogador;

import java.math.BigDecimal;

public class CartaMaior extends Jogada {

    public CartaMaior(MaoDoJogador maoDoJogador) {
        super(maoDoJogador);
    }

    @Override
    public boolean maoCasaComJogada() {
        return true;
    }

    @Override
    public BigDecimal calcularRanking() {
        BigDecimal mutiplicador = BigDecimal.valueOf(0.000001);
        BigDecimal fator = BigDecimal.ZERO;
        for(int valor : getMaoDoJogador().obterValoresDasCartas()) {
            BigDecimal parteAtualDoFator = BigDecimal.valueOf(valor).multiply(mutiplicador);
            fator = fator.add(parteAtualDoFator);
            mutiplicador = mutiplicador.multiply(BigDecimal.TEN);
        }
        return Ranking.MAIOR_CARTA.add(fator);
    }

    @Override
    protected String obterDescricao() {
        return "Maior carta";
    }
}
