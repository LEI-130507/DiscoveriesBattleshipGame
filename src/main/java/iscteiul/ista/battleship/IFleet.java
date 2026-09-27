package iscteiul.ista.battleship;

import java.util.List;

/**
 * Representa uma frota de navios no jogo da Batalha Naval.
 * Define os comportamentos e regras gerais associados à gestão dos navios de um jogador.
 */
public interface IFleet {
    
    /**
     * O tamanho padrão da grelha do tabuleiro (ex: 10x10).
     */
    Integer BOARD_SIZE = 10;
    
    /**
     * O número total de navios que compõem uma frota completa.
     */
    Integer FLEET_SIZE = 10;

    /**
     * Obtém a lista de todos os navios que pertencem atualmente à frota.
     *
     * @return Uma lista contendo os navios da frota.
     */
    List getShips();

    /**
     * Adiciona um novo navio à frota.
     *
     * @param s O navio a ser adicionado.
     * @return true se o navio foi adicionado com sucesso, false caso contrário 
     *         (ex: sobreposição com outro navio ou limite da frota excedido).
     */
    boolean addShip(IShip s);

    /**
     * Obtém uma lista de navios que pertencem a uma categoria específica 
     * (ex: "Galeão", "Caravela").
     *
     * @param category A categoria de navios a pesquisar.
     * @return Uma lista contendo os navios da categoria especificada.
     */
    List getShipsLike(String category);

    /**
     * Obtém todos os navios da frota que ainda estão a flutuar (ou seja, que não foram afundados).
     *
     * @return Uma lista de navios que ainda não foram totalmente destruídos.
     */
    List getFloatingShips();

    /**
     * Devolve o navio que se encontra numa posição específica do tabuleiro.
     *
     * @param pos A posição (coordenadas) a verificar.
     * @return O navio que ocupa a posição indicada, ou null se não houver nenhum navio nessa posição.
     */
    IShip shipAt(IPosition pos);

    /**
     * Imprime na consola o estado atual da frota (navios posicionados, navios afundados, etc.).
     */
    void printStatus();
}
