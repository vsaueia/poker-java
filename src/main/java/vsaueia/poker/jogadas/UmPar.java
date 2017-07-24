package vsaueia.poker.jogadas;

import vsaueia.poker.modelo.MaoDoJogador;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UmPar extends Jogada {
    public UmPar(MaoDoJogador maoDoJogador) {
        super(maoDoJogador);
    }

    @Override
    public boolean maoCasaComJogada() {
        Map<Integer, List<Integer>> cartasAgrupadas = getMaoDoJogador().obterContagemDeCartasUnicasNaMao();
        boolean temUmPar = cartasAgrupadas.values().stream().anyMatch(lista -> lista.size() == 2);
        return temUmPar;
    }

    @Override
    public BigDecimal calcularRanking() {
        int cartaDaDupla = obterCartaDaDupla();
        BigDecimal fatorDaDupla = BigDecimal.valueOf(cartaDaDupla).multiply(BigDecimal.valueOf(0.01));
        BigDecimal fatorDeDesempate = obterFatorDeDesempate();
        return Ranking.UM_PAR.add(fatorDaDupla).add(fatorDeDesempate);
    }

    @Override
    protected String obterDescricao() {
        return "Um par";
    }

    private BigDecimal obterFatorDeDesempate() {
        Map<Integer, List<Integer>> cartasAgrupadas = getMaoDoJogador().obterContagemDeCartasUnicasNaMao();
        BigDecimal fator = BigDecimal.ZERO;
        List<List<Integer>> demaisCartas = cartasAgrupadas.values().stream().filter(lista -> lista.size() == 1).collect(Collectors.toList());
        for (List<Integer> carta : demaisCartas) {
            BigDecimal valorDaCarta = BigDecimal.valueOf(carta.stream().findFirst().get());
            fator = fator.add(valorDaCarta.multiply(BigDecimal.valueOf(0.001)));
        }
        return fator;
    }

    private int obterCartaDaDupla() {
        Map<Integer, List<Integer>> cartasAgrupadas = getMaoDoJogador().obterContagemDeCartasUnicasNaMao();
        return cartasAgrupadas.values().stream().filter(lista -> lista.size() == 2).findFirst().get().get(0);
    }
}
