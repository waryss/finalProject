package project.service;

import project.dao.UserDao;
import project.dao.entity.UserEntity;
import project.exception.ProjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.security.InvalidParameterException;

@Service(value="service")
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserEntity authenticate(String login, String password) throws ProjectException {

        if (StringUtils.isEmpty(login))
            throw new InvalidParameterException("[login] is mandatory");

        if (StringUtils.isEmpty(password))
            throw new InvalidParameterException("[password] is mandatory");
        System.out.println("dans la finction userDao = " + userDao);
        return userDao.findByLoginAndPassword(login, password)
                .orElseThrow(
                        () -> new ProjectException("Could not found user for given login and password")
                );
    }
}
