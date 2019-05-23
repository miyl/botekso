package kea.botxo.Repository;

import org.springframework.stereotype.Repository;
import kea.botxo.Model.User;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReUser {

    public ReUser() {}

    public User fetch(String name) {

        User user = new User();
        return user;
    }

    public List<User> fetchAll() {
        List<User> userList = new ArrayList<>();

        return userList;
    }

    public boolean update(User user) {
        return true;
    }

    public boolean delete(User user) {
        return true;
    }

    public boolean add(User user) {
        return true;
    }

}
