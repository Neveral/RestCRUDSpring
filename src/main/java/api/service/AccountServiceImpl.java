package api.service;


import api.model.User;
import api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("AccountService")
@Transactional()
public class AccountServiceImpl implements AccountService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(long id) {
        return userRepository.findOne(id); // or getOne()????
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public Long saveUser(User user) {
        return userRepository.saveAndFlush(user).getId();
    }

    @Override
    public Long updateUser(User user) {
        return userRepository.saveAndFlush(user).getId();
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.delete(id);
    }

    @Override
    public boolean isUserExist(User user) {
        return userRepository.exists(user.getId());
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
