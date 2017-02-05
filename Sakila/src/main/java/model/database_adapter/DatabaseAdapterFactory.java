package model.database_adapter;

import model.database_adapter.exceptions.AdapterTypeNotFoundException;

import java.sql.SQLException;

/**
 * Created by Yulo Leake on 2/5/2017.
 *
 * Simple factory to get interface to database based on given string
 */
public class DatabaseAdapterFactory {

    public static DatabaseAdapter build(String type) throws SQLException, AdapterTypeNotFoundException {

        if(type.equalsIgnoreCase("mysql")){
            return new MySQLAdapter();
        } else if (type.equalsIgnoreCase("mongodb")){
            return new MongoDBAdapter();
        }
        throw new AdapterTypeNotFoundException("Adapter with type \"" + type + "\" not found");
    }
}
