package kea.botxo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kea.botxo.models.User;
import kea.botxo.repositories.ReUser;
import java.util.List;


@Service
public class SeUser {

    @Autowired
    ReUser reUser;

    public User fetch(String name) {
        return reUser.fetch(name);
    }

    public List<User> fetchAll() {
        return reUser.fetchAll();
    }

    public void add(User user) {
        reUser.add(user);
    }

    public void update(User user) {

        reUser.update(user);
    }

    public void delete(User user) {
        reUser.delete(user);
    }

    public boolean validateLogin(String name, String password){
        return true;
    }

}