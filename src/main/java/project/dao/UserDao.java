package project.dao;

import project.dao.entity.UserEntity;

import java.util.Optional;

public interface UserDao extends GenericDao<UserEntity, Long> {

    Optional<UserEntity> findByLoginAndPassword(String login, String password);
}
