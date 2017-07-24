package vsaueia.poker.modelo;

import vsaueia.poker.jogadas.Ranking;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class MaoDoJogadorTeste {
    @Test
    public void deve_criar_a_mao_do_jogador() {
        String cartas = "5C 5P 6E 10E KO";

        MaoDoJogador maoDoJogador = new MaoDoJogador(cartas);

        assertEquals(maoDoJogador.getCartas()[0], new Carta(5, Naipe.Copas));
    }

    @Test
    public void deveCalcularRankingDeMaior() {

        MaoDoJogador maoDoJogador = new MaoDoJogador("AE 2O 3P 5C 4O");

        BigDecimal ranking = maoDoJogador.obterRanking();

        Assert.assertTrue(ranking.compareTo(Ranking.MAIOR_CARTA) > 0);
    }

    @Test
    public void deveCalcularRankingDeUmPar() {

        MaoDoJogador maoDoJogador = new MaoDoJogador("AE 2O 3P 5C 5O");

        BigDecimal ranking = maoDoJogador.obterRanking();

        Assert.assertTrue(ranking.compareTo(BigDecimal.ONE) > 0);
    }

    @Test
    public void deveCalcularRankingDeDoisPares() {

        MaoDoJogador maoDoJogador = new MaoDoJogador("AE 3O 3P 5C 5O");

        BigDecimal ranking = maoDoJogador.obterRanking();

        Assert.assertTrue(ranking.compareTo(Ranking.DOIS_PARES) > 0);
    }

    @Test
    public void deveCalcularRankingDeUmaTrinca() {
        MaoDoJogador maoDoJogador = new MaoDoJogador("3E 3O AP 10C 3O");

        BigDecimal ranking = maoDoJogador.obterRanking();

        Assert.assertTrue(ranking.compareTo(Ranking.TRINCA) > 0);
    }

    @Test
    public void deveCalcularRankingDeUmaSequencia() {
        MaoDoJogador maoDoJogador = new MaoDoJogador("10E JO 9P KC QO");

        BigDecimal ranking = maoDoJogador.obterRanking();

        Assert.assertTrue(ranking.compareTo(Ranking.STRAIGHT) > 0);
    }

    @Test
    public void deveCalcularRankingDeUmFlush() {
        MaoDoJogador maoDoJogador = new MaoDoJogador("10O JO 9O KO QO");

        BigDecimal ranking = maoDoJogador.obterRanking();

        Assert.assertTrue(ranking.compareTo(Ranking.FLUSH) > 0);
    }

    @Test
    public void deveCalcularRankingDeUmFullhouse() {
        MaoDoJogador maoDoJogador = new MaoDoJogador("10O 10E 10P KO KC");

        BigDecimal ranking = maoDoJogador.obterRanking();

        Assert.assertTrue(ranking.compareTo(Ranking.FULL_HOUSE) > 0);
    }

    @Test
    public void deveCalcularRankingDeUmaQuadra() {
        MaoDoJogador maoDoJogador = new MaoDoJogador("10O 10E 10P 10P KC");

        BigDecimal ranking = maoDoJogador.obterRanking();

        Assert.assertTrue(ranking.compareTo(Ranking.QUADRA) > 0);
    }

    @Test
    public void deveCalcularRankingDeUmStraightFlush() {
        MaoDoJogador maoDoJogador = new MaoDoJogador("7O 9O 8O JO 10O");

        BigDecimal ranking = maoDoJogador.obterRanking();

        Assert.assertTrue(ranking.compareTo(Ranking.STRAIGHT_FLUSH) > 0);
    }

    @Test
    public void deveCalcularRankingDeUmRoyalStraightFlush() {
        MaoDoJogador maoDoJogador = new MaoDoJogador("AO KO QO JO 10O");

        BigDecimal ranking = maoDoJogador.obterRanking();

        Assert.assertTrue(ranking.compareTo(Ranking.ROYAL_STRAIGHT_FLUSH) >= 0);
    }
}
