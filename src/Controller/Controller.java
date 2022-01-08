package Controller;

import model.Customer;
import model.Order;
import model.Pizza;
import model.PizzaBuilder;
import model.constants.NamedPizza;
import model.constants.Topping;
import view.MenuView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;

public class Controller {

    private MenuView mv = new MenuView();

    public Controller(){

    }

    public void runApplication(){
        Customer customer = new Customer();

        String existing_customer = mv.displayStringGetUserInput("Existing customer? (y/n): ");
        customer.setFirst_order(Objects.equals(existing_customer, "y"));
        mv.printSeparator();

        /*
         if existing customer, we will only ask for the phone since
         we uniquely id them with that
        */

        if(customer.isFirst_order()){

            String name = mv.displayStringGetUserInput("Enter Customer Name: ");
            mv.printSeparator();

            String phone = mv.displayStringGetUserInput("Enter Customer Phone: ");
            mv.printSeparator();

            mv.printString("Searching for customer...");
            //TODO, Find customer in DB

        }else{
            // Get customer name
            String name = mv.displayStringGetUserInput("Enter Customer Name: ");
            customer.setName(name);
            mv.printSeparator();

            // Get customer phone
            String phone = mv.displayStringGetUserInput("Enter Customer Phone: ");
            customer.setPhone(phone);
            mv.printSeparator();

            // Get DoB
            boolean flag = true;
            DateFormat format = new SimpleDateFormat("dd/MMMM/yyyy", Locale.UK);

            // Check DoB
            while(flag){
                try {
                    String dob = mv.displayStringGetUserInput("Enter customer date of birth (dd/MMMM/YYYY): ");
                    customer.setDob(format.parse(dob));
                    flag = false;
                } catch (ParseException e) {
                    mv.printString("Please insert a valid date");
                }
            }

            // Get customer address
            String address = mv.displayStringGetUserInput("Enter Customer Address: ");
            customer.setAddress(address);
            mv.printSeparator();

            // Delegation
            String delegation = mv.displayStringGetUserInput("Enter Delegation: ");
            customer.setDelegation(delegation);
            mv.printSeparator();

            // Pizza info
            PizzaBuilder pb = new PizzaBuilder();

            // Pizza name
            String pizza_name = mv.displayStringGetUserInput("Enter Pizza name: ");
            pb.setPizza_name(pizza_name);
            try{
                pb.namedPizzaBuilder(pizza_name);
            }catch (IllegalArgumentException e){
                mv.printString("Pizza with that name does not exist. Using basic pizza.");
                pb.namedPizzaBuilder(NamedPizza.Basic.getVal());
            }
            mv.printSeparator();

            // Extra ingredients
            boolean extra_ingredient_flag = true;
            String extra_ingredients_choice = mv.displayStringGetUserInput("Any extra ingredients? (y/n): ");
            extra_ingredient_flag = Objects.equals(extra_ingredients_choice, "y");
            mv.printSeparator();

            // Loop while extra ingredients need to be added
            while(extra_ingredient_flag){

                try{
                    String ingredient = mv.displayStringGetUserInput("Topping/Ingredient Name: ");
                    if (pb.getNumIngredients() < PizzaBuilder.MAX_INGREDIENTS){
                        pb.addTopping(Topping.valueOf(ingredient));
                    } else {
                        mv.printString("Too many ingredients on the pizza. Ingredient not added.");
                        extra_ingredient_flag = false;
                        break;
                    }

                    extra_ingredients_choice = mv.displayStringGetUserInput("Any more extra ingredients/toppings? (y/n): ");
                    extra_ingredient_flag = Objects.equals(extra_ingredients_choice, "y");
                    mv.printSeparator();

                }catch (IllegalArgumentException e){
                    mv.printString("Topping not available, topping not added");
                }
            }

            // Dough
            String dough = mv.displayStringGetUserInput("Enter type of dough: ");
            try{
                pb.setDough(dough);
            }catch (IllegalArgumentException e){
                mv.printString("Dough not available, using Original dough");
                pb.setDough(Pizza.Crust.Original.getVal());
            }
            mv.printSeparator();

            // Build Pizza Object
            Pizza pizza = pb.buildPizza();

            Order order = new Order(pizza, customer);

            // Drink
            String drink = mv.displayStringGetUserInput("Enter Drink: ");
            try{
                order.setDrink(drink);
            }catch (IllegalArgumentException e){
                mv.printString("Drink not available, order filled with water");
                order.setDrink(Order.Drink.Water.getVal());
            }
            mv.printSeparator();

            mv.printOrder(order);

            //TODO, send order and pizza and customer to the DB
        }
    }
}
