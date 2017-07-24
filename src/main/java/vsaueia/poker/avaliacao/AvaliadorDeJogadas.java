package vsaueia.poker.avaliacao;

import vsaueia.poker.jogadas.*;
import vsaueia.poker.modelo.MaoDoJogador;

import java.util.ArrayList;
import java.util.List;

public final class AvaliadorDeJogadas {

    private List<Jogada> jogadas = new ArrayList<>();

    public AvaliadorDeJogadas(MaoDoJogador maoDoJogador) {
        jogadas.add(new RoyalStraightFlush(maoDoJogador));
        jogadas.add(new StraightFlush(maoDoJogador));
        jogadas.add(new Quadra(maoDoJogador));
        jogadas.add(new FullHouse(maoDoJogador));
        jogadas.add(new Flush(maoDoJogador));
        jogadas.add(new Straight(maoDoJogador));
        jogadas.add(new Trinca(maoDoJogador));
        jogadas.add(new DoisPares(maoDoJogador));
        jogadas.add(new UmPar(maoDoJogador));
        jogadas.add(new CartaMaior(maoDoJogador));
    }

    public Jogada obterRanking() {
        for (Jogada jogada : jogadas) {
            if (jogada.maoCasaComJogada()) {
                return jogada;
            }
        }
        return null;
    }

}
