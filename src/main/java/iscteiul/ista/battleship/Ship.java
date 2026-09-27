package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe abstrata que implementa a interface {@link IShip}.
 * Fornece a estrutura base e a lógica comum a todos os tipos de navios do jogo,
 * gerindo a sua categoria, orientação e posições ocupadas no tabuleiro.
 */
public abstract class Ship implements IShip {

    private static final String GALEAO = "galeao";
    private static final String FRAGATA = "fragata";
    private static final String NAU = "nau";
    private static final String CARAVELA = "caravela";
    private static final String BARCA = "barca";

    /**
     * Método fábrica (Factory Method) para construir a instância correta de um navio
     * com base na categoria solicitada.
     *
     * @param shipKind O tipo de navio a construir (ex: "galeao", "fragata").
     * @param bearing  A orientação do navio no tabuleiro.
     * @param pos      A posição inicial (âncora) do navio.
     * @return Uma nova instância da subclasse correspondente ao tipo de navio, 
     *         ou null se o tipo for desconhecido.
     */
    static Ship buildShip(String shipKind, Compass bearing, Position pos) {
        Ship s;
        switch (shipKind) {
            case BARCA:
                s = new Barge(bearing, pos);
                break;
            case CARAVELA:
                s = new Caravel(bearing, pos);
                break;
            case NAU:
                s = new Carrack(bearing, pos);
                break;
            case FRAGATA:
                s = new Frigate(bearing, pos);
                break;
            case GALEAO:
                s = new Galleon(bearing, pos);
                break;
            default:
                s = null;
        }
        return s;
    }

    private String category;
    private Compass bearing;
    private IPosition pos;
    protected List positions;

    /**
     * Construtor base para inicializar os atributos comuns de um navio.
     *
     * @param category A categoria do navio.
     * @param bearing  A orientação (direção) do navio.
     * @param pos      A posição principal de referência.
     */
    public Ship(String category, Compass bearing, IPosition pos) {
        assert bearing != null;
        assert pos != null;

        this.category = category;
        this.bearing = bearing;
        this.pos = pos;
        positions = new ArrayList<>();
    }

    /**
     * Obtém a categoria à qual este navio pertence.
     *
     * @return O nome da categoria do navio.
     */
    @Override
    public String getCategory() {
        return category;
    }

    /**
     * Obtém a lista completa das posições que compõem o corpo do navio.
     *
     * @return Uma lista de coordenadas (IPosition) ocupadas pelo navio.
     */
    public List getPositions() {
        return positions;
    }

    /**
     * Obtém a posição de referência original do navio.
     *
     * @return A coordenada principal do navio.
     */
    @Override
    public IPosition getPosition() {
        return pos;
    }

    /**
     * Obtém a orientação espacial do navio.
     *
     * @return A direção (Compass) do navio.
     */
    @Override
    public Compass getBearing() {
        return bearing;
    }

    /**
     * Verifica se o navio ainda possui pelo menos uma posição intacta (não atingida).
     *
     * @return true se o navio não estiver totalmente afundado, false caso contrário.
     */
    @Override
    public boolean stillFloating() {
        for (int i = 0; i < getSize(); i++)
            if (!getPositions().get(i).isHit())
                return true;
        return false;
    }

    /**
     * Calcula o limite superior do navio no tabuleiro.
     *
     * @return O menor índice de linha ocupado pelo navio.
     */
    @Override
    public int getTopMostPos() {
        int top = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() < top)
                top = getPositions().get(i).getRow();
        return top;
    }

    /**
     * Calcula o limite inferior do navio no tabuleiro.
     *
     * @return O maior índice de linha ocupado pelo navio.
     */
    @Override
    public int getBottomMostPos() {
        int bottom = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() > bottom)
                bottom = getPositions().get(i).getRow();
        return bottom;
    }

    /**
     * Calcula o limite esquerdo do navio no tabuleiro.
     *
     * @return O menor índice de coluna ocupado pelo navio.
     */
    @Override
    public int getLeftMostPos() {
        int left = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() < left)
                left = getPositions().get(i).getColumn();
        return left;
    }

    /**
     * Calcula o limite direito do navio no tabuleiro.
     *
     * @return O maior índice de coluna ocupado pelo navio.
     */
    @Override
    public int getRightMostPos() {
        int right = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() > right)
                right = getPositions().get(i).getColumn();
        return right;
    }

    /**
     * Verifica se o navio ocupa uma posição específica.
     *
     * @param pos A posição a verificar.
     * @return true se alguma parte do navio estiver na posição indicada, false caso contrário.
     */
    @Override
    public boolean occupies(IPosition pos) {
        assert pos != null;

        for (int i = 0; i < getSize(); i++)
            if (getPositions().get(i).equals(pos))
                return true;
        return false;
    }

    /**
     * Verifica se este navio colide ou está demasiado próximo de outro navio.
     *
     * @param other O outro navio a testar.
     * @return true se houver sobreposição ou violação das regras de adjacência, false caso contrário.
     */
    @Override
    public boolean tooCloseTo(IShip other) {
        assert other != null;

        Iterator otherPos = other.getPositions().iterator();
        while (otherPos.hasNext())
            if (tooCloseTo(otherPos.next()))
                return true;

        return false;
    }

    /**
     * Verifica se uma dada posição colide ou está demasiado próxima do corpo deste navio.
     *
     * @param pos A coordenada a testar.
     * @return true se a posição for adjacente ou sobreposta ao navio, false caso contrário.
     */
    @Override
    public boolean tooCloseTo(IPosition pos) {
        for (int i = 0; i < this.getSize(); i++)
            if (getPositions().get(i).isAdjacentTo(pos))
                return true;
        return false;
    }

    /**
     * Regista um tiro numa posição que pertence ao navio.
     *
     * @param pos A coordenada que sofreu o impacto.
     */
    @Override
    public void shoot(IPosition pos) {
        assert pos != null;

        for (IPosition position : getPositions()) {
            if (position.equals(pos))
                position.shoot();
        }
    }

    /**
     * Devolve uma representação em formato de string dos atributos base do navio.
     *
     * @return Uma string no formato "[categoria orientação posição]".
     */
    @Override
    public String toString() {
        return "[" + category + " " + bearing + " " + pos + "]";
    }
}
