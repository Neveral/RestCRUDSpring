package api.service;

import api.model.Group;
import api.model.User;

import java.util.List;

public interface AccountService {

    User findUserById(long id);
    User findUserByLogin(String login);
    Long saveUser(User user);
    Long updateUser(User user);
    void deleteUserById(long id);
    List<User> findAllUsers();
    boolean isUserExist(User user);

    Group findGroupByName(String groupName);
    Group getGroupById(Long id);
    List<Group> findAllGroups();
    Long updateGroup(Group group);
    boolean isGroupExist(Group group);
}
