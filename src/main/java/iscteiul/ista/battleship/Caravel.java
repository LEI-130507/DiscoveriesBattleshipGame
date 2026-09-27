package iscteiul.ista.battleship;

/**
 * Representa um navio do tipo Caravela (Caravel) no jogo Discoveries Battleship.
 * Embarcacao rapida da epoca dos Descobrimentos que ocupa duas posicoes contiguas (dimensao 2) na grelha.
 *
 * @author João Valério
 * @version 1.0
 * @see Ship
 * @see IPosition
 * @see Compass
 */
public class Caravel extends Ship {

    /**
     * Dimensao fixa da Caravela na grelha (2 celulas).
     */
    private static final Integer SIZE = 2;

    /**
     * Nome identificador da embarcacao ("Caravela").
     */
    private static final String NAME = "Caravela";

    /**
     * Constroi uma nova instancia de Caravela com a orientacao e posicao inicial especificadas.
     * Calcula e preenche as coordenadas ocupadas pelo navio consoante o rumo indicado.
     *
     * @param bearing A orientacao geografica do navio (NORTH, SOUTH, EAST ou WEST).
     * @param pos     A coordenada inicial de referencia para o posicionamento da caravela.
     * @throws NullPointerException     Se o parametro {@code bearing} for nulo.
     * @throws IllegalArgumentException Se a orientacao fornecida for invalida para a embarcacao.
     */
    public Caravel(Compass bearing, IPosition pos) throws NullPointerException, IllegalArgumentException {
        super(Caravel.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the caravel");

        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                break;
            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(new Position(pos.getRow(), pos.getColumn() + c));
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the caravel");
        }

    }

    /**
     * Obtem a dimensao (numero de posicoes ocupadas) da Caravela.
     *
     * @return O valor inteiro correspondente ao tamanho fixo da caravela (2).
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}
