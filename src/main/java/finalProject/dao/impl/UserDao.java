package finalProject.dao.impl;

import finalProject.dao.IUserDao;
import finalProject.dao.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDao extends GenericDao<UserEntity, Long> implements IUserDao {

    public UserEntity findByLoginAndPassword(String login, String password) {
        return Optional.of(getByCriteria("login", login).get(0))
                .filter(u -> password.equals(u.getPassword()))
                .orElse(null);
    }
}