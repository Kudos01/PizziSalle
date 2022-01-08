package model;

import model.constants.NamedPizzas;

import java.util.HashSet;

public class PizzaBuilder{

    private String pizza_name;
    private Pizza.Dough dough;
    private HashSet<Pizza.Topping> toppings = new HashSet<Pizza.Topping>();

    public PizzaBuilder(){

    }

    public PizzaBuilder namedPizzaBuilder(String pizza_name){

        switch (pizza_name){
            case NamedPizzas.Basic:
                break;
            case NamedPizzas.Hawaiian:
                break;
            case NamedPizzas.Bacon_Crispy:
                break;
            case NamedPizzas.American:
                break;
            case NamedPizzas.Traviata:
                break;
            case NamedPizzas.Burger:
                break;
            case NamedPizzas.Castellera:
                break;
            case NamedPizzas.Cowboy:
                break;
            case NamedPizzas.Texas:
                break;
            case NamedPizzas.Coast:
                break;
            case NamedPizzas.BBQ:
                break;
            case NamedPizzas.Diablo:
                break;
            case NamedPizzas.Carbonara:
                break;
            case NamedPizzas.Spanish:
                break;
            case NamedPizzas.Four_Cheeses:
                break;
            case NamedPizzas.Pepperoni:
                break;
            case NamedPizzas.Vegetal:
                break;
            case NamedPizzas.Barcelona:
                break;
            case NamedPizzas.Girona:
                break;
            case NamedPizzas.Tarragona:
                break;
            case NamedPizzas.Lleida:
                break;
            case NamedPizzas.Six_Cheeses:
                break;
            case NamedPizzas.Mallorca:
                break;
            case NamedPizzas.Carbonara_Deluxe:
                break;
        }

        return this;
    }

    public PizzaBuilder setDough(Pizza.Dough dough){
        this.dough = dough;
        return this;
    }

    public PizzaBuilder addTopping(Pizza.Topping topping){
        this.toppings.add(topping);
        return this;
    }

    public Pizza buildPizza(){
        return new Pizza(this.pizza_name, this.toppings, this.dough);
    }
}
