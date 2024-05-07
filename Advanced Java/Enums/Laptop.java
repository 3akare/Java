package Enums;

public enum Laptop {
    MacBook(2000), Dell(1800), HP, Lenovo(400);

    private int price;

    Laptop() {
        this.price = 0;
    }

    Laptop(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
