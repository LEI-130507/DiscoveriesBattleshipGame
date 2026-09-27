package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Controla a logica operacional de uma partida do jogo Battleship.
 * Gere a frota de navios, o registo de disparos efetuados e a contagem de estatisticas
 * associadas a tiros validos, invalidos, repetidos, acertos e navios afundados.
 *
 * @author João Valério
 * @version 1.0
 * @see IGame
 * @see IFleet
 * @see IShip
 * @see IPosition
 */
public class Game implements IGame {

    /**
     * A frota associada ao jogo.
     */
    private IFleet fleet;

    /**
     * Lista de posicoes onde foram efetuados disparos validos e nao repetidos.
     */
    private List<IPosition> shots;

    /**
     * Contador de tiros efetuados fora dos limites do tabuleiro.
     */
    private Integer countInvalidShots;

    /**
     * Contador de tiros disparados contra coordenadas previamente atingidas.
     */
    private Integer countRepeatedShots;

    /**
     * Contador de tiros bem-sucedidos que atingiram posicoes ocupadas por navios.
     */
    private Integer countHits;

    /**
     * Contador de navios que foram totalmente afundados.
     */
    private Integer countSinks;

    /**
     * Constroi uma nova partida de jogo associando a respetiva frota.
     * Inicializa a lista de tiros e zera os contadores estatisticos.
     *
     * @param fleet A frota de navios a ser utilizada na partida.
     */
    public Game(IFleet fleet) {
        shots = new ArrayList<>();
        countInvalidShots = 0;
        countRepeatedShots = 0;
        countHits = 0;
        countSinks = 0;
        this.fleet = fleet;
    }

    /**
     * Executa um disparo sobre a coordenada indicada no tabuleiro.
     * Valida os limites e repeticao do tiro, aplicando o dano no navio caso exista.
     *
     * @param pos Coordenada visada pelo disparo.
     * @return O navio afundado em decorrencia deste disparo, ou {@code null} se o tiro for na agua,
     *         invalido, repetido ou se o navio atingido ainda permanecer a flutuar.
     */
    @Override
    public IShip fire(IPosition pos) {
        if (!validShot(pos))
            countInvalidShots++;
        else { // valid shot!
            if (repeatedShot(pos))
                countRepeatedShots++;
            else {
                shots.add(pos);
                IShip s = fleet.shipAt(pos);
                if (s != null) {
                    s.shoot(pos);
                    countHits++;
                    if (!s.stillFloating()) {
                        countSinks++;
                        return s;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Obtem a lista de coordenadas dos tiros validos e nao repetidos ja disparados.
     *
     * @return Lista com as posicoes atingidas ao longo da partida.
     */
    @Override
    public List<IPosition> getShots() {
        return shots;
    }

    /**
     * Obtem o numero de disparos repetidos efetuados durante o jogo.
     *
     * @return O total de tiros repetidos.
     */
    @Override
    public int getRepeatedShots() {
        return this.countRepeatedShots;
    }

    /**
     * Obtem o numero de tiros disparados para fora dos limites da grelha.
     *
     * @return O total de tiros invalidos.
     */
    @Override
    public int getInvalidShots() {
        return this.countInvalidShots;
    }

    /**
     * Obtem o numero total de tiros certeiros em navios.
     *
     * @return O total de acertos em partes de embarcacoes.
     */
    @Override
    public int getHits() {
        return this.countHits;
    }

    /**
     * Obtem o numero total de navios da frota que foram completamente afundados.
     *
     * @return O total de navios destruidos.
     */
    @Override
    public int getSunkShips() {
        return this.countSinks;
    }

    /**
     * Obtem a quantidade de navios da frota que ainda permanecem a flutuar.
     *
     * @return O numero de navios operacionais restantes.
     */
    @Override
    public int getRemainingShips() {
        List<IShip> floatingShips = fleet.getFloatingShips();
        return floatingShips.size();
    }

    /**
     * Verifica se uma determinada coordenada se encontra dentro dos limites validos do tabuleiro.
     *
     * @param pos Posicao a avaliar.
     * @return {@code true} se o tiro estiver dentro dos limites do tabuleiro; {@code false} caso contrario.
     */
    private boolean validShot(IPosition pos) {
        return (pos.getRow() >= 0 && pos.getRow() <= Fleet.BOARD_SIZE && pos.getColumn() >= 0
                && pos.getColumn() <= Fleet.BOARD_SIZE);
    }

    /**
     * Verifica se uma determinada coordenada ja foi alvo de um disparo anterior.
     *
     * @param pos Posicao a avaliar.
     * @return {@code true} se o tiro ja existir no historico de disparos; {@code false} caso contrario.
     */
    private boolean repeatedShot(IPosition pos) {
        for (int i = 0; i < shots.size(); i++)
            if (shots.get(i).equals(pos))
                return true;
        return false;
    }

    /**
     * Imprime no terminal uma representacao visual da grelha de jogo, marcando
     * posicoes especificas com o caractere fornecido e celulas vazias com '.'.
     *
     * @param positions Lista de coordenadas a marcar na grelha.
     * @param marker    Caractere a utilizar na marcacao das celulas indicadas.
     */
    public void printBoard(List<IPosition> positions, Character marker) {
        char[][] map = new char[Fleet.BOARD_SIZE][Fleet.BOARD_SIZE];

        for (int r = 0; r < Fleet.BOARD_SIZE; r++)
            for (int c = 0; c < Fleet.BOARD_SIZE; c++)
                map[r][c] = '.';

        for (IPosition pos : positions)
            map[pos.getRow()][pos.getColumn()] = marker;

        for (int row = 0; row < Fleet.BOARD_SIZE; row++) {
            for (int col = 0; col < Fleet.BOARD_SIZE; col++)
                System.out.print(map[row][col]);
            System.out.println();
        }

    }

    /**
     * Imprime no terminal a grelha de jogo exibindo todos os tiros validos disparados com a marca 'X'.
     */
    public void printValidShots() {
        printBoard(getShots(), 'X');
    }

    /**
     * Imprime no terminal a grelha de jogo exibindo as posicoes de todos os navios da frota com a marca '#'.
     */
    public void printFleet() {
        List<IPosition> shipPositions = new ArrayList<IPosition>();

        for (IShip s : fleet.getShips())
            shipPositions.addAll(s.getPositions());

        printBoard(shipPositions, '#');
    }

}
