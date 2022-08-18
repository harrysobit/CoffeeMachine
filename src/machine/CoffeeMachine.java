package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);
    static int water, milk, cofeeBeans, money, cups;


    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.water = 400;
        coffeeMachine.milk = 540;
        coffeeMachine.cofeeBeans = 120;
        coffeeMachine.cups = 9;
        coffeeMachine.money = 550;

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit)");
            String action = scanner.nextLine();
            switch (action) {
                case "buy":
                    coffeeMachine.buy();
                    break;
                case "fill":
                    coffeeMachine.fill();
                    break;
                case "take":
                    coffeeMachine.take();
                    break;
                case "remaining":
                    status();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    break;
            }
        }


    }

    public static void status() {
        System.out.println("The coffee machine has:\n" +
                water + " ml of water\n" +
                milk + " ml of milk\n" +
                cofeeBeans + " g of coffee beans\n" +
                cups + " disposable cups\n" +
                "$" + money + " of money");
    }

    public void buy() {
        System.out.println("What do you want to buy? 1- espresso, 2 - latte, 3 - cappuccino:");
        String order = scanner.nextLine();
        switch (order) {
            case "1":
                makeEspresso();
                break;
            case "2":
                makeLatte();
                break;
            case "3":
                makeCappuccino();
                break;
            default:
                break;
        }

    }

    public void makeEspresso() {
        if (water >= 250 && cofeeBeans >= 16) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 250;
            cofeeBeans -= 16;
            money += 4;
            cups -= 1;
        } else {
            if (water < 250) {
                System.out.println("Sorry, not enough water!");
            } else
                System.out.println("Sorry, not enough coffee beans");

        }


    }

    public static void makeLatte() {
        if (water >= 350 && milk >= 75 && cofeeBeans >= 20) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 350;
            milk -= 75;
            cofeeBeans -= 20;
            money += 7;
            cups -= 1;
        } else {
            if (water < 350) {
                System.out.println("Sorry, not enough water!");
            } else if (milk < 75) {
                System.out.println("Sorry, not enough milk!");
            } else if (cofeeBeans < 20) {
                System.out.println("Sorry, not enough coffee Beans!");

            } else {
                System.out.println("No cups!");
            }

        }

    }

    public static void makeCappuccino() {
        if (water >= 200 && milk >= 100 && cofeeBeans >= 12) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 200;
            milk -= 100;
            cofeeBeans -= 12;
            money += 6;
            cups -= 1;
        } else {
            if (water < 200) {
                System.out.println("Sorry, not enough water!");
            } else if (milk < 100) {
                System.out.println("Sorry, not enough milk!");
            } else if (cofeeBeans < 12) {
                System.out.println("Sorry, not enough coffee Beans!");

            } else {
                System.out.println("No cups!");
            }
        }
    }

    public static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        cofeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cups += scanner.nextInt();

    }
    public static void take() {
        System.out.println("I gave you $" + money);
        money -= money;
    }

}

enum State {
    Action, Coffee
}

