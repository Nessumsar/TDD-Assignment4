package org.example;

import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {
        System.out.println("Hello and welcome to 4 in a row. How many rounds would you like to play?");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        GameboardObserver observer = new GameboardObserver();
        RoundCounter counter = new RoundCounter(input);
        Gameboard gameboard = new Gameboard(counter);
        gameboard.Attach(observer);

        for(int i=1; i<=gameboard.counter.getMaxRounds(); i++){

            System.out.println("Lets begin round " + counter.getCurrentRound());
            gameboard.decideStartingPlayer();
            System.out.println(gameboard.currentPlayer + " will start.");
            boolean keepPlaying = true;

            while (keepPlaying){
                System.out.println("Player " + gameboard.currentPlayer + ", place your marker in a row between 1-7.");
                String row = sc.next();
                boolean isPlaced = gameboard.placeMarker(gameboard.currentPlayer, row);

                if (isPlaced){
                    gameboard.getStylishBoard();
                    String isWon = gameboard.evaluateWin();

                    if (!isWon.equals(" ")){
                        keepPlaying = false;
                        if (isWon.equals("Draw")){
                            System.out.println("It ended in a draw.");
                        }else if (isWon.equals("X") || isWon.equals("O")){
                            System.out.println(isWon + " won this round.");
                        }

                    }else{
                        gameboard.changePlayer();
                    }

                }

            }

            if (i == counter.getMaxRounds()){
                String winner = gameboard.announceFinalWinner();
                if (winner.equals("Draw")){
                    System.out.println("The whole game resulted in a draw. That's boring.");
                }else{
                    System.out.println("The whole game resulted in a win. The winner is.... " + winner);
                }
                System.out.println("Enter Y if you want to see a replay of the game.");
                String replay = sc.next();
                if (replay.trim().equals("Y")){
                    observer.replayGame();
                }
            }


        }



    }
}
