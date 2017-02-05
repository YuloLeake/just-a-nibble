package model.database_adapter;

import model.Customer;
import model.database_adapter.exceptions.ConnectionIssueException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yulo Leake on 2/4/2017.
 *
 * Interface for MySQL server
 */
public class MySQLAdapter implements DatabaseAdapter {

    private Connection connection;

    public MySQLAdapter() throws SQLException {
        // Wait, is it a bad idea to include user and password info like this?
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sakila?useSSL=false",
                "root",
                "password");
    }

    @Override
    public List<Customer> getCustomerWith(String lastname) throws ConnectionIssueException {
        // Not preventing SQL injection here
        return getCustomerListBasedOnQuery("SELECT first_name, last_name, email FROM customer WHERE last_name = '" + lastname + "'");
    }

    @Override
    public List<Customer> getCustomerList(int size) {
        return getCustomerListBasedOnQuery("SELECT first_name, last_name, email FROM customer LIMIT " + size);
    }

    @Override
    public void insertCustomer(Customer customer) throws ConnectionIssueException {
        try(Statement stmt = connection.createStatement()){

            stmt.executeUpdate(
                    "INSERT INTO customer (store_id, first_name, last_name, email, address_id) " +
                            "VALUES (1, '" +
                            customer.getFirstName() + "', '" +
                            customer.getLastName() + "', '" +
                            customer.getEmail() + "', " +
                            "5)");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(Customer customer) throws ConnectionIssueException {
        try(Statement stmt = connection.createStatement()) {

            stmt.executeUpdate(
                    "DELETE FROM customer WHERE first_name = '" +
                            customer.getFirstName() + "' and last_name = '" +
                            customer.getLastName() + "'");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        // Make sure to close the connection
        this.connection.close();
    }

    private List<Customer> getCustomerListBasedOnQuery(String query){
        List<Customer> customers = new ArrayList<>();
        try (Statement stmt = connection.createStatement();) {
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                customers.add(new Customer(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email")));
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

}
