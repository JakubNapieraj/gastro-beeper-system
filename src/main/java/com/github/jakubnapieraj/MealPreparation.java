package com.github.jakubnapieraj;


import java.util.TimerTask;

public class MealPreparation extends TimerTask {

    private Kitchen kitchen;
    private Beeper beeper;

    public MealPreparation(Kitchen kitchen, Beeper beeper) {
        this.kitchen = kitchen;
        this.beeper = beeper;
    }


    @Override
    public void run() {
        kitchen.orderComplited(beeper);

    }


}
