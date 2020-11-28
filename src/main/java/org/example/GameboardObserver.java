package org.example;

public class GameboardObserver extends Observer {

    @Override
    public void update() {
        System.out.println("Gameboard observed and noticed.");
    }
}
