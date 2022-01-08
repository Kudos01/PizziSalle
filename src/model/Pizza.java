package model;

import model.constants.Topping;
import java.util.HashSet;

public class Pizza {
    private String pizza_name;
    private HashSet<String> ingredients;
    private String crust;

    public Pizza(String pizza_name, HashSet<String> ingredients, String crust) {
        this.pizza_name = pizza_name;
        this.ingredients = ingredients;
        this.crust = crust;
    }

    public String getPizza_name() {
        return pizza_name;
    }

    public HashSet<String> getIngredients() {
        return ingredients;
    }

    public Dough getCrust() {
        return crust;
    }

    public void setPizza_name(String pizza_name) {
        this.pizza_name = pizza_name;
    }

    public void setIngredients(HashSet<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setCrust(Dough crust) {
        this.crust = crust;
    }
}
