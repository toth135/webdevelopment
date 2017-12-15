package hu.iit.uni.miskolc.bontozd.service.impl;

import hu.iit.uni.miskolc.bontozd.dao.UserDAO;
import hu.iit.uni.miskolc.bontozd.exceptions.UsernameIsOccupiedException;
import hu.iit.uni.miskolc.bontozd.exceptions.UsernameNotFoundException;
import hu.iit.uni.miskolc.bontozd.model.Login;
import hu.iit.uni.miskolc.bontozd.model.User;

import java.util.Collection;

public class UserServiceImpl implements hu.iit.uni.miskolc.bontozd.service.UserService {

    public UserDAO dao;

    public UserServiceImpl(UserDAO dao) {this.dao = dao;}

    public void addUser(User user) throws UsernameIsOccupiedException{
        dao.createUser(user);
    }

    public void removeUser(String username) throws UsernameNotFoundException{
        dao.deleteUser(username);
    }

    public void updateUser(User user) throws UsernameNotFoundException, UsernameIsOccupiedException {
        dao.updateUser(user);
    }

    public Collection <User> getAllUser(){
        return dao.readUsers();
    }

    public User getUserByUsername(String username) throws UsernameNotFoundException{
        return dao.readUserByUsername(username);
    }

    @Override
    public User validateUser(Login login) {
        return null;
    }

    @Override
    public void register(User user) {

    }

}