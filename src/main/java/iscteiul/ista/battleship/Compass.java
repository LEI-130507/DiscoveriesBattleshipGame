package iscteiul.ista.battleship;

/**
 * Representa os pontos cardeais e a orientacao dos navios na grelha de jogo.
 * Mapeia cada rumo geografico para o respetivo caractere identificador.
 *
 * @author João Valério
 * @version 1.0
 */
public enum Compass {

    /**
     * Orientacao Norte, representada pelo caractere 'n'.
     */
    NORTH('n'),

    /**
     * Orientacao Sul, representada pelo caractere 's'.
     */
    SOUTH('s'),

    /**
     * Orientacao Este, representada pelo caractere 'e'.
     */
    EAST('e'),

    /**
     * Orientacao Oeste, representada pelo caractere 'o'.
     */
    WEST('o'),

    /**
     * Orientacao desconhecida ou invalida, representada pelo caractere 'u'.
     */
    UNKNOWN('u');

    /**
     * Caractere que identifica a orientacao.
     */
    private final char c;

    /**
     * Construtor da enumeracao Compass.
     *
     * @param c Caractere correspondente a direcao.
     */
    Compass(char c) {
        this.c = c;
    }

    /**
     * Obtem o caractere que identifica a orientacao.
     *
     * @return O caractere correspondente ('n', 's', 'e', 'o' ou 'u').
     */
    public char getDirection() {
        return c;
    }

    /**
     * Retorna a representacao em texto da orientacao.
     *
     * @return Uma string contendo apenas o caractere da direcao.
     */
    @Override
    public String toString() {
        return "" + c;
    }

    /**
     * Converte um caractere na respetiva constante de enumeracao Compass.
     *
     * @param ch Caractere a converter ('n', 's', 'e', 'o').
     * @return A constante Compass correspondente ou {@link #UNKNOWN} se o caractere nao for reconhecido.
     */
    static Compass charToCompass(char ch) {
        Compass bearing;
        switch (ch) {
            case 'n':
                bearing = NORTH;
                break;
            case 's':
                bearing = SOUTH;
                break;
            case 'e':
                bearing = EAST;
                break;
            case 'o':
                bearing = WEST;
                break;
            default:
                bearing = UNKNOWN;
        }

        return bearing;
    }
}
