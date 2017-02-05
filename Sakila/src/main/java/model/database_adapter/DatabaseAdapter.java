package model.database_adapter;

import model.Customer;
import model.database_adapter.exceptions.ConnectionIssueException;

import java.util.List;

/**
 * Created by Yulo Leake on 2/4/2017.
 *
 * Extends AutoClosable to allow try-with-resources (https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html)
 * Also good idea to close connections once we are done
 */
public interface DatabaseAdapter extends AutoCloseable {

    List<Customer> getCustomerWith(String lastname) throws ConnectionIssueException;

    List<Customer> getCustomerList(int limit) throws ConnectionIssueException;

    void insertCustomer(Customer customer) throws ConnectionIssueException;

    void deleteCustomer(Customer customer) throws ConnectionIssueException;

}
