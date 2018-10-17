package project.service;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import project.config.ApplicationConfiguration;
import project.dao.entity.UserEntity;
import project.exception.ProjectException;

import java.security.InvalidParameterException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class UserServiceTest extends TestCase {

    @Autowired
    private UserService tested;

    @Test(expected = InvalidParameterException.class)
    public void when_authenticate_without_login_the_get_invalid_parameter_exception() throws ProjectException {
        tested.authenticate("login", null);
    }

    @Test(expected = InvalidParameterException.class)
    public void when_authenticate_without_password_the_get_invalid_parameter_exception() throws ProjectException {
        tested.authenticate(null, "password");
    }

    @Ignore
    @Test(expected = ProjectException.class)
    public void when_authenticate_with_invalid_credentials_the_get_project_exception() throws ProjectException {
        tested.authenticate("invalid_login", "invalid_password");
    }

    @Ignore
    @Test
    public void when_authenticate_with_valid_credentials_the_get_user() throws ProjectException {
        UserEntity authenticate = tested.authenticate("valid_login", "valid_password");
        Assert.assertNotNull(authenticate);
    }
}