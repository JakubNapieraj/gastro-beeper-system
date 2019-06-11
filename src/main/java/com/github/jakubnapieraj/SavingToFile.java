package com.github.jakubnapieraj;

import java.io.IOException;
import java.util.TimerTask;

public class SavingToFile extends TimerTask {

    public Manager manager;

    public SavingToFile(Manager manager ) {
        this.manager = manager;
    }



    @Override
    public void run() {
        try {
            manager.createFile("Zamówienia");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;

    }


}
