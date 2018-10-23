package project.dao;

import project.dao.entity.UserEntity;

import java.util.Optional;

import org.springframework.stereotype.Repository;

public interface UserDao extends GenericDao<UserEntity, Long> {

    Optional<UserEntity> findByLoginAndPassword(String login, String password);
}
