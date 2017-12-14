package hu.iit.uni.miskolc.bontozd.exceptions;

public class EmailIsIncorrectException extends Exception {

    public EmailIsIncorrectException(String s){
        super("The following email address is incorrect" +s);
    }

}
