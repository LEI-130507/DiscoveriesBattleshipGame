package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a frota de navios de um jogador no jogo Battleship.
 * Gere a lista de navios adicionados, validando as condicoes de integridade,
 * como a permanencia dentro do tabuleiro e a distancia minima entre embarcacoes.
 *
 * @author João Valério
 * @version 1.0
 * @see IFleet
 * @see IShip
 * @see IPosition
 */
public class Fleet implements IFleet {

    /**
     * Imprime no terminal a informacao textual de todos os navios contidos na lista especificada.
     *
     * @param ships Lista de navios a imprimir.
     */
    static void printShips(List<IShip> ships) {
        for (IShip ship : ships)
            System.out.println(ship);
    }

    // -----------------------------------------------------

    /**
     * Lista contendo os navios pertencentes a frota.
     */
    private List<IShip> ships;

    /**
     * Constroi uma nova frota inicialmente vazia.
     */
    public Fleet() {
        ships = new ArrayList<>();
    }

    /**
     * Retorna a lista de navios pertencentes a esta frota.
     *
     * @return Lista com as embarcacoes da frota.
     */
    @Override
    public List<IShip> getShips() {
        return ships;
    }

    /**
     * Adiciona um novo navio a frota se a capacidade maxima nao for excedida,
     * se a embarcacao estiver totalmente dentro do tabuleiro e sem risco de colisao.
     *
     * @param s O navio a ser adicionado a frota.
     * @return {@code true} se o navio cumprir os criterios e for adicionado com sucesso; {@code false} caso contrario.
     */
    @Override
    public boolean addShip(IShip s) {
        boolean result = false;
        if ((ships.size() <= FLEET_SIZE) && (isInsideBoard(s)) && (!colisionRisk(s))) {
            ships.add(s);
            result = true;
        }
        return result;
    }

    /**
     * Obtem todas as embarcacoes da frota que pertencem a uma categoria especifica.
     *
     * @param category Nome da categoria de navios pretendida (ex: "Galeao", "Fragata").
     * @return Lista de navios da frota correspondentes a categoria fornecida.
     */
    @Override
    public List<IShip> getShipsLike(String category) {
        List<IShip> shipsLike = new ArrayList<>();
        for (IShip s : ships)
            if (s.getCategory().equals(category))
                shipsLike.add(s);

        return shipsLike;
    }

    /**
     * Retorna todas as embarcacoes da frota que continuam a flutuar (nao afundadas).
     *
     * @return Lista contendo os navios ainda a flutuar.
     */
    @Override
    public List<IShip> getFloatingShips() {
        List<IShip> floatingShips = new ArrayList<>();
        for (IShip s : ships)
            if (s.stillFloating())
                floatingShips.add(s);

        return floatingShips;
    }

    /**
     * Identifica o navio da frota que ocupa a posicao indicada no tabuleiro.
     *
     * @param pos Coordenada no tabuleiro a verificar.
     * @return A instancia de {@code IShip} que ocupa a posicao, ou {@code null} caso nao haja nenhum navio nessa celula.
     */
    @Override
    public IShip shipAt(IPosition pos) {
        for (int i = 0; i < ships.size(); i++)
            if (ships.get(i).occupies(pos))
                return ships.get(i);
        return null;
    }

    /**
     * Verifica se todas as posicoes de um determinado navio se encontram dentro dos limites da grelha.
     *
     * @param s Navio a verificar.
     * @return {@code true} se o navio estiver totalmente dentro dos limites da grelha; {@code false} caso exceda os limites.
     */
    private boolean isInsideBoard(IShip s) {
        return (s.getLeftMostPos() >= 0 && s.getRightMostPos() <= BOARD_SIZE - 1 && s.getTopMostPos() >= 0
                && s.getBottomMostPos() <= BOARD_SIZE - 1);
    }

    /**
     * Avalia se um determinado navio esta demasiado perto ou sobreposto a qualquer navio ja existente na frota.
     *
     * @param s Navio a verificar.
     * @return {@code true} se existir risco de colisao ou contacto indevido; {@code false} se o espacamento for valido.
     */
    private boolean colisionRisk(IShip s) {
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).tooCloseTo(s))
                return true;
        }
        return false;
    }

    /**
     * Apresenta no terminal o estado geral da frota, imprimindo todos os navios,
     * os navios que ainda flutuam e os navios divididos por categoria.
     */
    public void printStatus() {
        printAllShips();
        printFloatingShips();
        printShipsByCategory("Galeao");
        printShipsByCategory("Fragata");
        printShipsByCategory("Nau");
        printShipsByCategory("Caravela");
        printShipsByCategory("Barca");
    }

    /**
     * Imprime todos os navios da frota pertencentes a uma determinada categoria.
     *
     * @param category Nome da categoria de interesse. Nao deve ser nulo.
     */
    public void printShipsByCategory(String category) {
        assert category != null;

        printShips(getShipsLike(category));
    }

    /**
     * Imprime no terminal todos os navios da frota que ainda nao foram totalmente afundados.
     */
    public void printFloatingShips() {
        printShips(getFloatingShips());
    }

    /**
     * Imprime no terminal todas as embarcacoes que constituem a frota.
     */
    void printAllShips() {
        printShips(ships);
    }

}
