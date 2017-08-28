package solucao;

import java.util.ArrayList;
import java.util.List;

public class TradutorDeCartas {

    public static List<Carta> lerCartas(String param) {
        String[] c = param.split(" ");
        List<Carta> cartas = new ArrayList<>();
        for(int i = 0; i < c.length; i++) {
            cartas.add(new Carta(c[i]));
        }
        return cartas;
    }
}
