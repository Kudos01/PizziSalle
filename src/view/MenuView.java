package view;

import model.Order;
import model.constants.Topping;

import java.util.Scanner;

public class MenuView {

    Scanner scanner = new Scanner(System.in);

    public MenuView(){}

    public String displayStringGetUserInput(String s){
        System.out.print(s);
        return scanner.nextLine();
    }

    public void printSeparator(){
        System.out.println();
    }

    public void printString(String s){
        System.out.println(s);
    }

    public void printOrder(Order order) {
        StringBuilder sb = new StringBuilder();

        sb.append("Customer ")
                .append(order.getCustomer().getName())
                .append("'s")
                .append(" order:")
                .append(System.lineSeparator());

        sb.append("Pizza: ")
                .append(order.getPizza().getPizza_name())
                .append(System.lineSeparator())
                .append("Ingredients: ")
                .append(System.lineSeparator());

        for (Topping ingredient :
                order.getPizza().getIngredients()) {
            sb.append(ingredient).append(System.lineSeparator());
        }

        sb.append(System.lineSeparator());

        sb.append("Crust: ")
                .append(System.lineSeparator())
                .append(order.getPizza().getCrust().getVal())
                .append(System.lineSeparator())
                .append(System.lineSeparator());

        sb.append("Drink: ")
                .append(System.lineSeparator())
                .append(order.getDrink().getVal());

        System.out.println(sb);

    }
}
