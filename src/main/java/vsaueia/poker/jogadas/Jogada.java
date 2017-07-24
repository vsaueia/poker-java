package vsaueia.poker.jogadas;

import vsaueia.poker.modelo.MaoDoJogador;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Jogada {

    private final MaoDoJogador maoDoJogador;

    public Jogada(MaoDoJogador maoDoJogador) {
        this.maoDoJogador = maoDoJogador;
    }

    public abstract boolean maoCasaComJogada();
    public abstract BigDecimal calcularRanking();

    protected MaoDoJogador getMaoDoJogador() {
        return maoDoJogador;
    }

    public BigDecimal obterFator() {
        Map<Integer, List<Integer>> cartasAgrupadas = getMaoDoJogador().obterContagemDeCartasUnicasNaMao();
        BigDecimal multiplicador = new BigDecimal("0.01");
        BigDecimal fator = BigDecimal.ZERO;
        for (Integer carta : cartasAgrupadas.keySet()) {
            fator = BigDecimal.valueOf(carta).multiply(multiplicador);
            multiplicador = multiplicador.divide(BigDecimal.TEN);
        }
        return fator;
    }

    @Override
    public String toString() {

        String cartas = Arrays.stream(maoDoJogador.getCartas())
                .map(carta -> ""+carta.getValor()+carta.getNaipe().getSimbolo())
                .collect(Collectors.joining(" "));
        return String.format("%s -> %s", cartas, obterDescricao());
    }

    protected abstract String obterDescricao();
}
