package org.example;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {

        System.out.println("Hello and welcome to 4 in a row. How many rounds would you like to play?");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        RoundCounter counter = new RoundCounter(input);
        Gameboard gameboard = new Gameboard(counter);

        System.out.println("Lets begin.");
        String player1 = gameboard.decideStartingPlayer();
        String player2 = player1.equals("X") ? "O" : "X";

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
