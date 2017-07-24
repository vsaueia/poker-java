package vsaueia.poker.modelo;

import vsaueia.poker.avaliacao.AvaliadorDeJogadas;
import vsaueia.poker.jogadas.Jogada;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaoDoJogador {

    private final Carta[] cartas = new Carta[5];
    private final AvaliadorDeJogadas avaliadorDeJogadas;
    private List<Integer> valoresDasCartas = new ArrayList<>();
    private List<Naipe> naipesDasCartas = new ArrayList<>();
    private BigDecimal pesoDaJogada;

    public MaoDoJogador(String cartas) {
        lerCartas(cartas);
        separarValoresDasCartas();
        separarNaipesDasCartas();
        this.pesoDaJogada = BigDecimal.ZERO;
        this.avaliadorDeJogadas = new AvaliadorDeJogadas(this);
    }

    private void separarValoresDasCartas() {
        this.valoresDasCartas = Arrays.stream(cartas)
                .map(carta -> carta.getValor())
                .sorted()
                .collect(Collectors.toList());
    }

    private void separarNaipesDasCartas() {
        this.naipesDasCartas = Arrays.stream(cartas)
                .map(carta -> carta.getNaipe())
                .collect(Collectors.toList());
    }

    private Carta[] lerCartas(String cartas) {
        String[] cartasIndividuais = cartas.split(" ");
        for (int i = 0; i < cartasIndividuais.length; i++) {
            Carta carta = Carta.obterCarta(cartasIndividuais[i]);
            this.cartas[i] = carta;
        }
        return this.cartas;
    }

    public Carta[] getCartas() {
        return cartas;
    }

    public BigDecimal obterRanking() {
        Jogada jogada = avaliadorDeJogadas.obterRanking();
        System.out.println(jogada.toString());
        this.pesoDaJogada = jogada.calcularRanking();
        return this.pesoDaJogada;
    }

    public List<Naipe> obterNaipesDaMao() {
        return this.naipesDasCartas;
    }

    public List<Integer> obterValoresDasCartas() {
        return this.valoresDasCartas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaoDoJogador that = (MaoDoJogador) o;

        return Arrays.equals(cartas, that.cartas);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(cartas);
    }

    public Map<Integer, List<Integer>> obterContagemDeCartasUnicasNaMao() {
        Map<Integer, List<Integer>> cartasAgrupadas = this.obterValoresDasCartas().stream()
                .collect(Collectors.groupingBy(Integer::intValue));
        return cartasAgrupadas;
    }

    public int obterValorDaPrimeiraCarta() {
        return obterValoresDasCartas().stream().findFirst().get();
    }
}
