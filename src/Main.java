import Controller.Controller;

    /*
        Design patters Used:
        Singleton for DB connection (DBConnection)
        Builder for pizzas (PizzaBuilder)
        Facade for hiding the pizza building complexity (PizzaBuilder)
        DAO patterns for the DB (DAO Package)
	    MVC (Project)

	    MVC Is used since I separated the project model, view and Controller classes.
	    This is evident when looking at how the controller interacts with the view. If outputting to the screen
	    is necesary, functions from the MenuView class are calle. This way, the project is not coupled to a
	    specific display implementation (Like the terminal in this case), and can, for example, have methods
	    added in the future that show alerts when the input is wrong, instead of having to manually change the
	    controller class to the new implementation

        DB Tables:
        Pizzas
        Orders
        Customers
     */

public class Main {

    public static void main(String[] args) {
        System.out.println("Initializing...");

        System.out.println("Initialization Complete");

        Controller c = new Controller();
        c.runApplication();
    }

}
