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
    void getStylishBoard();

    void decideStartingPlayer();

    String evaluateWin();

    void changePlayer();

    String announceFinalWinner();
}
