package model.database_adapter;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import model.Customer;
import model.database_adapter.exceptions.ConnectionIssueException;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Yulo Leake on 2/5/2017.
 *
 * Interface for MongoDB server
 * Based on MySQL's sakila database (found http://guyharrison.squarespace.com/blog/2015/3/23/sakila-sample-schema-in-mongodb.html)
 *
 * If we want to use JDBC Driver, see http://www.unityjdbc.com/mongojdbc/mongo_jdbc.php
 */
public class MongoDBAdapter implements DatabaseAdapter {

    private MongoClient client;
    private MongoDatabase db;
    private MongoCollection<Document> collection;

    public MongoDBAdapter(){

        this.client = new MongoClient("localhost", 27017);
        this.db = client.getDatabase("sakila");
        this.collection = db.getCollection("customers");

    }

    @Override
    public List<Customer> getCustomerWith(String lastname) throws ConnectionIssueException {
        // MongoDB is case sensitive, so need to use regex to do case insensitive stuff
        BasicDBObject caseInsensitiveQuery = new BasicDBObject();
        caseInsensitiveQuery.put("Last Name", Pattern.compile(lastname, Pattern.CASE_INSENSITIVE));
        return getCustomerListBasedOnQuery(collection.find(caseInsensitiveQuery).iterator());
    }

    @Override
    public List<Customer> getCustomerList(int limit) throws ConnectionIssueException {
        return getCustomerListBasedOnQuery(collection.find().limit(10).iterator());
    }

    @Override
    public void insertCustomer(Customer customer) throws ConnectionIssueException {
        Document doc = new Document("First Name", customer.getFirstName())
                .append("Last Name", customer.getLastName());
        collection.insertOne(doc);
    }

    @Override
    public void deleteCustomer(Customer customer) throws ConnectionIssueException {
        // MongoDB is case sensitive, so need to use regex to do case insensitive stuff
        BasicDBObject lastnameCheck = new BasicDBObject();
        lastnameCheck.put("Last Name", Pattern.compile(customer.getLastName(), Pattern.CASE_INSENSITIVE));
        BasicDBObject firstnameCheck = new BasicDBObject();
        firstnameCheck.put("First Name", Pattern.compile(customer.getFirstName(), Pattern.CASE_INSENSITIVE));

        collection.deleteOne(Filters.and(lastnameCheck, firstnameCheck));
    }

    @Override
    public void close() throws Exception {
        // Make sure to close the client
        this.client.close();
    }

    private List<Customer> getCustomerListBasedOnQuery(MongoCursor<Document> cursor){
        List<Customer> customers = new ArrayList<>();

        while(cursor.hasNext()){
            Document doc = cursor.next();
            customers.add(
                    new Customer(
                            doc.getString("First Name"),
                            doc.getString("Last Name")
                            ,"NO EMAIL FOUND"));
        }

        cursor.close();
        return customers;
    }
}
