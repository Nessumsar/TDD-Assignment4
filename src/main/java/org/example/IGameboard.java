package org.example;

public interface IGameboard {

    /**
     * Get current gameboard
     * @return Gameboard Array.
     */
    String[][] getBoard();

    /**
     * Update gameboard on requested row
     * @param row, player
     * @return Successful update = true, unsuccessful = false.
     */
    boolean placeMarker(String player, int row);

    //Converts array to nice looking board
    String getStylishBoard();

    String decideStartingPlayer();

    String evaluateWin();

    String changePlayer();

    String announceFinalWinner();
}
