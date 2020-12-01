package org.example;

public class RoundCounter {

    private int currentRound = 0;
    private int maxRounds = 0;
    private int scoreO = 0;
    private int scoreX = 0;


    public RoundCounter(int maxRounds){
        this.maxRounds = maxRounds;
        currentRound++;
    }

    public int getScoreO() {
        return scoreO;
    }

    public void setScoreO(int scoreO) {
        this.scoreO = scoreO;
    }

    public int getScoreX() {
        return scoreX;
    }

    public void setScoreX(int scoreX) {
        this.scoreX = scoreX;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public boolean setCurrentRound() {
        if (currentRound <= maxRounds){
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
