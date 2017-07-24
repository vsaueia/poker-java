package vsaueia.poker.jogadas;

import vsaueia.poker.modelo.MaoDoJogador;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class DoisPares extends Jogada {
    public DoisPares(MaoDoJogador maoDoJogador) {
        super(maoDoJogador);
    }

    @Override
    public boolean maoCasaComJogada() {
        // TODO: codigo repetido
        Map<Integer, List<Integer>> cartasAgrupadas = getMaoDoJogador().obterContagemDeCartasUnicasNaMao();
        boolean temDoisPares = cartasAgrupadas.values().stream().filter(lista -> lista.size() == 2).count() == 2;
        return temDoisPares;
    }

    @Override
    public BigDecimal calcularRanking() {
        return Ranking.DOIS_PARES.add(super.obterFator());
    }

    @Override
    protected String obterDescricao() {
        return "Dois pares";
    }
}
