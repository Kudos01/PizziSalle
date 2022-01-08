package model;

import java.util.HashMap;
import java.util.HashSet;

public class Pizza {
    private String pizza_name;
    private HashSet<Topping> ingredients;
    private Dough crust;

    protected enum Dough{
        Original, Thin, Sicilian
    }

    protected enum Topping{
        Ham,
        Pineapple,
        Chicken,
        Bacon,
        Frankfurt,
        Egg,
        Sausage,
        Onion,
        Miniburgers,
        Tuna,
        Peperoni,
        Olives,
        BBQ_Sauce,
        Cheddar,
        Roquefort,
        Tomato_slices,
        Anchovies,
        Prawns,
        Beef,
        Carbonara_sauce,
        Mushrooms,
        Mozzarella,
        Emmental,
        Bell_peppers,
        Artichoke,
        Brie,
        Goat_Cheese,
        Sobrasada,
        Honey
    }

    public Pizza(String pizza_name, HashSet<Topping> ingredients, Dough crust) {
        this.pizza_name = pizza_name;
        this.ingredients = ingredients;
        this.crust = crust;
    }

    public String getPizza_name() {
        return pizza_name;
    }

    public HashSet<Topping> getIngredients() {
        return ingredients;
    }

    public Dough getCrust() {
        return crust;
    }

    public void setPizza_name(String pizza_name) {
        this.pizza_name = pizza_name;
    }

    public void setIngredients(HashSet<Topping> ingredients) {
        this.ingredients = ingredients;
    }

    public void setCrust(Dough crust) {
        this.crust = crust;
    }
}
