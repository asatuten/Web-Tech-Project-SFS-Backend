package edu.tcu.cs.superfrogbackend.service;

import edu.tcu.cs.superfrogbackend.dao.UserDao;
//import edu.tcu.cs.superfrogbackend.domain.MyUserPrincipal;
import edu.tcu.cs.superfrogbackend.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findById(String userId) {
        return userDao.findById(userId).get();
    }

    public void save(User newUser) {
        userDao.save(newUser);
    }

    public void update(String userId, User updatedUser) {
        updatedUser.setId(userId);
        userDao.save(updatedUser);
    }

    public void deleteById(String id) {
        userDao.deleteById(id);
    }
}