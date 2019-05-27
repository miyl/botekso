package kea.botxo.Repository;

import org.springframework.stereotype.Repository;
import kea.botxo.Model.User;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReUser {

    public ReUser() {}

    public User fetch(String name) {

        //dummy data
        User user = new User();
        user.setName("Hans");
        user.setPassword("hejhej");

        return user;
    }

    public List<User> fetchAll() {
        List<User> userList = new ArrayList<>();

        //dummy data
        User user = new User();
        user.setName("Hans");
        user.setPassword("hejhej");

        User user2 = new User();
        user.setName("Grethe");
        user.setPassword("hejhej");

        userList.add(user);
        userList.add(user2);

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
