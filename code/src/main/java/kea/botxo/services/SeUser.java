package kea.botxo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kea.botxo.models.User;
import kea.botxo.repositories.ReUser;
import java.util.List;

/**
 *
 */
@Service
public class SeUser {

    @Autowired
    ReUser reUser;

    /**
     *
     * @param name
     * @return
     */
    public User fetch(String name) {
        return reUser.fetch(name);
    }

    /**
     *
     * @return
     */
    public List<User> fetchAll() {
        return reUser.fetchAll();
    }

    /**
     *
     * @param user
     */
    public void add(User user) {
        reUser.add(user);
    }

    /**
     *
     * @param user
     */
    public void update(User user) {

        reUser.update(user);
    }

    /**
     *
     * @param name
     */
    public void delete(String name) {
        reUser.delete(name);
    }

    /**
     *
     * @param name
     * @param password
     * @return
     */
    public boolean validateLogin(String name, String password){
        return true;
    }

}
