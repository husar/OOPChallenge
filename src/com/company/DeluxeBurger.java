package com.company;

public class DeluxeBurger extends Hamburger {
    public DeluxeBurger(String breadType, String meatType) {
        super(breadType, meatType, "Deluxe Burger", 8.20, 2);
    }

    @Override
    public String updateOrder(Supplement supplement) {
        setOrder(getOrder()+", " + supplement.getNameOfSupplement()+"= 0.00€");
        return getOrder();
    }

    @Override
    public void addSupplement(int count) {
        Chips chips = new Chips();
        updateOrder(chips);
        Cola cola = new Cola();
        updateOrder(cola);
    }
}
