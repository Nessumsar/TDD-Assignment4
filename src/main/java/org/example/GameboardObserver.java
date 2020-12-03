package org.example;

import java.util.ArrayList;

public class GameboardObserver extends Observer {

    ArrayList<String> storage = new ArrayList<>();

    @Override
    public void update(int round, String player, String place) {
        storage.add("Round " + round + " |" + player + " | " + place);
        System.out.println(player + " | " + place);
    }

    @Override
    public void replayGame() {
        storage.forEach(System.out::println);
    }

    @Override
    public void replayRound(int round) {
        for (String s : storage){
            if (s.contains("Round " + round)){
                System.out.println(s);
            }
        }
    }
}
