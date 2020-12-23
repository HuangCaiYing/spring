package com.abc.dao;

import com.abc.dao.entity.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserDaoTest {
    @Autowired
    UserDao userDao;

    @Test
    public void exist() {
        TestCase.assertTrue(userDao.exist("root")>0);
        TestCase.assertTrue(userDao.exist("root111")==0);
    }

    @Test
    public void login() {
        TestCase.assertNotNull(userDao.login(new User("root","root")));
        TestCase.assertNull(userDao.login(new User("root111","root")));

    }
}