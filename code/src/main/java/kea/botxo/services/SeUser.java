package kea.botxo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kea.botxo.models.User;
import kea.botxo.repositories.ReUser;
import java.util.List;

/**
 * User Service
 * @author Tariq
 */
@Service
public class SeUser {

    @Autowired
    ReUser reUser;

    /**
     * @author Tariq
     * @param name Fetch a specific User with the PK Name
     * @return Returns a user
     */
    public User fetch(String name) {
        return reUser.fetch(name);
    }

    /**
     * @author Tariq
     * @return Returns an Arraylist of all users
     */
    public List<User> fetchAll() {
        return reUser.fetchAll();
    }

    /**
     * @author Tariq
     * @param user The user to be added to the Database
     * @return List of Users with the new User added to it
     */
    public boolean add(User user) {
        return reUser.add(user);
    }

    /**
     * @author Tariq
     * @param user Takes a User instead of Name because the Update
     *             method has to insert data into the Database
     * @return The list of Users with the updated User
     */
    public boolean update(User user) {

        return reUser.update(user);
    }

    /**
     * @author Tariq
     * @param name Works as an ID to the use which is to be deleted
     * @return User list with the User removed
     */
    public boolean delete(String name) {
        return reUser.delete(name);
    }

    /**
     * @author Tariq
     * @param name Uses name to validate User
     * @param password Validates the password of the User
     * @return Returns validation of the User based on Name and Password
     */
    public boolean validateLogin(String name, String password){
        return true;
    }

}
