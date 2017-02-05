package model.database_adapter.exceptions;

/**
 * Created by Yulo Leake on 2/4/2017.
 */
public class ConnectionIssueException extends Exception {
    public ConnectionIssueException(){}
    public ConnectionIssueException(String message){
        super(message);
    }
}
