package com.github.jakubnapieraj;

import java.time.LocalDateTime;
import java.util.UUID;

public class Beeper {

    private String uuid = UUID.randomUUID().toString();
    private LocalDateTime timeOfOrder  = LocalDateTime.now();
    private String orderName  ;
    private FoodType foodType;
    private LocalDateTime timeOfCalling;
    private LocalDateTime timeOfRealisationOrder;



    public Beeper(String orderName) {
        this.foodType = FoodType.valueOf(orderName);
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public LocalDateTime getTimeOfOrder() {
        return timeOfOrder;
    }

    public LocalDateTime getTimeOfRealisationOrder() {
        return timeOfRealisationOrder;
    }

    @Override
    public String toString() {
       return foodType.name() + "-" + timeOfOrder + "-" + getTimeOfRealisationOrder();
    }

    public void setTimeOfRealisationOrder(LocalDateTime timeOfRealisationOrder) {
        this.timeOfRealisationOrder = timeOfRealisationOrder;
    }
}
