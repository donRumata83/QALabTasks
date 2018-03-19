package application;

import application.enums.UserData;

import java.util.Random;

public class Good {
    private String name;
    private int price;
    private int amount;

    public Good() {
        this.name = UserData.NEWGOOD.getData() + new Random().nextInt(100);
        this.price = new Random().nextInt(100);
        this.amount = new Random().nextInt(100);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
