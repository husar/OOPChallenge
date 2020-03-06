package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Hamburger {
    private String name;
    private String breadType;
    private String meatType;
    private double price;
    //private int countOfAddition;
    private String order;

    public Hamburger(String breadType, String meatType) {
        this.name = "Base burger";
        this.price = 3.80;
        if (breadType.equals("cereal") || breadType.equals("base") || breadType.equals("chilli")){
            this.breadType = breadType;
        }else {
            this.breadType = "base";
        }
        if (meatType.equals("chicken") || meatType.equals("beef") || meatType.equals("pork")) {
            this.meatType = meatType;
        }else {
            this.meatType = "without";
        }
        order = name +" with "+this.breadType+" bread and "+this.meatType + " meat";/**zakladne info o hamburgeri*/
        //countOfAddition = 0;/**pocet doplnenych surovin*/
        addSupplement(4);
    }

    public Hamburger(String breadType, String meatType, String name, double price, int countOfAdditions) {
        this.name = name;
        this.price = price;
        if (breadType.equals("cereal") || breadType.equals("base") || breadType.equals("chilli")){
            this.breadType = breadType;
        }else {
            this.breadType = "base";
        }
        if (meatType.equals("chicken") || meatType.equals("beef") || meatType.equals("pork")) {
            this.meatType = meatType;
        }else {
            this.meatType = "without";
        }
        order = name +" with "+this.breadType+" bread and "+this.meatType + " meat";/**zakladne info o hamburgeri*/
        //countOfAddition = 0;/**pocet doplnenych surovin*/
        addSupplement(countOfAdditions);
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getBreadType() {
        return breadType;
    }

    public String getMeatType() {
        return meatType;
    }

    public String getOrder() {
        return order;
    }

    public String updateOrder(Supplement supplement){/**metoda na upravu stringu na blocek*/
        order =  getOrder()+", " + supplement.getNameOfSupplement()+"= "+String.format("%.2f", supplement.getPrice())+"€";
        return order;
    }

    public String getFullOrder(){/**vypise celkovu objednavku hamburgeru*/
//        System.out.println(order);
//        System.out.println("SUM: "+String.format("%.2f", price)+"€\n");
        return order+"\n"+"SUM: "+String.format("%.2f", price)+"€\n";
    }

    public double getPrice() {
        return price;
    }

    public void addSupplement(int count){/**pridavanie surovin*/
        boolean enough = false;
        int countOfAddition = 0;
        while (!enough && countOfAddition < count) {
            System.out.println("Please select you're addition:\n1.Carrot\n2.Chips\n3.Cola\n4.Corn\n5.Cucumber\n6.ketchup\n7.Majonese" +
                    "\n8.Olive\n9.Salat\n10.Tomato\nIf you have enough supplements select other number");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        Carrot carrot = new Carrot();
                        updateOrder(carrot);
                        price += carrot.getPrice();
                        countOfAddition++;
                        break;
                    case 2:
                        Chips chips = new Chips();
                        updateOrder(chips);
                        price += chips.getPrice();
                        countOfAddition++;
                        break;
                    case 3:
                        Cola cola = new Cola();
                        updateOrder(cola);
                        price += cola.getPrice();
                        countOfAddition++;
                        break;
                    case 4:
                        Corn corn = new Corn();
                        updateOrder(corn);
                        price += corn.getPrice();
                        countOfAddition++;
                        break;
                    case 5:
                        Cucumber cucumber = new Cucumber();
                        updateOrder(cucumber);
                        price += cucumber.getPrice();
                        countOfAddition++;
                        break;
                    case 6:
                        Ketchup ketchup = new Ketchup();
                        updateOrder(ketchup);
                        price += ketchup.getPrice();
                        countOfAddition++;
                        break;
                    case 7:
                        Majonese majonese = new Majonese();
                        updateOrder(majonese);
                        price += majonese.getPrice();
                        countOfAddition++;
                        break;
                    case 8:
                        Olive olive = new Olive();
                        updateOrder(olive);
                        price += olive.getPrice();
                        countOfAddition++;
                        break;
                    case 9:
                        Salat salat = new Salat();
                        updateOrder(salat);
                        price += salat.getPrice();
                        countOfAddition++;
                        break;
                    case 10:
                        Tomato tomato = new Tomato();
                        updateOrder(tomato);
                        price += tomato.getPrice();
                        countOfAddition++;
                        break;
                    default:
                        enough = true;
                        break;
                }
            }else {
                enough = true;
                break;
            }
        }
    }

}
