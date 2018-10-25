package project.dao.impl;

import org.springframework.stereotype.Repository;
import project.dao.UserDao;
import project.model.User;

import java.util.Optional;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

    public Optional<User> findByLoginAndPassword(String login, String password) {
        return getByCriteria("login", login).stream()
                .filter(u -> password.equals(u.getPassword())).findFirst();
    }
}