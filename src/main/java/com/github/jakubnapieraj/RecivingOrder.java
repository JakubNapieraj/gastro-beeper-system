package com.github.jakubnapieraj;

import java.util.TimerTask;

public class RecivingOrder extends TimerTask {

    private CollectingPoint collectingPoint;
    private Beeper beeper;

    public RecivingOrder(CollectingPoint collectingPoint, Beeper beeper) {
        this.collectingPoint = collectingPoint;
        this.beeper = beeper;
    }

    @Override
    public void run() {
        collectingPoint.orderRecived(beeper);
    }
}
