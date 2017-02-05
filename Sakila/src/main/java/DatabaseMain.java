import model.Customer;
import model.database_adapter.*;
import model.database_adapter.exceptions.ConnectionIssueException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yulo Leake on 2/4/2017.
 *
 * Main driver of the example program looking into JDBC and connecting to databases
 */
public class DatabaseMain {
    public static void main(String[] args) throws SQLException {

        try(DatabaseAdapter adapter = DatabaseAdapterFactory.build("mongodb")){

            databaseFun(adapter);

        } catch (ConnectionIssueException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("This shouldn't happen...");
            e.printStackTrace();
        }
    }

    public static void databaseFun(DatabaseAdapter adapter) throws ConnectionIssueException {
        // 1. Get first 10 customers, print their info
        System.out.println("#1");
        List<Customer> customers = adapter.getCustomerList(10);
        for(Customer c : customers){
            System.out.println(c);
        }

        // 2. Get customers with last name "Smith" and print their info
        System.out.println("\n#2");
        customers = adapter.getCustomerWith("Smith");
        for(Customer c : customers){
            System.out.println(c);
        }

        // 3. Add new customers to the database
        System.out.println("\n#3");
        List<Customer> insertList = new ArrayList<Customer>(){{
            add(new Customer("Alice", "Smith", "Alice.Smith@bsac.com"));
            add(new Customer("Bob", "Smith", "Bob.Smith@bsac.com"));
            add(new Customer("Carol", "Smith", "Carol.Smith@bsac.com"));
            add(new Customer("Dan", "Smith", "Dan.Smith@bsac.com"));
            add(new Customer("Eve", "Smith", "Eve.Smith@bsac.com"));
        }};
        for(Customer c : insertList){
            adapter.insertCustomer(c);
            System.out.println("added " + c);
        }

        // 4. Get customers with last name "Smith" and print their info
        System.out.println("\n#4");
        customers = adapter.getCustomerWith("Smith");
        for(Customer c : customers){
            System.out.println(c);
        }

        // 5. Remove inserted customers
        for(Customer c : insertList){
            adapter.deleteCustomer(c);
        }
    }
}
