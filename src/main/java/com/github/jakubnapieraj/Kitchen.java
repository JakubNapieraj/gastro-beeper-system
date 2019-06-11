package com.github.jakubnapieraj;

import java.util.SortedMap;
import java.util.Timer;

public class Kitchen {

    private Manager manager;

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void makeAOrder(Beeper beeper) {
        MealPreparation mealPreparation = new MealPreparation(this, beeper);
        Timer timer = new Timer();
        System.out.println("We are starting to prepare the order ");
        timer.schedule(mealPreparation, beeper.getFoodType().getPreparationDurationMillis());
    }


    public void orderComplited(Beeper beeper) {
        manager.orderComplited(beeper);
        System.out.println("Meal is prepared!");
    }
}
