package project.dao.impl;

import project.config.ApplicationConfiguration;
import project.dao.UserDao;
import project.dao.entity.UserEntity;
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
    private UserDao tested;

    @Test
    @Ignore
    public void when_create_user_with_id_then_get_persisted_user_with_the_same_id() {
        UserEntity userEntity = new UserEntity(1, "toto", "toto");
        tested.persist(userEntity);
        Assert.assertNotNull(tested.find(1));
    }

}