package vsaueia.poker.avaliacao;

import vsaueia.poker.modelo.MaoDoJogador;
import org.junit.Assert;
import org.junit.Test;

public class CroupierTeste {
    @Test
    public void deveVerificarQuemEhOGanhadorPorCartaMaisAlta() {
        MaoDoJogador jogador1 = new MaoDoJogador("AE 8O 9P 2P 3C");
        MaoDoJogador jogador2 = new MaoDoJogador("10E 8C 9O 5P 6E");

        String ganhador = Croupier.avaliarGanhador(jogador1, jogador2);

        Assert.assertEquals("jogador 1", ganhador);
    }

    @Test
    public void deveVerificarQuemEhOGanhadorPelaSegundaCartaMaisAlta() {
        MaoDoJogador jogador1 = new MaoDoJogador("AE 8O 10P 2P 3C");
        MaoDoJogador jogador2 = new MaoDoJogador("AC 8C 9O 5P 6E");

        String ganhador = Croupier.avaliarGanhador(jogador1, jogador2);

        Assert.assertEquals("jogador 1", ganhador);
    }

    @Test
    public void umaDuplaDeveGanharDeCartaMaior() {
        MaoDoJogador jogador1 = new MaoDoJogador("AE 8O 10P 2P 3C");
        MaoDoJogador jogador2 = new MaoDoJogador("AC 8C 9O 5P 5E");

        String ganhador = Croupier.avaliarGanhador(jogador1, jogador2);

        Assert.assertEquals("jogador 2", ganhador);
    }

    @Test
    public void umaDuplaDeCincoPerdeParaUmaDuplaDeSete() {
        MaoDoJogador jogador1 = new MaoDoJogador("AE 8O 10P 7P 7C");
        MaoDoJogador jogador2 = new MaoDoJogador("AC 8C 9O 5P 5E");

        String ganhador = Croupier.avaliarGanhador(jogador1, jogador2);

        Assert.assertEquals("jogador 1", ganhador);
    }

    @Test
    public void deveDesempatarJogadaDeUmaDuplaComCartaMaior() {
        MaoDoJogador jogador1 = new MaoDoJogador("AE AO 6P 4P 3C");
        MaoDoJogador jogador2 = new MaoDoJogador("AC AP 5O 4C 3E");

        String ganhador = Croupier.avaliarGanhador(jogador1, jogador2);

        Assert.assertEquals("jogador 1", ganhador);
    }

    @Test
    public void duasDuplaDeveGanharDeUmPar() {
        MaoDoJogador jogador1 = new MaoDoJogador("AE AO 6P 6P 3C");
        MaoDoJogador jogador2 = new MaoDoJogador("AC AP 5O 4C 3E");

        String ganhador = Croupier.avaliarGanhador(jogador1, jogador2);

        Assert.assertEquals("jogador 1", ganhador);
    }

    @Test
    public void deveEmpatarDoisRoyalStraightFlush() {
        MaoDoJogador jogador1 = new MaoDoJogador("10O JO QO KO AO");
        MaoDoJogador jogador2 = new MaoDoJogador("10E JE QE KE AE");

        String ganhador = Croupier.avaliarGanhador(jogador1, jogador2);

        Assert.assertEquals("empate", ganhador);
    }

    @Test
    public void deveDesempatarStraighFlushPorCartasMaiores() {
        MaoDoJogador jogador1 = new MaoDoJogador("10O JO QO KO 9O");
        MaoDoJogador jogador2 = new MaoDoJogador("10E JE QE 8E 9E");

        String ganhador = Croupier.avaliarGanhador(jogador1, jogador2);

        Assert.assertEquals("jogador 1", ganhador);
    }

    @Test
    public void deveCompararTrincas() {
        MaoDoJogador jogador1 = new MaoDoJogador("10O 10C 10P KO 9O");
        MaoDoJogador jogador2 = new MaoDoJogador("10E JE QE 8E 3C");

        String ganhador = Croupier.avaliarGanhador(jogador1, jogador2);

        Assert.assertEquals("jogador 1", ganhador);
    }
}
