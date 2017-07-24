package vsaueia.poker.modelo;

public enum Naipe {
    Paus('P'),
    Copas('C'),
    Espadas('E'),
    Ouro('O');

    private final char simbolo;

    Naipe(char simbolo) {
        this.simbolo = simbolo;
    }

    public char getSimbolo() {
        return simbolo;
    }
}
