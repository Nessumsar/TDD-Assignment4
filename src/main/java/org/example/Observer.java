package org.example;

public abstract class Observer {
    public abstract void update(int round, String player, String place);
    public abstract void replayGame();
    public abstract void replayRound(int round);
}
