package project.dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import project.model.User;

public interface UserDao extends GenericDao<User, Long> {

    Optional<User> findByLoginAndPassword(String login, String password);
}
