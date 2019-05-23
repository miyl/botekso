package kea.botxo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kea.botxo.Model.User;
import kea.botxo.Repository.ReUser;
import java.util.ArrayList;
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

}
