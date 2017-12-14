package hu.iit.uni.miskolc.bontozd.exceptions;

public class InvalidPasswordException extends Exception {

    public InvalidPasswordException(String s){
        super("The following password is invalid" +s);
    }

}
