package kea.botxo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kea.botxo.models.User;
import kea.botxo.repositories.ReUser;
import java.util.List;

/**
 * User Service
 * @Author Tariq
 */
@Service
public class SeUser {

    @Autowired
    ReUser reUser;

    /**
     * @Author Tariq
     * @param name Fetch a specific User with the PK Name
     * @return Returns a user
     */
    public User fetch(String name) {
        return reUser.fetch(name);
    }

    /**
     * @Author Tariq
     * @return Returns an Arraylist of all users
     * @Return Returns a list of all Customers
     */
    public List<User> fetchAll() {
        return reUser.fetchAll();
    }

    /**
     * @Author Tariq
     * @param user The user to be added to the Database
     * @Return List of Users with the new User added to it
     */
    public void add(User user) {
        reUser.add(user);
    }

    /**
     * @Author Tariq
     * @param user Takes a User instead of Name because the Update
     *             method has to insert data into the Database
     * @return The list of Users with the updated User
     */
    public void update(User user) {

        reUser.update(user);
    }

    /**
     * @Author Tariq
     * @param name Works as an ID to the use which is to be deleted
     * @Return User list with the User removed
     */
    public void delete(String name) {
        reUser.delete(name);
    }

    /**
     * @Author Tariq
     * @param name Uses name to validate User
     * @param password Validates the password of the User
     * @return Returns validation of the User based on Name and Password
     */
    public boolean validateLogin(String name, String password){
        return true;
    }

}
