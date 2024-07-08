package web.PP_3_3_1_Spring_Boot.dao;

import web.PP_3_3_1_Spring_Boot.model.User;

import java.util.List;

public interface UserDao {
    User getUser(Long id);

    List<User> getAll();

    void newUser(User user);

    void updateUser(User user,Long id);

    void deleteUser(Long id);
}
