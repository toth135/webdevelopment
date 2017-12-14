import hu.iit.uni.miskolc.bontozd.dao.UserDAO;
import hu.iit.uni.miskolc.bontozd.dao.json.UserDAOJSON;
import hu.iit.uni.miskolc.bontozd.exceptions.UsernameIsOccupiedException;
import hu.iit.uni.miskolc.bontozd.model.User;

import java.util.Collection;

public class proba {

    public static void main(String[] args) {

        UserDAO dao = new UserDAOJSON();
        try {
            User pistike = new User("pistike", "asd123", "Kiss", "Pistike", "pistike12@gmail.com");
            dao.createUser(pistike);
        } catch (UsernameIsOccupiedException e) {
            e.printStackTrace();
        }

        Collection<User> users = dao.readUsers();
    }
}