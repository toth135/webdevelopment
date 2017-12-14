package hu.iit.uni.miskolc.bontozd.service;

import hu.iit.uni.miskolc.bontozd.exceptions.UsernameIsOccupiedException;
import hu.iit.uni.miskolc.bontozd.exceptions.UsernameNotFoundException;
import hu.iit.uni.miskolc.bontozd.model.Login;
import hu.iit.uni.miskolc.bontozd.model.User;

import java.util.Collection;

public interface UserService {

    public void addUser(User user) throws UsernameIsOccupiedException;

    public void removeUser(String username) throws UsernameNotFoundException;

    public void updateUser(User user) throws UsernameNotFoundException, UsernameIsOccupiedException;

    public Collection <User> getAllUser();

    public User getUserByUsername(String username) throws UsernameNotFoundException;

    User validateUser(Login login);

    void register(User user);
}
