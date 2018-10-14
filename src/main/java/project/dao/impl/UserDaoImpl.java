package project.dao.impl;

import project.dao.UserDao;
import project.dao.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDaoImpl extends GenericDaoImpl<UserEntity, Long> implements UserDao {

    public Optional<UserEntity> findByLoginAndPassword(String login, String password) {
        return Optional.of(getByCriteria("login", login).get(0))
                .filter(u -> password.equals(u.getPassword()));
    }
}