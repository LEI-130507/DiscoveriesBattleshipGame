package iscteiul.ista.battleship;

/**
 * Representa um navio do tipo Galeao (Galleon) no jogo Discoveries Battleship[cite: 1].
 * E a maior embarcacao da frota, ocupando 5 posicoes na grelha num formato especifico em T/cruz[cite: 1].
 *
 * @author João Valério
 * @version 1.0
 * @see Ship
 * @see IPosition
 * @see Compass
 */
public class Galleon extends Ship {

    /**
     * Dimensao fixa do Galeao na grelha (5 celulas)[cite: 1].
     */
    private static final Integer SIZE = 5;

    /**
     * Nome identificador da embarcacao ("Galeao").
     */
    private static final String NAME = "Galeao";

    /**
     * Constroi um novo Galeao com a orientacao e a posicao inicial de referencia indicadas.
     * Preenche as posicoes ocupadas pelo navio dependendo da direcao escolhida.
     *
     * @param bearing Orientacao geografica da embarcacao (NORTH, SOUTH, EAST ou WEST).
     * @param pos     Posicao de referencia na grelha para iniciar o posicionamento.
     * @throws NullPointerException     Se a orientacao fornecida for nula.
     * @throws IllegalArgumentException Se a orientacao for invalida para o navio.
     */
    public Galleon(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Galleon.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the galleon");

        switch (bearing) {
            case NORTH:
                fillNorth(pos);
                break;
            case EAST:
                fillEast(pos);
                break;
            case SOUTH:
                fillSouth(pos);
                break;
            case WEST:
                fillWest(pos);
                break;

            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the galleon");
        }
    }

    /**
     * Retorna a dimensao (numero total de posicoes ocupadas) do Galeao[cite: 1].
     *
     * @return O tamanho fixo do navio (5)[cite: 1].
     */
    @Override
    public Integer getSize() {
        return Galleon.SIZE;
    }

    /**
     * Calcula e adiciona as posicoes ocupadas pelo Galeao quando orientado a Norte.
     *
     * @param pos Posicao base de referencia na grelha.
     */
    private void fillNorth(IPosition pos) {
        for (int i = 0; i < 3; i++) {
            getPositions().add(new Position(pos.getRow(), pos.getColumn() + i));
        }
        getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + 1));
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + 1));
    }

    /**
     * Calcula e adiciona as posicoes ocupadas pelo Galeao quando orientado a Sul.
     *
     * @param pos Posicao base de referencia na grelha.
     */
    private void fillSouth(IPosition pos) {
        for (int i = 0; i < 2; i++) {
            getPositions().add(new Position(pos.getRow() + i, pos.getColumn()));
        }
        for (int j = 2; j < 5; j++) {
            getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + j - 3));
        }
    }

    /**
     * Calcula e adiciona as posicoes ocupadas pelo Galeao quando orientado a Este.
     *
     * @param pos Posicao base de referencia na grelha.
     */
    private void fillEast(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 3));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

    /**
     * Calcula e adiciona as posicoes ocupadas pelo Galeao quando orientado a Oeste.
     *
     * @param pos Posicao base de referencia na grelha.
     */
    private void fillWest(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 1));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

}
