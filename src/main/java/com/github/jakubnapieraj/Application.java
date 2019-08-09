package com.github.jakubnapieraj;


import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;

public class Application {

    public static void main(String[] args) throws IOException {

        Kitchen kitchen = new Kitchen();
        CollectingPoint collectingPoint = new CollectingPoint();
        CashingMachine cashingMachine = new CashingMachine();

        Manager manager = new Manager(kitchen, cashingMachine, collectingPoint);
        kitchen.setManager(manager);
        cashingMachine.setManager(manager);
        collectingPoint.setManager(manager);

        Scanner scanner = new Scanner(System.in);
        Timer timer = new Timer();
        timer.schedule(new SavingToFile(manager), 30_000);

        for (int i = 0; ; i++) {
            System.out.println("Co chcesz zjeść?");
            System.out.println("BURGER " + "FRYTKI " + "ZIELSKO " + "NACHOSY " + "SERUS");

            String clientOrder = scanner.nextLine();
            FoodType foodType = FoodType.fromStringIgnoreCase(clientOrder);

            if (clientOrder.equals(";p")) {
                manager.createFile("Zamówienia");
                System.exit(0);
            } else if (foodType != null)
                cashingMachine.newOrder(FoodType.fromStringIgnoreCase(clientOrder));
            else {
                System.out.println("Nie mamy tego w menu");
            }

            System.out.println(manager.getBeeperList());
        }

    }
}