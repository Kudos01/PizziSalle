import Controller.Controller;
import DAO.PizzaDAO;
import model.Pizza;
import model.PizzaBuilder;

import static model.Pizza.Crust.Thin;

public class Main {

    public static void main(String[] args) {
        System.out.println("Initializing...");

        System.out.println("Initialization Complete");

        Controller c = new Controller();

        /*
        PizzaDAO pdao = new PizzaDAO();

        PizzaBuilder pb = new PizzaBuilder();
        pb.setPizza_name("Carbonara");
        pb.namedPizzaBuilder("Carbonara");
        pb.setDough("Thin");

        System.out.println(pdao.getPizzaIDIfExists(pb.buildPizza()));
        pdao.save(pb.buildPizza());
        */
        c.runApplication();
    }

}
