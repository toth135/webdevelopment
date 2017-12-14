package hu.iit.uni.miskolc.bontozd.exceptions;

public class UsernameIsOccupiedException extends Exception {

    public UsernameIsOccupiedException(String s) {
        super("The following username is occupied" +s);
    }

}
