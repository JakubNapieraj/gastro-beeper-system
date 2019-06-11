package com.github.jakubnapieraj;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class CollectingPoint {

    private Manager manager;
    public LocalDateTime timeOfRealisationOrder;


    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void callTheClient (Beeper beeper){
        RecivingOrder recivingOrder = new RecivingOrder(this, beeper);
        Timer timer = new Timer();
        timer.schedule(recivingOrder, 10000);
    }

    public void orderRecived(Beeper beeper){
        manager.orderReceived(beeper);
        timeOfRealisationOrder = LocalDateTime.now();
    }




}
