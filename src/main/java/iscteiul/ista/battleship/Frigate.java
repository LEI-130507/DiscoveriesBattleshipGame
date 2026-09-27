package iscteiul.ista.battleship;

/**
 * Representa um navio do tipo Fragata (Frigate) no jogo Discoveries Battleship.
 * Embarcacao de combate que ocupa 4 posicoes contiguas na grelha do tabuleiro.
 *
 * @author João Valério
 * @version 1.0
 * @see Ship
 * @see IPosition
 * @see Compass
 */
public class Frigate extends Ship {

    /**
     * Dimensao fixa da Fragata na grelha (4 celulas).
     */
    private static final Integer SIZE = 4;

    /**
     * Nome identificador da embarcacao ("Fragata").
     */
    private static final String NAME = "Fragata";

    /**
     * Constroi uma nova instancia de Fragata com a orientacao e posicao inicial especificadas.
     * Calcula e armazena as coordenadas ocupadas pela embarcacao com base no rumo indicado.
     *
     * @param bearing A orientacao geografica do navio (NORTH, SOUTH, EAST ou WEST).
     * @param pos     A coordenada inicial de referencia para o posicionamento da fragata.
     * @throws IllegalArgumentException Se a orientacao fornecida for invalida para a embarcacao.
     */
    public Frigate(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Frigate.NAME, bearing, pos);
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
                throw new IllegalArgumentException("ERROR! invalid bearing for thr frigate");
        }
    }

    /**
     * Obtem a dimensao (numero de posicoes ocupadas) da Fragata.
     *
     * @return O valor inteiro correspondente ao tamanho fixo da fragata (4).
     */
    @Override
    public Integer getSize() {
        return Frigate.SIZE;
    }

}
