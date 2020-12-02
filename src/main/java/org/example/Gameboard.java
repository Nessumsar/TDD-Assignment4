package org.example;


import java.util.Arrays;
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
            return false;
        }

        if(rowToPlace > rows || rowToPlace < 1 ||
                !player.equals("X") && !player.equals("O")){
            return false;
        }
        rowToPlace--;

        for(int i = cols - 1; i > 0; i--){
            if(arr[i][rowToPlace].equals(" ")){
                arr[i][rowToPlace] = player;
                Notify(player, i + "," + rowToPlace);
                return true;
            }
        }

        return false;
    }

    @Override
    public void getStylishBoard() {
        int rows = arr.length;
        for (int i=0; i<rows; i++){
            String separatedArr = Arrays.toString(arr[i]);
            separatedArr = separatedArr.replace(",", "|");
            System.out.println(separatedArr);
        }
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
        int rows = arr.length - 1 ;
        int cols = arr[0].length - 1;
        String ret = " ";
        for(int y = 0; y<rows-3; y++){
            for(int i = 0; i < cols ; i++){
                if(arr[i][y].equals("X") && arr[i][y + 1].equals("X") && arr[i][y + 2].equals("X") && arr[i][y + 3].equals("X")){
                    ret = "X";
                }
                if(arr[i][y].equals("O") && arr[i][y + 1].equals("O") && arr[i][y + 2].equals("O") && arr[i][y + 3].equals("O")){
                    ret = "O";
                }
            }
        }
        //Vertical
        for(int i = 0; i<cols-3; i++){
            for(int y = 0; y < rows; y++){
                if(arr[i][y].equals("X") && arr[i + 1][y].equals("X") && arr[i + 2][y].equals("X") && arr[i + 3][y].equals("X")){
                    ret = "X";
                }
                if(arr[i][y].equals("O") && arr[i + 1][y].equals("O") && arr[i + 2][y].equals("O") && arr[i + 3][y].equals("O")){
                    ret = "O";
                }
            }
        }
        //Diagonal right
        for(int i = 3; i< cols; i++){
            for(int y = 0; y < rows - 3; y++){
                if(arr[i][y].equals("X") && arr[i - 1][y + 1].equals("X") && arr[i - 2][y + 2].equals("X") && arr[i - 3][y + 3].equals("X")){
                    ret = "X";
                }
                if(arr[i][y].equals("O") && arr[i - 1][y + 1].equals("O") && arr[i - 2][y + 2].equals("O") && arr[i - 3][y + 3].equals("O")){
                    ret = "O";
                }
            }
        }
        //Diagonal left
        for(int i = 3; i<cols; i++){
            for(int y = 3; y < rows; y++){
                if(arr[i][y].equals("X") && arr[i - 1][y - 1].equals("X") && arr[i - 2][y - 2].equals("X") && arr[i - 3][y - 3 ].equals("X")){
                    ret = "X";
                }
                if(arr[i][y].equals("O") && arr[i - 1][y - 1].equals("O") && arr[i - 2][y - 2].equals("O") && arr[i - 3][y - 3].equals("O")){
                    ret = "O";
                }
            }
        }

        if(ret.equals("X")){
            counter.setScoreX(counter.getScoreX() + 1);
        }
        if(ret.equals("O")){
            counter.setScoreO(counter.getScoreO() + 1);
        }
        counter.setCurrentRound();
        return ret;
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
