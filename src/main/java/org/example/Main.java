package org.example;

import obs.*;

public class Main {
    public static void main(String[] args) {
        ObservableImpl observable = new ObservableImpl();
        Observer o1 = new ObserverImpl1();
        Observer o2 = new ObserverImpl2();

        observable.subscribe(o1);
        observable.subscribe(o2); // Subscribe the second observer

        // Set the state, and then notify observers
        observable.setState(60);
        observable.notifyObservers(); // Notify observers after the state change

        observable.setState(80);
        observable.notifyObservers(); // Notify observers after the state change

        observable.unsubscribe(o2);

        observable.setState(100);
        observable.notifyObservers(); // Notify observers after the state change

        observable.subscribe(new Observer(){

            @Override
            public void update(int newState) {
                System.out.println("++++++++++ OBS Impl 3 +++++++++++++");
                System.out.println("Res = " + newState*Math.cos(newState));
                System.out.println("++++++++++ OBS Impl 3 +++++++++++++");
            }
        });

        //depuis java 8 on utilise lambda
        //tech de push

        observable.subscribe(newState -> {
            System.out.println("++++++++++ OBS Impl 4 +++++++++++++");
            System.out.println("Res = " + newState*Math.cos(newState));
            System.out.println("++++++++++ OBS Impl 4 +++++++++++++");
        });

        observable.setState(200);
        observable.notifyObservers();




    }
}