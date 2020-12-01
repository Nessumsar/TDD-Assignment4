package org.example;

import java.util.ArrayList;

public class GameboardObserver extends Observer {

    ArrayList<String> storage = new ArrayList<>();

    @Override
    public void update(String player, String place) {
        storage.add(player + " | " + place);
        System.out.println(player + " | " + place);
    }
}
