package org.example;

import java.lang.reflect.Array;

public class Gameboard extends Subject implements IGameboard{

    String arr[][] = new String[6][7];
    int rounds = 0;
    String player = null;


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
    public boolean evaluateWin() {
        return false;
    }

    @Override
    public void changePlayer() {

    }

    @Override
    public void announceFinalWinner() {

    }


}
