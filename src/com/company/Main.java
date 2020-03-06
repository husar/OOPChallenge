package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double price = 0;
        String completOrder = "";
        boolean enough = false;
        while (!enough) {
            System.out.println("Hello welcome in Bills Burger!\nPlease choose your burger.\nChoose:\n1.Base Burger\n" +
                    "2.Health Burger\n3.DeluxeBurger\nIf you don't want anything else press any other number");
            if (scanner.hasNextInt()) {
                int typeOfBurger = scanner.nextInt();
                scanner.nextLine();
                switch (typeOfBurger) {
                    case 1:
                        Hamburger hamburger = new Hamburger(chooseBreadType(), chooseMeat());
                        price += hamburger.getPrice();
                        completOrder = completOrder + hamburger.getFullOrder();
                        break;
                    case 2:
                        HealthBurger healthBurger = new HealthBurger();
                        price += healthBurger.getPrice();
                        completOrder = completOrder + healthBurger.getFullOrder();
                        break;
                    case 3:
                        DeluxeBurger deluxeBurger = new DeluxeBurger(chooseBreadType(), chooseMeat());
                        price += deluxeBurger.getPrice();
                        completOrder = completOrder + deluxeBurger.getFullOrder();
                        break;
                    default:
                        enough = true;
                        break;
                }
            }
            else{
                enough =true;
                System.out.println("Good bye!");
            }
            System.out.println(completOrder);
            System.out.println("Total SUM: " + String.format("%.2f", price) + "€");
        }
    }
    public static String chooseBreadType(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose bread type:\n(base, cereal, or chilli)");
        String breadType = scanner.nextLine();
        return breadType;
    }

    public static String chooseMeat(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose meat type:\n(chicken, beef, pork)");
        String meatType = scanner.nextLine();
        return meatType;
    }
}
