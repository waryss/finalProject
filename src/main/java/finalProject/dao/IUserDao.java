package finalProject.dao;

import finalProject.dao.entity.UserEntity;

public interface IUserDao extends IGenericDao<UserEntity, Long>{

    UserEntity findByLoginAndPassword(String login, String password);
}
