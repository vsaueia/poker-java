package vsaueia.poker.jogadas;

import java.math.BigDecimal;

public class Ranking {
    public static final BigDecimal MAIOR_CARTA = BigDecimal.ZERO;
    public static final BigDecimal UM_PAR = BigDecimal.ONE;
    public static final BigDecimal DOIS_PARES = BigDecimal.valueOf(2);
    public static final BigDecimal TRINCA = BigDecimal.valueOf(3);
    public static final BigDecimal STRAIGHT = BigDecimal.valueOf(4);
    public static final BigDecimal FLUSH = BigDecimal.valueOf(5);
    public static final BigDecimal FULL_HOUSE = BigDecimal.valueOf(6);
    public static final BigDecimal QUADRA = BigDecimal.valueOf(7);
    public static final BigDecimal STRAIGHT_FLUSH = BigDecimal.valueOf(8);
    public static final BigDecimal ROYAL_STRAIGHT_FLUSH = BigDecimal.valueOf(9);
}
