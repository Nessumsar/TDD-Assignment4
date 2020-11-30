package org.example;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        boolean keepPlaying = true;
        System.out.println("Hello and welcome to 4 in a row. How many rounds would you like to play?");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        RoundCounter counter = new RoundCounter(input);
        Gameboard gameboard = new Gameboard(counter);

        System.out.println("Lets begin.");
        gameboard.decideStartingPlayer();
        // player1.equals("X") ? "O" : "X";
        System.out.println(gameboard.currentPlayer + " will start.");

        for(int i=0; i<gameboard.counter.currentRound; i++){
            while (keepPlaying){
                System.out.println("Place your marker in a row between 1-7");
                String row = sc.next();
                int parsed = Integer.parseInt(row);

            }
        }
/*      loop round

        gameboard.placeMarker(player1, 1); if not ok - do again
        if ok
        gameboard.evaluateWin();  - if win/draw - next round
        if not
        gameboard.changePlayer()

        endloop

        gameboard.announceFinalWinner
 */

    }
}
