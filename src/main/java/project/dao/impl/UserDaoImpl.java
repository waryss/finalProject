package project.dao.impl;

import org.springframework.stereotype.Repository;
import project.dao.UserDao;
import project.dao.entity.UserEntity;

import java.util.Optional;

@Repository
public class UserDaoImpl extends GenericDaoImpl<UserEntity, Long> implements UserDao {

    public Optional<UserEntity> findByLoginAndPassword(String login, String password) {
        return getByCriteria("login", login).stream()
                .filter(u -> password.equals(u.getPassword())).findFirst();
    }
}