package iscteiul.ista.battleship;

/**
 * Representa um navio do tipo Barca (Barge) no jogo Discoveries Battleship.
 * Corresponde a menor embarcacao da frota da epoca dos Descobrimentos, ocupando
 * uma unica posicao (dimensao 1) na grelha do tabuleiro.
 *
 * @author João Valério
 * @version 1.0
 * @see Ship
 * @see IPosition
 * @see Compass
 */
public class Barge extends Ship {

    /**
     * Dimensao fixa da Barca na grelha (1 celula).
     */
    private static final Integer SIZE = 1;

    /**
     * Nome identificador do tipo de embarcacao ("Barca").
     */
    private static final String NAME = "Barca";

    /**
     * Constroi uma nova instancia de Barca com a orientacao e posicao de referencia indicadas.
     * Inicializa a lista de posicoes ocupadas pelo navio na grelha.
     *
     * @param bearing A orientacao/rumo do navio na grelha (bussola).
     * @param pos     A coordenada inicial (canto superior esquerdo) da barca no tabuleiro.
     */
    public Barge(Compass bearing, IPosition pos) {
        super(Barge.NAME, bearing, pos);
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
    }

    /**
     * Obtem o tamanho (numero de posicoes ocupadas) da Barca.
     *
     * @return O valor inteiro correspondente ao tamanho fixo da embarcacao (1).
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}
