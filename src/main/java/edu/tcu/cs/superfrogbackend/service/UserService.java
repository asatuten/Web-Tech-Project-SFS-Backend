package edu.tcu.cs.superfrogbackend.service;

import edu.tcu.cs.superfrogbackend.dao.UserDao;
//import edu.tcu.cs.superfrogbackend.domain.MyUserPrincipal;
import edu.tcu.cs.superfrogbackend.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;*/
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    private UserDao userDao;
    // private PasswordEncoder encoder;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    // @Autowired
    /*public void setEncoder(PasswordEncoder encoder) {
        this.encoder = encoder;
    }*/

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findById(Integer id) {
        return userDao.findById(id).get();
    }

    public void save(User user) {
        // user.setPassword(encoder.encode(user.getPassword()));
        userDao.save(user);
    }

    public void update(Integer id, User user) {
        user.setId(id);
        userDao.save(user);
    }

    //change to only deactivate acct
    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }
    //public void deactivateById(Integer id) {
       // userDao.deactivateById(id);
    //}
/*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Step 1, we need to find this user from DB
        User user = userDao.findByUsername(username);
        // Step 2, if the user does exist
        if (user == null) {
            throw new UsernameNotFoundException("username " + username + " is not found");
        }
        // Otherwise, wrap the returned user instance in a MyUserPrincipal instance
        return new MyUserPrincipal(user); // return the principal-
    }

 */
}
