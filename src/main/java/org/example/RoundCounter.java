package org.example;

public class RoundCounter {

    int currentRound = 0;
    int maxRounds = 0;

    public RoundCounter(int maxRounds){
        this.maxRounds = maxRounds;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public boolean setCurrentRound() {
        if (currentRound < maxRounds){
            currentRound++;
            return true;
        }else return false;
    }

    public int getMaxRounds() {
        return maxRounds;
    }

    public void setMaxRounds(int maxRounds) {
        this.maxRounds = maxRounds;
    }
}
