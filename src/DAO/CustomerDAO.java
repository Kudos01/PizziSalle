package DAO;

import model.Customer;
import view.MenuView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class CustomerDAO implements DAO<Customer>{

    private final DBConnection db = DBConnection.getInstance();
    private final MenuView mv = new MenuView();

    public CustomerDAO(){}

    @Override
    public Optional<Customer> get(long id) {
        Statement stmt = null;
        StringBuilder query = new StringBuilder();

        Customer c = new Customer();

        try {
            stmt = db.conn.createStatement();

            //SELECT * FROM pizzas WHERE pizza_name = '' AND ingredients_list = '' AND crust = ''

            query.append("SELECT * FROM customers WHERE customer_id = '")
                    .append(id)
                    .append("'");

            ResultSet rs = stmt.executeQuery(query.toString());

            // get the pizza with that ID if it exists
            // There should be at most 1
            while(rs.next()) {
                c.setName(rs.getString(2)); //Second Column
                c.setPhone(rs.getString(3)); //Third Column
                c.setDoB(rs.getString(4)); //Fourth Column
                c.setDelegation(rs.getString(5)); //Fifth Column
                c.setAddress(rs.getString(6)); //Sixth Column
            }

            c.setFirst_order(false);

            stmt.close();

        } catch (SQLException e) {
            //mv.printString("Pizza could not be added to the DB");
            e.printStackTrace();
        }

        return Optional.of(c);
    }

    @Override
    public void save(Customer customer) {
        Statement stmt = null;

        StringBuilder query = new StringBuilder();

        try {
            stmt = db.conn.createStatement();

            query.append("INSERT INTO customers(name, phone, dob, delivery_address, delegation) VALUES('")
                    .append(customer.getName())
                    .append("' , '")
                    .append(customer.getPhone())
                    .append("' , '")
                    .append(customer.getDoB())
                    .append("' , '")
                    .append(customer.getAddress())
                    .append("' , '")
                    .append(customer.getDelegation())
                    .append("')");

            stmt.execute(query.toString());
            stmt.close();

        } catch (SQLException e) {
            mv.printString("Customer could not be added to the DB");
            e.printStackTrace();
        }
    }

    public int getCustomerIDIfExists(Customer customer) {
        Statement stmt = null;
        StringBuilder query = new StringBuilder();

        int id = -1;

        try {
            stmt = db.conn.createStatement();

            //SELECT * FROM pizzas WHERE pizza_name = '' AND ingredients_list = '' AND crust = ''

            query.append("SELECT * FROM customers WHERE name = '")
                    .append(customer.getName())
                    .append("' AND phone = '")
                    .append(customer.getPhone())
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


    @Override
    public void update(Customer customer, String[] params) {

    }

    @Override
    public void delete(Customer customer) {

    }
}
