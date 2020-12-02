package org.example;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameboardObserver extends Observer {

    ArrayList<String> storage = new ArrayList<>();

    @Override
    public void update(String player, String place) {
        storage.add(player + " | " + place);
        System.out.println(player + " | " + place);
    }

    @Override
    public void replayGame() {
        Timer timer = new Timer();
        storage.forEach(System.out::println);
    }
}
