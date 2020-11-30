package org.example;

public class Gameboard extends Subject implements IGameboard{

    String arr[][] = new String[6][7];
    String currentPlayer = null;

    RoundCounter counter;

    public Gameboard(RoundCounter counter) {
        this.counter = counter;
    }

    @Override
    public String[][] getBoard() {
        return new String[0][];
    }

    @Override
    public boolean placeMarker(String player, int row) {
        return false;
    }

    @Override
    public String getStylishBoard() {
        return null;
    }

    @Override
    public String decideStartingPlayer() {
        return null;
    }

    @Override
    public String evaluateWin() {
        return null;
    }

    @Override
    public String changePlayer() {
        return null;
    }

    @Override
    public String announceFinalWinner() {
        return null;
    }


}
