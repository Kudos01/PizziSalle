package model;
import model.constants.Topping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Pizza {
    private String pizza_name;
    private ArrayList<Topping> ingredients;
    private Crust crust;

    public enum Crust {
        Original("Original"),
        Thin("Thin"),
        Sicilian("Sicilian");

        private final String val;

        Crust(String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }
    }

    public Pizza(String pizza_name, ArrayList<Topping> ingredients, Crust crust) {
        this.pizza_name = pizza_name;
        this.ingredients = ingredients;
        this.crust = crust;
    }

    public String getPizza_name() {
        return pizza_name;
    }

    public ArrayList<Topping> getIngredients() {
        return ingredients;
    }

    public Crust getCrust() {
        return crust;
    }

    public void setPizza_name(String pizza_name) {
        this.pizza_name = pizza_name;
    }

    public void setIngredients(ArrayList<Topping> ingredients) {
        this.ingredients = ingredients;
    }

    public void setCrust(Crust crust) {
        this.crust = crust;
    }
}
