package vsaueia.poker.jogadas;

import vsaueia.poker.modelo.MaoDoJogador;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Quadra extends Jogada {

    public Quadra(MaoDoJogador maoDoJogador) {
        super(maoDoJogador);
    }

    @Override
    public boolean maoCasaComJogada() {
        Map<Integer, List<Integer>> cartasAgrupadas = getMaoDoJogador().obterContagemDeCartasUnicasNaMao();
        boolean temQuadra = cartasAgrupadas.values().stream().anyMatch(lista -> lista.size() == 4);
        return temQuadra;
    }

    @Override
    public BigDecimal calcularRanking() {
        return Ranking.QUADRA.add(super.obterFator());
    }

    @Override
    protected String obterDescricao() {
        return "Quadra";
    }
}
