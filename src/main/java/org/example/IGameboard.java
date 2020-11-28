package org.example;

public interface IGameboard {
    /**
     * Get current gameboard
     * @return Gameboard Array.
     */
    String[][] getGameboard();

    /**
     * Update gameboard on requested row
     * @param row
     * @return Successful update = true, unsuccessful = false.
     */
    boolean updateGameboard(int row);
}
