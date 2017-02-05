package model;

/**
 * Created by Yulo Leake on 2/4/2017.
 *
 * Basic customer data
 */
public class Customer {

    private String firstName;
    private String lastName;
    private String email;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return this.lastName + ", " + this.firstName + ": " + this.email;
    }
}
