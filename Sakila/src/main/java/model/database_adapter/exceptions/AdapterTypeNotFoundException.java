package model.database_adapter.exceptions;

/**
 * Created by Yulo Leake on 2/5/2017.
 */
public class AdapterTypeNotFoundException extends Exception {
    public AdapterTypeNotFoundException(){}
    public AdapterTypeNotFoundException(String message){
        super(message);
    }
}
