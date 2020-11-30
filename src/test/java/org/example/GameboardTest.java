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


        Assertions.assertEquals(true, gameboard.placeMarker("X", 1));
    }

    @Test
    void testFailPlaceMarker(){

        gameboard.placeMarker("X", 1);
        Assertions.assertEquals(false, gameboard.placeMarker("X", 1));
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




/*  Test here or in another test class?

    @Test
    void testGetPlayedRounds(){


    }

    @Test
    void testNextRoundOnWin(){

    }

 */

}
