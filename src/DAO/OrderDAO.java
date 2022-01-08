package DAO;

import model.Order;
import model.PizzaBuilder;
import view.MenuView;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class OrderDAO implements DAO<Order> {

    private final DBConnection db = DBConnection.getInstance();
    private final PizzaDAO pizzaDAO = new PizzaDAO();
    private final CustomerDAO customerDAO = new CustomerDAO();

    private final MenuView mv = new MenuView();

    public OrderDAO(){}

    @Override
    public Optional<Order> get(long id) {
        return Optional.empty();
    }

    @Override
    public void save(Order order) {

        // See if pizza in this order exists

        // if it does, use ID on order table, without adding current pizza
        if(pizzaDAO.getPizzaIDIfExists(order.getPizza()) < 0){

            //add pizza and get its id in the DB
            pizzaDAO.save(order.getPizza());
        }

        //Should return id at this stage
        int pizza_id = pizzaDAO.getPizzaIDIfExists(order.getPizza());

        //Same for customer, but we dont need to query the DB
        if(order.getCustomer().isFirst_order()){
            //Add customer to the DB
            customerDAO.save(order.getCustomer());
        }

        // Get their ID
        //Should return id at this stage
        int customer_id = customerDAO.getCustomerIDIfExists(order.getCustomer());

        //Add the order to the DB
        Statement stmt = null;
        StringBuilder query = new StringBuilder();

        try {
            stmt = db.conn.createStatement();

            query.append("INSERT INTO orders(pizza_id, customer_id, drink) VALUES('")
                    .append(pizza_id)
                    .append("' , '")
                    .append(customer_id)
                    .append("' , '")
                    .append(order.getDrink().getVal())
                    .append("')");

            stmt.execute(query.toString());
            stmt.close();

        } catch (SQLException e) {
            mv.printString("Order could not be added to the DB");
            e.printStackTrace();
        }

    }

    @Override
    public void update(Order order, String[] params) {

    }

    @Override
    public void delete(Order order) {

    }
}