package iscteiul.ista.battleship;

import java.util.List;

/**
 * Representa um navio no jogo da Batalha Naval.
 * Define as propriedades da embarcação (como tamanho, categoria e orientação) 
 * e os seus comportamentos no tabuleiro (ocupação de espaço e resposta a ataques).
 */
public interface IShip {

    /**
     * Obtém a categoria ou tipo do navio (por exemplo, "Galeão", "Caravela", etc.).
     *
     * @return Uma string representando a categoria do navio.
     */
    String getCategory();

    /**
     * Obtém o tamanho do navio.
     *
     * @return O número de células/quadrados que o navio ocupa no tabuleiro.
     */
    Integer getSize();

    /**
     * Obtém a lista de todas as posições que o navio ocupa atualmente na grelha.
     *
     * @return Uma lista contendo as posições ocupadas pelo navio.
     */
    List getPositions();

    /**
     * Obtém a posição de referência (geralmente a posição inicial ou âncora) do navio.
     *
     * @return A posição principal do navio.
     */
    IPosition getPosition();

    /**
     * Obtém a orientação do navio no tabuleiro (por exemplo, Norte, Sul, Este, Oeste).
     *
     * @return A direção para a qual o navio está orientado, utilizando o tipo Compass.
     */
    Compass getBearing();

    /**
     * Verifica se o navio ainda está a flutuar (ou seja, se nem todas as suas posições foram atingidas).
     *
     * @return true se o navio ainda tiver partes intactas, false se estiver totalmente afundado.
     */
    boolean stillFloating();

    /**
     * Obtém o índice da linha mais acima ocupada pelo navio (menor valor de linha).
     *
     * @return O valor da linha de topo.
     */
    int getTopMostPos();

    /**
     * Obtém o índice da linha mais abaixo ocupada pelo navio (maior valor de linha).
     *
     * @return O valor da linha de fundo.
     */
    int getBottomMostPos();

    /**
     * Obtém o índice da coluna mais à esquerda ocupada pelo navio (menor valor de coluna).
     *
     * @return O valor da coluna mais à esquerda.
     */
    int getLeftMostPos();

    /**
     * Obtém o índice da coluna mais à direita ocupada pelo navio (maior valor de coluna).
     *
     * @return O valor da coluna mais à direita.
     */
    int getRightMostPos();

    /**
     * Verifica se o navio ocupa uma determinada posição no tabuleiro.
     *
     * @param pos A posição a verificar.
     * @return true se o navio ocupar a posição indicada, false caso contrário.
     */
    boolean occupies(IPosition pos);

    /**
     * Verifica se este navio está demasiado perto de outro navio,
     * de acordo com as regras de distanciamento do jogo (ex: sobreposição).
     *
     * @param other O outro navio a ser verificado.
     * @return true se os navios estiverem demasiado próximos, false se a distância for válida.
     */
    boolean tooCloseTo(IShip other);

    /**
     * Verifica se este navio está demasiado perto de uma posição específica no tabuleiro.
     *
     * @param pos A posição a ser verificada em relação ao navio.
     * @return true se a posição estiver demasiado próxima das coordenadas do navio, false caso contrário.
     */
    boolean tooCloseTo(IPosition pos);

    /**
     * Regista um tiro que atingiu o navio numa posição específica.
     *
     * @param pos A coordenada da parte do navio que sofreu o impacto.
     */
    void shoot(IPosition pos);
}
