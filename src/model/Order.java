package model;

public class Order {

    private Pizza pizza;
    private Customer customer;
    private Drink drink;

    public enum Drink {
        Water("Water"),
        Soda("Soda"),
        Beer("Beer");

        private final String val;

        Drink(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }
    }

    public Order(Pizza pizza, Customer customer) {
        this.pizza = pizza;
        this.customer = customer;
    }

    public void setDrink(String drink) throws IllegalArgumentException{
        this.drink = Drink.valueOf(drink);
    }

    public Pizza getPizza() {
        return pizza;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Drink getDrink() {
        return drink;
    }
}
