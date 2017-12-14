package hu.iit.uni.miskolc.bontozd.dao.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import hu.iit.uni.miskolc.bontozd.dao.UserDAO;
import hu.iit.uni.miskolc.bontozd.exceptions.UsernameIsOccupiedException;
import hu.iit.uni.miskolc.bontozd.exceptions.UsernameNotFoundException;
import hu.iit.uni.miskolc.bontozd.model.User;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

public class UserDAOJSON implements UserDAO {
    /**
     * Mapper for JSON
     */
    ObjectMapper mapper;

    /**
     * The data file
     */
    File jsonfile;

    public UserDAOJSON(String filename) {
        /**
         * The configuration of the mapper for handling the LocalDate correctly.
         */
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        /**
         * The loading of the file, and if it is not exist, creation of the file.
         */
        jsonfile = new File(filename);
        if (!jsonfile.exists()) {
            try {
                jsonfile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public UserDAOJSON() {

    }

    @Override
    public Collection<User> readUsers() {
        Collection<User> users = new HashSet<User>();
        try {
            System.out.println(jsonfile.getAbsoluteFile());
            users = mapper.readValue(jsonfile, new TypeReference<HashSet<User>>() {
            });
        } catch (MismatchedInputException e) {
            System.err.println("Empty file");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;

    }

    @Override
    public User readUserByUsername(String username) throws UsernameNotFoundException {
        Collection<User> users = new HashSet<>();
        try{
            users = mapper.readValue(jsonfile, new TypeReference<HashSet<User>>(){});
            for(User u: users){
                if (u.getUsername().equalsIgnoreCase(username)) {
                    return u;
                }
            }
        }
        catch (MismatchedInputException u){
            System.err.println("Empty file");
        }
        catch (IOException u) {
            u.printStackTrace();
        }
        throw new UsernameNotFoundException(username);
    }


    @Override
    public void createUser(User user) throws UsernameIsOccupiedException {
        Collection<User> users = readUsers();

        boolean uniqueId = true;
        for (User u : users) {
            if (u.getUsername().equals(user.getUsername())) {
                uniqueId = false;
            }
        }
        if (!uniqueId) {
            throw new UsernameIsOccupiedException(user.getUsername());
        }
        users.add(user);
        try {
            mapper.writeValue(jsonfile, user);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateUser(User user) throws UsernameNotFoundException {
        Collection<User> users = readUsers();
        for(User u : users){
            if(u.getUsername().equalsIgnoreCase(user.getUsername())){
                users.remove(u);
                users.add(user);
            }
        }
        try {
            mapper.writeValue(jsonfile, users);
        } catch (IOException u) {
            u.printStackTrace();
        }

    }

    @Override
    public void deleteUser(String userName) throws UsernameNotFoundException {
        User removableUser = readUserByUsername(userName);
        Collection<User> users = readUsers();
        users.remove(removableUser);
        try {
            mapper.writeValue(jsonfile, users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
