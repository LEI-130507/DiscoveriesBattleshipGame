package iscteiul.ista.battleship;

/**
 * Representa um navio do tipo Nau (Carrack) no jogo Discoveries Battleship.
 * Embarcacao de grande porte da epoca dos Descobrimentos que ocupa 3 posicoes contiguas na grelha.
 *
 * @author João Valério
 * @version 1.0
 * @see Ship
 * @see IPosition
 * @see Compass
 */
public class Carrack extends Ship {

    /**
     * Dimensao fixa da Nau na grelha (3 celulas).
     */
    private static final Integer SIZE = 3;

    /**
     * Nome identificador da embarcacao ("Nau").
     */
    private static final String NAME = "Nau";

    /**
     * Constroi uma nova instancia de Nau com a orientacao e posicao inicial especificadas.
     * Calcula e armazena as coordenadas ocupadas pela embarcacao de acordo com o rumo indicado.
     *
     * @param bearing A orientacao geografica do navio (NORTH, SOUTH, EAST ou WEST).
     * @param pos     A coordenada inicial de referencia para o posicionamento da nau.
     * @throws IllegalArgumentException Se a orientacao fornecida for invalida para a embarcacao.
     */
    public Carrack(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Carrack.NAME, bearing, pos);
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
                throw new IllegalArgumentException("ERROR! invalid bearing for the carrack");
        }
    }

    /**
     * Obtem a dimensao (numero de posicoes ocupadas) da Nau.
     *
     * @return O valor inteiro correspondente ao tamanho fixo da nau (3).
     */
    @Override
    public Integer getSize() {
        return Carrack.SIZE;
    }

}
