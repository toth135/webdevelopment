package hu.iit.uni.miskolc.bontozd.dao;

import hu.iit.uni.miskolc.bontozd.exceptions.UsernameNotFoundException;
import hu.iit.uni.miskolc.bontozd.model.User;
import hu.iit.uni.miskolc.bontozd.exceptions.UsernameIsOccupiedException;
import java.util.Collection;

public interface UserDAO {

    public Collection <User> readUsers();

    public User readUserByUsername(String username) throws UsernameNotFoundException;

    public void createUser(User user) throws UsernameIsOccupiedException;

    public void updateUser(User user) throws UsernameIsOccupiedException, UsernameNotFoundException;

    public void deleteUser(String username) throws UsernameNotFoundException;

}
