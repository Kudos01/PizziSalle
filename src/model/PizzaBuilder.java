package model;

import model.constants.NamedPizza;
import model.constants.Topping;

import javax.naming.Name;
import java.util.HashMap;
import java.util.HashSet;

import static model.constants.NamedPizza.*;
import static model.constants.Topping.*;

public class PizzaBuilder{

    private String pizza_name;
    private Pizza.Dough dough;
    private HashSet<String> toppings = new HashSet<String>();

    public PizzaBuilder(){

    }

    public PizzaBuilder namedPizzaBuilder(String pizza_name){

            switch (pizza_name){
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
                            .addTopping(Pepperoni)
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
                            .addTopping(Pepperoni)
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
                            .addTopping(Basic)
                            .addTopping(Onion)
                            .addTopping(Mushrooms)
                            .addTopping(Goat_cheese)
                            .addTopping(Honey);
                    break;

                default:
                    System.out.println("A Pizza with that name does not exist.");
                    System.out.println("Returning empty builder (Basic Pizza)");
                    break;
            }

        return this;
    }

    public PizzaBuilder setDough(Pizza.Dough dough){
        this.dough = dough;
        return this;
    }

    public PizzaBuilder addTopping(String topping){
        this.toppings.add(topping);
        return this;
    }

    public Pizza buildPizza(){
        return new Pizza(this.pizza_name, this.toppings, this.dough);
    }
}
