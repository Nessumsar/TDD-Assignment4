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
                {" ", " ", " ", " ", " ", " ", " "},
        };
    }

    @Override
    public boolean placeMarker(String player, String row) {
        int rows = arr[0].length;
        int cols = arr.length;
        int rowToPlace;

        try{
            rowToPlace = Integer.parseInt(row);
        }catch(Exception e){
            throw new IllegalArgumentException();
        }

        if(rowToPlace > rows || rowToPlace < 1){
            throw new IllegalArgumentException();
        }
        rowToPlace--;

        for(int i = cols - 1; i > 0; i--){
            if(arr[i][rowToPlace].equals(" ")){
                arr[i][rowToPlace] = player;
                Notify(player, row);
                return true;
            }
        }

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
                if(arr[i][y].equals("O") && arr[i][y + 1].equals("O") && arr[i][y + 2].equals("O") && arr[i][y + 3].equals("O")){
                    return "O";
                }
            }
        }
        //Vertical
        for(int i = 0; i<cols; i++){
            for(int y = 0; y < rows; y++){
                if(arr[i][y].equals("X") && arr[i + 1][y].equals("X") && arr[i + 2][y].equals("X") && arr[i + 3][y].equals("X")){
                    return "X";
                }
                if(arr[i][y].equals("O") && arr[i + 1][y].equals("O") && arr[i + 2][y].equals("O") && arr[i + 3][y].equals("O")){
                    return "O";
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
        if (counter.getScoreO() > counter.getScoreX()){
            return "O";
        }else if (counter.getScoreO() < counter.getScoreX()){
            return "X";
        }else{
            return "Draw";
        }
    }


}
