package vsaueia.poker.modelo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Carta {
    private final int valor;
    private Naipe naipe;

    private static Map<String, Integer> simbolosEspeciais;

    static {
        simbolosEspeciais = new HashMap<>();
        simbolosEspeciais.put("J", 11);
        simbolosEspeciais.put("Q", 12);
        simbolosEspeciais.put("K", 13);
        simbolosEspeciais.put("A", 14);
    }

    public Carta(int valor, Naipe naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    public static Carta obterCarta(String representacaoDaCarta) {
        Naipe naipe = Arrays.stream(Naipe.values())
                .filter(n -> n.getSimbolo() == (representacaoDaCarta.charAt(representacaoDaCarta.length()-1)))
                .findFirst().get();
        int valor = obterValorNumericoDaCarta(representacaoDaCarta.substring(0, representacaoDaCarta.length()-1));
        return new Carta(valor, naipe);
    }

    private static int obterValorNumericoDaCarta(String valor) {
        if (simbolosEspeciais.containsKey(valor)) {
            return simbolosEspeciais.get(valor);
        }
        return Integer.valueOf(valor+"");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Carta carta = (Carta) o;

        if (valor != carta.valor) return false;
        return naipe == carta.naipe;
    }

    @Override
    public int hashCode() {
        int result = valor;
        result = 31 * result + naipe.hashCode();
        return result;
    }

    public int getValor() {
        return valor;
    }

    public Naipe getNaipe() {
        return naipe;
    }
}
