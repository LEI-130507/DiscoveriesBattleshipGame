package iscteiul.ista.battleship;

import java.util.List;

/**
 * Representa o motor ou estado de uma partida no jogo da Batalha Naval.
 * Define os métodos necessários para interagir com o jogo, como disparar, 
 * consultar estatísticas de tiros e verificar o estado da frota adversária.
 */
public interface IGame {

    /**
     * Executa um disparo sobre uma determinada posição no tabuleiro.
     *
     * @param pos A posição (coordenadas) onde o tiro será disparado.
     * @return O navio atingido se o tiro for certeiro, ou null se for um tiro na água.
     */
    IShip fire(IPosition pos);

    /**
     * Obtém o histórico de todas as posições onde já foram efetuados disparos.
     *
     * @return Uma lista com as coordenadas de todos os tiros já realizados.
     */
    List getShots();

    /**
     * Devolve o número de tiros repetidos (tiros disparados em posições que já tinham sido atacadas).
     *
     * @return A quantidade de tiros repetidos.
     */
    int getRepeatedShots();

    /**
     * Devolve o número de tiros inválidos (por exemplo, disparos fora dos limites da grelha).
     *
     * @return A quantidade de tiros inválidos.
     */
    int getInvalidShots();

    /**
     * Devolve o número total de tiros certeiros (que atingiram algum navio).
     *
     * @return A quantidade de tiros que acertaram no alvo.
     */
    int getHits();

    /**
     * Devolve o número de navios adversários que já foram totalmente afundados.
     *
     * @return A quantidade de navios afundados.
     */
    int getSunkShips();

    /**
     * Devolve o número de navios adversários que ainda continuam a flutuar no jogo.
     *
     * @return A quantidade de navios restantes.
     */
    int getRemainingShips();

    /**
     * Imprime na consola o registo dos tiros válidos efetuados até ao momento.
     */
    void printValidShots();

    /**
     * Imprime na consola o estado atual da frota.
     */
    void printFleet();
}
