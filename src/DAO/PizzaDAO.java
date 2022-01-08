package DAO;

import model.Pizza;
import model.PizzaBuilder;
import view.MenuView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class PizzaDAO implements DAO<Pizza> {

    private final DBConnection db = DBConnection.getInstance();
    private final MenuView mv = new MenuView();

    public PizzaDAO(){}

    @Override
    public Optional<Pizza> get(long id) {
        return Optional.empty();
    }

    @Override
    public void save(Pizza pizza) {
        Statement stmt = null;
        StringBuilder query = new StringBuilder();

        try {
            stmt = db.conn.createStatement();

            query.append("INSERT INTO pizzas(pizza_name, ingredients_list, crust) VALUES('")
                    .append(pizza.getPizza_name())
                    .append("' , '")
                    .append(pizza.getIngredientsAsString())
                    .append("' , '")
                    .append(pizza.getCrust())
                    .append("')");

            stmt.execute(query.toString());
            stmt.close();

        } catch (SQLException e) {
            mv.printString("Pizza could not be added to the DB");
            e.printStackTrace();
        }
    }

    @Override
    public void update(Pizza pizza, String[] params) {

    }

    @Override
    public void delete(Pizza pizza) {

    }

    public int getPizzaIDIfExists(Pizza pizza) {
        Statement stmt = null;
        StringBuilder query = new StringBuilder();

        int id = -1;

        try {
            stmt = db.conn.createStatement();

            //SELECT * FROM pizzas WHERE pizza_name = '' AND ingredients_list = '' AND crust = ''

            query.append("SELECT * FROM pizzas WHERE pizza_name = '")
                    .append(pizza.getPizza_name())
                    .append("' AND ingredients_list = '")
                    .append(pizza.getIngredientsAsString())
                    .append("' AND crust = '")
                    .append(pizza.getCrust())
                    .append("'");

            ResultSet rs = stmt.executeQuery(query.toString());

            // get the pizza with that ID if it exists
            // There should be at most 1
            while(rs.next()) {
                id = Integer.parseInt(rs.getString(1));    //First Column
            }

            stmt.close();

        } catch (SQLException e) {
            //mv.printString("Pizza could not be added to the DB");
            e.printStackTrace();
        }
        return id;
    }

}
