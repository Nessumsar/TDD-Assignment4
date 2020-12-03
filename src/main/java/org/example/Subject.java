package org.example;

import java.util.ArrayList;

public class Subject {
    public ArrayList<Observer> observers;

    public Subject() {
        observers = new ArrayList<Observer>();
    }

    public void Attach(Observer o){
        observers.add(o);
    }

    public void Detach(Observer o){
        observers.remove(o);
    }

    public void Notify(int round, String player, String place){
        for (Observer o : observers){
            o.update(round, player, place);
        }
    }

}
