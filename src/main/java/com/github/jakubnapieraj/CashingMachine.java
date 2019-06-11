package com.github.jakubnapieraj;


public class CashingMachine {

    private Manager manager;

    public void setManager(Manager manager) {
        this.manager = manager;
    }


    public void newOrder(FoodType foodType) {
        manager.newOrder(foodType);

    }


}
