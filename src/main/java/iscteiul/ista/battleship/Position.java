package iscteiul.ista.battleship;

import java.util.Objects;

/**
 * Representa uma posição concreta no tabuleiro da Batalha Naval.
 * Implementa a interface {@link IPosition}, armazenando as coordenadas (linha e coluna)
 * e o estado atual da célula (se está ocupada por um navio e se já foi atingida).
 */
public class Position implements IPosition {
    private int row;
    private int column;
    private boolean isOccupied;
    private boolean isHit;

    /**
     * Construtor da classe Position.
     * Inicializa a posição com as coordenadas especificadas.
     * Por omissão, a posição começa sem estar ocupada e sem ter sido atingida.
     *
     * @param row    A linha onde a posição se encontra.
     * @param column A coluna onde a posição se encontra.
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.isOccupied = false;
        this.isHit = false;
    }

    /**
     * Obtém o índice da linha desta posição.
     *
     * @return A linha correspondente.
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * Obtém o índice da coluna desta posição.
     *
     * @return A coluna correspondente.
     */
    @Override
    public int getColumn() {
        return column;
    }

    /**
     * Gera um código hash para esta posição, baseado nas suas coordenadas e estado.
     *
     * @return O valor do código hash gerado.
     */
    @Override
    public int hashCode() {
        return Objects.hash(column, isHit, isOccupied, row);
    }

    /**
     * Compara esta posição com outro objeto.
     * São consideradas iguais se o outro objeto for uma IPosition com a mesma linha e coluna.
     *
     * @param otherPosition O objeto a comparar com a posição atual.
     * @return true se as posições tiverem as mesmas coordenadas, false caso contrário.
     */
    @Override
    public boolean equals(Object otherPosition) {
        if (this == otherPosition)
            return true;
        if (otherPosition instanceof IPosition) {
            IPosition other = (IPosition) otherPosition;
            return (this.getRow() == other.getRow() && this.getColumn() == other.getColumn());
        } else {
            return false;
        }
    }

    /**
     * Verifica se esta posição é adjacente a outra (distância máxima de 1 célula
     * na horizontal, vertical ou diagonal).
     *
     * @param other A outra posição a comparar.
     * @return true se forem adjacentes, false caso contrário.
     */
    @Override
    public boolean isAdjacentTo(IPosition other) {
        return (Math.abs(this.getRow() - other.getRow()) <= 1 && Math.abs(this.getColumn() - other.getColumn()) <= 1);
    }

    /**
     * Altera o estado desta posição para indicar que está ocupada por um navio.
     */
    @Override
    public void occupy() {
        isOccupied = true;
    }

    /**
     * Altera o estado desta posição para indicar que foi atingida por um tiro.
     */
    @Override
    public void shoot() {
        isHit = true;
    }

    /**
     * Verifica se a posição está ocupada por um navio.
     *
     * @return true se estiver ocupada, false caso contrário.
     */
    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * Verifica se a posição já foi atingida por um disparo.
     *
     * @return true se foi atingida, false caso contrário.
     */
    @Override
    public boolean isHit() {
        return isHit;
    }

    /**
     * Devolve uma representação em formato de texto desta posição.
     *
     * @return Uma string contendo os valores da linha e da coluna.
     */
    @Override
    public String toString() {
        return ("Linha = " + row + " Coluna = " + column);
    }
}
