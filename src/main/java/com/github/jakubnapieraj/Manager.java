package com.github.jakubnapieraj;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Manager<orderName> {

    private Kitchen kitchen;
    private CashingMachine cashingMachine;
    private CollectingPoint collectingPoint;
    private List<Beeper> beeperList = new ArrayList<Beeper>();


    public Manager(Kitchen kitchen, CashingMachine cashingMachine, CollectingPoint collectingPoint) {
        this.kitchen = kitchen;
        this.collectingPoint = collectingPoint;
        this.cashingMachine = cashingMachine;
    }


    public void newOrder(FoodType foodType) {
        Beeper beeper = new Beeper(foodType.name());
        makeAOrder(beeper);
        beeperList.add(beeper);
    }

    public void makeAOrder(Beeper beeper) {
        kitchen.makeAOrder(beeper);
    }

    public void orderComplited(Beeper beeper) {
        callTheClient(beeper);

    }

    public void callTheClient(Beeper beeper) {
        collectingPoint.callTheClient(beeper);
    }

    public void orderReceived(Beeper beeper) {

        System.out.println("Zamówienie odebrane!");
        beeper.setTimeOfRealisationOrder(LocalDateTime.now());

    }

    public void createFile(String file)
            throws IOException {
        FileWriter writer = new FileWriter(file + LocalDateTime.now() + ".txt");
        int size = beeperList.size();
        for (int i = 0; i < size; i++) {
            String str = beeperList.get(i).toString();
            writer.write(str);
            if (i < size - 1)
                writer.write("\n");
        }
        writer.close();
    }

    public List<Beeper> getBeeperList() {
        return beeperList;
    }
}
