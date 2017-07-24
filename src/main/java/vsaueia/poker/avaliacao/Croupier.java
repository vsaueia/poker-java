package vsaueia.poker.avaliacao;

import vsaueia.poker.modelo.MaoDoJogador;

import java.math.BigDecimal;

public class Croupier {

    public static String avaliarGanhador(MaoDoJogador jogador1, MaoDoJogador jogador2) {
        BigDecimal rankingDoJogador1 = jogador1.obterRanking();
        BigDecimal rankingDoJogador2 = jogador2.obterRanking();
        int comparacaoDosRankings = rankingDoJogador1.compareTo(rankingDoJogador2);
        if (comparacaoDosRankings == 0) {
            return "empate";
        }
        if (comparacaoDosRankings > 0) {
            return "jogador 1";
        }
        return "jogador 2";
    }
}
