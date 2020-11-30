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

        Assertions.assertTrue(gameboard.placeMarker("X", 1));
        Assertions.assertArrayEquals(expectedArr, gameboard.getBoard());
    }

    @Test
    void testFailPlaceMarker(){
        gameboard.placeMarker("X", 1);
        Assertions.assertFalse(gameboard.placeMarker("X", 1));
    }

    @Test
    void testPlaceMarkerOnNonExistingRow(){
        String[][] expectedArr = new String[6][7];

        Assertions.assertFalse(gameboard.placeMarker("X", 99));
        Assertions.assertArrayEquals(expectedArr, gameboard.getBoard());
    }

    @Test
    void testPlaceMarkerAndWin(){

        gameboard.placeMarker("X", 1);
        gameboard.placeMarker("X", 2);
        gameboard.placeMarker("X", 3);
        gameboard.placeMarker("X", 4);
        Assertions.assertEquals("X", gameboard.evaluateWin());
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





/*  Test here or in another test class?

    @Test
    void testGetPlayedRounds(){


    }

    @Test
    void testNextRoundOnWin(){

    }

 */

}
