package vsaueia.poker.jogadas;

import vsaueia.poker.modelo.MaoDoJogador;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Trinca extends Jogada {

    public Trinca(MaoDoJogador maoDoJogador) {
        super(maoDoJogador);
    }

    @Override
    public boolean maoCasaComJogada() {
        Map<Integer, List<Integer>> cartasAgrupadas = getMaoDoJogador().obterContagemDeCartasUnicasNaMao();
        boolean temTrinca = cartasAgrupadas.values().stream().anyMatch(lista -> lista.size() == 3);
        return temTrinca;
    }

    @Override
    public BigDecimal calcularRanking() {
        return Ranking.TRINCA.add(super.obterFator());
    }

    @Override
    protected String obterDescricao() {
        return "Trinca";
    }
}
