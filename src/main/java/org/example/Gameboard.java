package org.example;

import java.util.Random;

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
    public boolean placeMarker(String player, String row) {




        Notify(player, row);
        return false;
    }

    @Override
    public void getStylishBoard() {

    }

    @Override
    public void decideStartingPlayer() {
        Random random = new Random();
        int value = random.nextInt(2);
        if (value == 1){
            currentPlayer = "X";
        }
        currentPlayer = "O";
    }

    @Override
    public String evaluateWin() {
        return null;
    }

    @Override
    public void changePlayer() {
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }

    @Override
    public String announceFinalWinner() {
        return null;
    }


}
