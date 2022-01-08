package model;

import model.constants.NamedPizza;
import model.constants.Topping;

import java.util.HashSet;

public class PizzaBuilder{

    private String pizza_name;
    private Pizza.Dough dough;
    private HashSet<String> toppings = new HashSet<String>();

    public PizzaBuilder(){

    }

    public PizzaBuilder namedPizzaBuilder(String pizza_name){

        switch (pizza_name){
            case NamedPizza.Basic:
                break;
            case NamedPizza.Hawaiian:
                break;
            case NamedPizza.Bacon_Crispy:
                break;
            case NamedPizza.American:
                break;
            case NamedPizza.Traviata:
                break;
            case NamedPizza.Burger:
                break;
            case NamedPizza.Castellera:
                break;
            case NamedPizza.Cowboy:
                break;
            case NamedPizza.Texas:
                break;
            case NamedPizza.Coast:
                break;
            case NamedPizza.BBQ:
                break;
            case NamedPizza.Diablo:
                break;
            case NamedPizza.Carbonara:
                break;
            case NamedPizza.Spanish:
                break;
            case NamedPizza.Four_Cheeses:
                break;
            case NamedPizza.Pepperoni:
                break;
            case NamedPizza.Vegetal:
                break;
            case NamedPizza.Barcelona:
                break;
            case NamedPizza.Girona:
                break;
            case NamedPizza.Tarragona:
                break;
            case NamedPizza.Lleida:
                break;
            case NamedPizza.Six_Cheeses:
                break;
            case NamedPizza.Mallorca:
                break;
            case NamedPizza.Carbonara_Deluxe:
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
