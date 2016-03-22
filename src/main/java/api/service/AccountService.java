package api.service;

import api.model.User;

import java.util.List;

public interface AccountService {

    User findById(long id);

    User findByLogin(String login);

    Long saveUser(User user);

    Long updateUser(User user);

    void deleteUserById(long id);

    List<User> findAllUsers();

    boolean isUserExist(User user);
}
