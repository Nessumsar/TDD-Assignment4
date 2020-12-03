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
        String mockArr[][] = {
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {"X", " ", " ", " ", " ", " ", " "},
        };
        Assertions.assertTrue(gameboard.placeMarker("X", "1"));
        Assertions.assertArrayEquals(mockArr, gameboard.arr);
    }

    @Test
    void testFailPlaceMarkerOnLetterRow(){
        Assertions.assertFalse(gameboard.placeMarker("X", "B"));
    }

    @Test
    void testFailPlaceMarker(){
        gameboard.placeMarker("X", "1");
        gameboard.placeMarker("X", "1");
        gameboard.placeMarker("X", "1");
        gameboard.placeMarker("X", "1");
        gameboard.placeMarker("X", "1");
        gameboard.placeMarker("X", "1");
        Assertions.assertFalse(gameboard.placeMarker("X", "1"));
    }

    @Test
    void testPlaceMarkerOnNonExistingRow(){
        Assertions.assertFalse(gameboard.placeMarker("X", "8"));
    }

    @Test
    void testPlaceMarkerOnFalsePlayer(){
        Assertions.assertFalse(gameboard.placeMarker("o", "5"));
        Assertions.assertFalse(gameboard.placeMarker("x", "5"));
    }

    @Test
    void testHorizontalEvaluationOfWin(){
        gameboard.arr = new String[][]{
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", "O", "O", " "},
                {" ", "X", "X", "X", "X", "O", " "},
        };
        Assertions.assertEquals("X", gameboard.evaluateWin());
    }

    @Test
    void testAscendingDiagonalEvaluationOfWin(){
        gameboard.arr = new String[][]{
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", "O", " ", " "},
                {" ", " ", " ", "O", "X", " ", " "},
                {" ", " ", "O", "X", "x", "O", " "},
                {" ", "O", "X", "x", "X", "O", " "},
        };
        Assertions.assertEquals("O", gameboard.evaluateWin());
    }

    @Test
    void testDescendingDiagonalEvaluationOfWin(){
        gameboard.arr = new String[][]{
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {"X", " ", " ", " ", "X", " ", " "},
                {"O", "X", " ", "O", "X", " ", " "},
                {"O", "O", "X", "O", "O", "O", " "},
                {"O", "O", "O", "X", "X", "O", " "},
        };
        Assertions.assertEquals("X", gameboard.evaluateWin());
    }

    @Test
    void testVerticalEvaluationOfWin(){
        gameboard.arr = new String[][]{
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", "O", " ", " ", " "},
                {" ", " ", " ", "O", " ", "X", " "},
                {" ", " ", "X", "O", "O", "O", " "},
                {" ", "x", "x", "O", "x", "O", " "},
        };
        Assertions.assertEquals("O", gameboard.evaluateWin());
    }

    @Test
    void testFinishGameOnWinForO(){
        counter.setCurrentRound();
        counter.setCurrentRound();
        counter.setScoreO(2);
        counter.setScoreX(1);
        Assertions.assertEquals("O", gameboard.announceFinalWinner());
    }

    @Test
    void testFinishGameOnWinForX(){
        counter.setCurrentRound();
        counter.setCurrentRound();
        counter.setScoreO(1);
        counter.setScoreX(2);
        Assertions.assertEquals("X", gameboard.announceFinalWinner());
    }

    @Test
    void testFinishGameOnDraw(){
        counter.setCurrentRound();
        counter.setCurrentRound();
        counter.setScoreO(1);
        counter.setScoreX(1);
        Assertions.assertEquals("Draw", gameboard.announceFinalWinner());
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
        gameboard.evaluateWin();
        Assertions.assertEquals(2, gameboard.counter.getCurrentRound());
    }

    @Test
    void testEvaluateWinReturnsDraw(){
        gameboard.arr = new String[][]{
                {"O", "O", "O", "X", "O", "O", "X"},
                {"O", "O", "X", "X", "X", "X", "O"},
                {"X", "X", "O", "O", "O", "X", "O"},
                {"O", "X", "X", "X", "O", "X", "X"},
                {"X", "O", "X", "O", "O", "O", "X"},
                {"O", "x", "x", "O", "x", "O", "X"},
        };
        Assertions.assertEquals("Draw", gameboard.evaluateWin());
    }


}
