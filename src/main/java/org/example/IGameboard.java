package org.example;

public interface IGameboard {

    /**
     * Update gameboard on requested row
     * @param row, player
     * @return Successful update = true, unsuccessful = false.
     */
    boolean placeMarker(String player, String row);

    //Converts array to nice looking board
    void getStylishBoard();

    void decideStartingPlayer();

    String evaluateWin();

    void changePlayer();

    String announceFinalWinner();
}
