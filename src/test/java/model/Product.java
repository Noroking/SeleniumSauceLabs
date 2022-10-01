package model;

public class Product {
    String name;
    double price;

    public Product (String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String GetName () {
        return name;
    }
    public double GetPrice() {
        return price;
    }
}
