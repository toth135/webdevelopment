package hu.iit.uni.miskolc.bontozd.exceptions;

public class UsernameNotFoundException extends Exception {

    public UsernameNotFoundException(String s) {
        super("Username is not found" +s);
    }

}
