package finalProject.dao.impl;

import finalProject.config.ApplicationConfiguration;
import finalProject.dao.IUserDao;
import finalProject.dao.entity.UserEntity;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class UserDaoTest extends TestCase {

    @Autowired
    private IUserDao userDao;

    @Test
    @Ignore
    public void when_create_user_with_id_then_get_persisted_user_with_the_same_id() {
        UserEntity userEntity = new UserEntity(1, "toto", "toto");
        userDao.persist(userEntity);
        Assert.assertNotNull(userDao.find(1));
    }

}