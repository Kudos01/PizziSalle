package Controller;

import DAO.CustomerDAO;
import DAO.OrderDAO;
import model.Customer;
import model.Order;
import model.Pizza;
import model.PizzaBuilder;
import model.constants.Delegations;
import model.constants.NamedPizza;
import model.constants.Topping;
import view.MenuView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static model.Order.Drink.Beer;


public class Controller {

    private final int DAYS = 6576;
    private final String DATE_FORMAT = "dd/MM/yyyy";
    private MenuView mv = new MenuView();
    private OrderDAO orderDAO = new OrderDAO();
    private CustomerDAO customerDAO = new CustomerDAO();

    public Controller(){

    }

    public void runApplication(){
        Customer customer = new Customer();

        boolean first_order = Objects.equals(mv.displayStringGetUserInput("First Order? (y/n): "), "y");
        mv.printSeparator();

        /*
         if existing customer, we will only ask for the phone since
         we uniquely id them with that
        */

        if(!first_order){

            String name = mv.displayStringGetUserInput("Enter Customer Name: ");
            mv.printSeparator();
            customer.setName(name);

            String phone = mv.displayStringGetUserInput("Enter Customer Phone: ");
            mv.printSeparator();
            customer.setPhone(phone);

            int customer_id = customerDAO.getCustomerIDIfExists(customer);

            //Since the customer exists they should be in the DB
            customer = customerDAO.get(customer_id).orElse(null);

            // Check just in case and ask for the info if they are not found
            if (customer == null) {
                mv.printString("Customer not found...");
                customer = askForCustomerInfo();
                customer.setFirst_order(true);
            }

        }else {
            customer = askForCustomerInfo();
            customer.setFirst_order(true);
        }

        // Pizza info
        PizzaBuilder pb = new PizzaBuilder();

        // Pizza name
        String pizza_name = mv.displayStringGetUserInput("Enter Pizza name: ");

        boolean flag = true;

        while (flag) {
            if(Objects.equals(pizza_name, Delegations.Girona.getVal())
                    || Objects.equals(pizza_name, Delegations.Barcelona.getVal())
                    || Objects.equals(pizza_name, Delegations.Tarragona.getVal())
                    || Objects.equals(pizza_name, Delegations.Lleida.getVal())){

                if(!Objects.equals(pizza_name, customer.getDelegation().getVal())){
                    // Cannot order this pizza
                    mv.printString("Cannot order this pizza.");
                    mv.printSeparator();
                    pizza_name = mv.displayStringGetUserInput("Enter Pizza name: ");
                }else{
                    flag = false;
                }
            }else{
                flag = false;
            }
        }

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
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);

        flag = true;
        while(flag){
            String drink = mv.displayStringGetUserInput("Enter Drink: ");
            try{
                boolean old_enough = false;
                if(Objects.equals(drink, Beer.getVal())){
                    long time_diff = getDateDiff(format.parse(customer.getDoB()), new Date(), TimeUnit.DAYS);
                    if (time_diff < DAYS){
                        mv.printString("Cannot order alcoholic beverages");
                        continue;
                    }
                }
                order.setDrink(drink);
                flag=false;
            }catch (IllegalArgumentException e){
                mv.printString("Drink not available, order filled with water");
                order.setDrink(Order.Drink.Water.getVal());
                break;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            mv.printSeparator();
        }

        mv.printOrder(order);

        // Send order and pizza and customer to the DB
        orderDAO.save(order);
    }

    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }

    public Customer askForCustomerInfo(){
        Customer customer = new Customer();
        boolean flag;

        // Get customer name
        String name = mv.displayStringGetUserInput("Enter Customer Name: ");
        customer.setName(name);
        mv.printSeparator();

        // Get customer phone
        String phone = mv.displayStringGetUserInput("Enter Customer Phone: ");
        customer.setPhone(phone);
        mv.printSeparator();

        // Get DoB
        flag = true;
        DateFormat format = new SimpleDateFormat(DATE_FORMAT);

        // Check DoB
        while (flag) {
            try {
                String dob = mv.displayStringGetUserInput("Enter customer date of birth (dd/MM/YYYY): ");
                // Parse to see if format is correct
                format.parse(dob);
                customer.setDoB(dob);
                flag = false;
            } catch (ParseException e) {
                mv.printString("Please insert a valid date");
            }
        }

        // Get customer address
        String address = mv.displayStringGetUserInput("Enter Customer Address: ");
        customer.setAddress(address);
        mv.printSeparator();

        flag = true;
        // Delegation
        while (flag) {
            try {
                String delegation = mv.displayStringGetUserInput("Enter Delegation: ");
                customer.setDelegation(delegation);
                flag = false;
            } catch (IllegalArgumentException e) {
                mv.printString("Please insert a valid delegation.");
            }
        }
        return customer;
    }
}
