package org.example;

import java.util.Random;

public class Gameboard extends Subject implements IGameboard{

    String[][] arr;
    String currentPlayer = null;

    RoundCounter counter;

    public Gameboard(RoundCounter counter) {
        this.counter = counter;
        arr =   new String[][]{
            {" ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " "}
        };
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
        int rows = arr.length;
        int cols = arr[0].length;
        //Horizontal
        for(int i = 0; i<rows; i++){
            for(int y = 0; y < cols; y++){
                if(arr[i][y].equals("X") && arr[i][y + 1].equals("X") && arr[i][y + 2].equals("X") && arr[i][y + 3].equals("X")){
                    return "X";
                }
                if(arr[i][y].equals("Y") && arr[i][y + 1].equals("Y") && arr[i][y + 2].equals("Y") && arr[i][y + 3].equals("Y")){
                    return "Y";
                }
            }
        }
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
