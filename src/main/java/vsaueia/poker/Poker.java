package vsaueia.poker;

import vsaueia.poker.avaliacao.Croupier;
import vsaueia.poker.modelo.MaoDoJogador;

import java.util.Scanner;

public class Poker {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite a mão do jogador 1:");
            String jogador1 = scanner.nextLine();
            System.out.println("Digite a mão do jogador 2:");
            String jogador2 = scanner.nextLine();
            MaoDoJogador mao1 = new MaoDoJogador(jogador1);
            MaoDoJogador mao2 = new MaoDoJogador(jogador2);
            String ganhador = Croupier.avaliarGanhador(mao1, mao2);
            System.out.println("O ganhador é o -> " + ganhador);
        }
    }
}
