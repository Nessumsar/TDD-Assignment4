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
                // row = 1 ----- rowToPlace = 5,0 ---- ändra till 1,1 om längst ner i rad 1
                //alternativt skicka in stylishBoard
                Notify(player, i + "," + rowToPlace);
                return true;
            }
        }

        return false;
    }

    @Override
    public void getStylishBoard() {
        for (String[] rows : arr) {
            String separatedArr = Arrays.toString(rows);
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
        //Horizontal
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

        if (ret.equals(" ")){
                int markCounter = 1;
                for (String marker : arr[0]){
                    if (marker.equals("X") || marker.equals("O")) {
                        markCounter++;
                    }
                    if (markCounter == arr.length) {
                        ret = "Draw";
                        Notify("DRAW", "Round " + counter.getCurrentRound() + " is a draw. The score is: X " + counter.getScoreX() + "-" + counter.getScoreO() + " O");
                        counter.setCurrentRound();
                        resetBoard();
                    }
                }
        }


        if(ret.equals("X")){
            counter.setScoreX(counter.getScoreX() + 1);
            Notify("X", "Wins round " + counter.getCurrentRound() + ". The score is: X " + counter.getScoreX() + "-" + counter.getScoreO() + " O");
            counter.setCurrentRound();
            resetBoard();

        }
        if(ret.equals("O")){
            counter.setScoreO(counter.getScoreO() + 1);
            Notify("O", "Wins round " + counter.getCurrentRound() + ". The score is: X " + counter.getScoreX() + "-" + counter.getScoreO() + " O");
            counter.setCurrentRound();
            resetBoard();
        }

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

    @Override
    public void resetBoard(){
        arr =   new String[][]{
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
        };
    }

}
