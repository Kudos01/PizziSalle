package Model;

import Model.constants.NamedPizza;
import Model.constants.Topping;

import java.util.ArrayList;
import static Model.constants.Topping.*;

/*
    This class uses both the builder and the facade patterns.
    It uses the builder pattern since it creates unique objects that will later "exist" by themselves.
    It provides all the methods to shape and finally construct the object in question (Pizza).

    It is also a facade class since it provides functionality that would otherwise need to be done by the caller class.
    It provides the namedPizzaBuilder method that will build a named pizza and return the builder, so that the caller
    can simply call this method without needing to tediously add all the ingredients specified by a particular pizza
 */

public class PizzaBuilder{

    public static final int MAX_INGREDIENTS = 10;

    private String pizza_name;
    private Pizza.Crust crust;
    private ArrayList<Topping> toppings = new ArrayList<Topping>();

    public PizzaBuilder(){}

    public PizzaBuilder namedPizzaBuilder(String pizza_name) throws IllegalArgumentException{

        NamedPizza name = NamedPizza.valueOf(pizza_name);

        switch (name){
            case Basic:
                //Here we return an empty pizza builder since Basic Pizza has no extra toppings
                break;

            case Hawaiian:
                this
                        .addTopping(Ham)
                        .addTopping(Pineapple);
                break;

            case Bacon_Crispy:
                this
                        .addTopping(Ham)
                        .addTopping(Chicken)
                        .addTopping(Bacon);
                break;

            case American:
                this
                        .addTopping(Frankfurt)
                        .addTopping(Bacon)
                        .addTopping(Egg);
                break;

            case Traviata:
                this
                        .addTopping(Bacon)
                        .addTopping(Sausage)
                        .addTopping(Onion);
                break;

            case Burger:
                this
                        .addTopping(Miniburgers)
                        .addTopping(Egg)
                        .addTopping(Bacon)
                        .addTopping(Onion);
                break;

            case Castellera:
                this
                        .addTopping(Onion)
                        .addTopping(Tuna)
                        .addTopping(Topping.Pepperoni)
                        .addTopping(Olives);
                break;

            case Cowboy:
                this
                        .addTopping(BBQ_Sauce)
                        .addTopping(Cheddar)
                        .addTopping(Roquefort)
                        .addTopping(Bacon);
                break;

            case Texas:
                this
                        .addTopping(BBQ_Sauce)
                        .addTopping(Onion)
                        .addTopping(Tomato_slices)
                        .addTopping(Chicken);
                break;

            case Coast:
                this
                        .addTopping(Tuna)
                        .addTopping(Anchovies)
                        .addTopping(Prawns)
                        .addTopping(Pineapple);
                break;

            case BBQ:
                this
                        .addTopping(BBQ_Sauce)
                        .addTopping(Beef)
                        .addTopping(Bacon)
                        .addTopping(Chicken);
                break;

            case Diablo:
                this
                        .addTopping(Ham)
                        .addTopping(Beef)
                        .addTopping(Bacon)
                        .addTopping(Chicken);
                break;

            case Carbonara:
                this
                        .addTopping(Carbonara_sauce)
                        .addTopping(Bacon)
                        .addTopping(Onion)
                        .addTopping(Mushrooms);
                break;

            case Spanish:
                this
                        .addTopping(Jamon_serrano)
                        .addTopping(Brie)
                        .addTopping(Olives)
                        .addTopping(Mushrooms);
                break;

            case Four_Cheeses:
                this
                        .addTopping(Mozzarella)
                        .addTopping(Emmental)
                        .addTopping(Roquefort)
                        .addTopping(Cheddar);
                break;

            case Pepperoni:
                this
                        .addTopping(Topping.Pepperoni)
                        .addTopping(Ham)
                        .addTopping(Beef)
                        .addTopping(Bacon);
                break;

            case Vegetal:
                this
                        .addTopping(Onion)
                        .addTopping(Bell_peppers)
                        .addTopping(Tomato_slices)
                        .addTopping(Artichoke)
                        .addTopping(Mushrooms);
                break;

            case Barcelona:
                this
                        .addTopping(Onion)
                        .addTopping(Beef)
                        .addTopping(Mushrooms)
                        .addTopping(Chicken)
                        .addTopping(Olives);
                break;

            case Girona:
                this
                        .addTopping(Beef)
                        .addTopping(Ham)
                        .addTopping(Mushrooms)
                        .addTopping(Chicken)
                        .addTopping(Olives);
                break;

            case Tarragona:
                this
                        .addTopping(Tuna)
                        .addTopping(Prawns)
                        .addTopping(Onion)
                        .addTopping(Ham)
                        .addTopping(Olives);
                break;

            case Lleida:
                this
                        .addTopping(BBQ_Sauce)
                        .addTopping(Beef)
                        .addTopping(Chicken)
                        .addTopping(Mushrooms)
                        .addTopping(Olives);
                break;

            case Six_Cheeses:
                this
                        .addTopping(Mozzarella)
                        .addTopping(Goat_cheese)
                        .addTopping(Brie)
                        .addTopping(Emmental)
                        .addTopping(Roquefort)
                        .addTopping(Cheddar);
                break;

            case Mallorca:
                this
                        .addTopping(Goat_cheese)
                        .addTopping(Emmental)
                        .addTopping(Cheddar)
                        .addTopping(Brie)
                        .addTopping(Sobrasada)
                        .addTopping(Olives);
                break;

            case Carbonara_Deluxe:
                this
                        .addTopping(Carbonara_sauce)
                        .addTopping(Bacon)
                        .addTopping(Onion)
                        .addTopping(Mushrooms)
                        .addTopping(Goat_cheese)
                        .addTopping(Honey);
                break;
        }

        return this;
    }

    public void setPizza_name(String pizza_name) {
        this.pizza_name = pizza_name;
    }

    public PizzaBuilder setDough(String dough) throws IllegalArgumentException{
        this.crust = Pizza.Crust.valueOf(dough);
        return this;
    }

    public PizzaBuilder addTopping(Topping topping){
        this.toppings.add(topping);
        return this;
    }

    public int getNumIngredients(){
        return toppings.size();
    }

    public Pizza buildPizza(){
        return new Pizza(this.pizza_name, this.toppings, this.crust);
    }
}
