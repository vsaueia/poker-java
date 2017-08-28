package solucao;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TradutorDeCartasTeste {
    @Test
    public void deveCriarAsCartas() {
        String cartas = "5C 2P 6E 10E KO";

        List<Carta> saida = TradutorDeCartas.lerCartas(cartas);

        Assert.assertEquals(saida.get(0), "5");
    }

}
