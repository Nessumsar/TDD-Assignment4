package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameboardTest
{
    RoundCounter counter = null;
    Gameboard gameboard = null;

    @BeforeEach
    void setup(){
        counter = new RoundCounter(3);
        gameboard = new Gameboard(counter);
    }

    @AfterEach
    void tearDown(){
        counter = null;
        gameboard = null;
    }

    @Test
    void testSuccessPlaceMarker(){
        String[][] expectedArr = new String[6][7];
        expectedArr[0][0] = "x";

        Assertions.assertTrue(gameboard.placeMarker("X", "1"));
        Assertions.assertArrayEquals(expectedArr, gameboard.getBoard());
    }

    @Test
    void testFailPlaceMarker(){
        gameboard.placeMarker("X", "1");
        Assertions.assertFalse(gameboard.placeMarker("X", "1"));
    }

    @Test
    void testPlaceMarkerOnNonExistingRow(){
        String[][] expectedArr = new String[6][7];

        Assertions.assertFalse(gameboard.placeMarker("X", "99"));
        Assertions.assertArrayEquals(expectedArr, gameboard.getBoard());
    }

    @Test
    void testPlaceMarkerAndWin(){

        gameboard.placeMarker("X", "1");
        gameboard.placeMarker("X", "2");
        gameboard.placeMarker("X", "3");
        gameboard.placeMarker("X", "4");
        Assertions.assertEquals("X", gameboard.evaluateWin());
    }

    @Test
    void testHorizontalEvaluationOfWin(){
        String mockArr[][] = {
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", "O", "O", " "},
                {" ", "X", "X", "X", "X", "O", " "},
        };
        gameboard.arr = mockArr;
        Assertions.assertEquals("X", gameboard.evaluateWin());
    }

    @Test
    void testAscendingDiagonalEvaluationOfWin(){
        String mockArr[][] = {
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ",  " ", " ", "X", "X", " ", " "},
                {" ",  " ", "X", "O", "O", "O",  " "},
                { " ", "X", "O", "O", "X", "O",  " "},
        };
        gameboard.arr = mockArr;
        Assertions.assertEquals("x", gameboard.evaluateWin());
    }

    @Test
    void testDescendingDiagonalEvaluationOfWin(){
        String mockArr[][] = {
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {"X"," ", " ", " ", "X"," ", " "},
                {"O", "X", " ", "O", "X", " ", " "},
                {"O", "O", "X", "O", "O", "O", " "},
                {"O", "O", "O", "X", "X", "O", " "},
        };
        gameboard.arr = mockArr;
        Assertions.assertEquals("x", gameboard.evaluateWin());
    }

    @Test
    void testVerticalEvaluationOfWin(){
        String mockArr[][] = {
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", "O", " ", " ", " "},
                {" ", " ", " ", "O", " ", "X", " "},
                {" ", " ", "X", "O", "O", "O", " "},
                {" ", "x", "x", "O", "x", "O", " "},
        };
        gameboard.arr = mockArr;
        Assertions.assertEquals("O", gameboard.evaluateWin());
    }

    @Test
    void testFinishGameOnWin(){

        Assertions.assertEquals("X", gameboard.announceFinalWinner());
    }

    @Test
    void testStartingPlayer(){
        gameboard.decideStartingPlayer();
        Assertions.assertNotNull(gameboard.currentPlayer);
    }

    @Test
    void testChangePlayer(){
        gameboard.decideStartingPlayer();
        String expected = gameboard.currentPlayer;
        gameboard.changePlayer();
        Assertions.assertEquals(expected.equals("X") ? "O" : "X", gameboard.currentPlayer);
    }


    @Test
    void testGetCurrentRoundOnInit(){
        Assertions.assertEquals(1, gameboard.counter.getCurrentRound());
    }

    @Test
    void testCurrentRoundAfterWinOrDraw(){
        gameboard.placeMarker("X", "1");
        gameboard.placeMarker("X", "2");
        gameboard.placeMarker("X", "3");
        gameboard.placeMarker("X", "4");
        Assertions.assertEquals(2, gameboard.counter.getCurrentRound());
    }


}
