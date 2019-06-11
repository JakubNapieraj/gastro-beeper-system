package com.github.jakubnapieraj;

public enum FoodType {
    BURGER(30000), FRYTKI(10000), ZIELSKO(5000), NACHOSY(3000), SERUS(20000);

    private int preparationDurationMillis;

    FoodType(int preparationDurationMillis) {
        this.preparationDurationMillis = preparationDurationMillis;
    }

    public static FoodType fromStringIgnoreCase(String name){
        for (FoodType value : values()) {
            if (value.name().equalsIgnoreCase(name)) {
                return value;
            }
        }
         return null;
    }

    public int getPreparationDurationMillis() {
        return preparationDurationMillis;
    }
}
