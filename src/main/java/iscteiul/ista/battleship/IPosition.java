package iscteiul.ista.battleship;

/**
 * Representa uma posição bidimensional (coordenada) no tabuleiro da Batalha Naval.
 * Gere o estado de uma célula da grelha, indicando a sua localização e se foi ocupada ou atingida.
 * 
 * @author fba
 */
public interface IPosition {

    /**
     * Obtém o índice da linha desta posição.
     *
     * @return O valor correspondente à linha.
     */
    int getRow();

    /**
     * Obtém o índice da coluna desta posição.
     *
     * @return O valor correspondente à coluna.
     */
    int getColumn();

    /**
     * Compara esta posição com outro objeto para verificar se são iguais.
     * Duas posições são consideradas iguais se tiverem a mesma linha e a mesma coluna.
     *
     * @param other O objeto a ser comparado com esta posição.
     * @return true se os objetos representarem a mesma posição, false caso contrário.
     */
    boolean equals(Object other);

    /**
     * Verifica se esta posição é adjacente (vizinha) a outra posição especificada.
     * A adjacência pode ser horizontal, vertical ou diagonal (dependendo da implementação).
     *
     * @param other A outra posição a ser verificada.
     * @return true se as posições forem adjacentes, false caso contrário.
     */
    boolean isAdjacentTo(IPosition other);

    /**
     * Marca esta posição como estando ocupada por um navio.
     */
    void occupy();

    /**
     * Regista um disparo efetuado nesta posição específica.
     */
    void shoot();

    /**
     * Verifica se existe algum navio a ocupar esta posição.
     *
     * @return true se a posição estiver ocupada, false caso esteja vazia.
     */
    boolean isOccupied();

    /**
     * Verifica se esta posição já foi alvo de um disparo.
     *
     * @return true se a posição já tiver sido atingida por um tiro, false caso contrário.
     */
    boolean isHit();
}
