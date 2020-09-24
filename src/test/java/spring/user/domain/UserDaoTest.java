package spring.user.domain;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserDaoTest {
    UserDao userDao;
    User user;

    @Before
    public void setup(){
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml"); //new AnnotationConfigApplicationContext(DaoFactory.class);
        this.userDao = context.getBean("userDao",UserDao.class);
        this.user = new User("hsue","Sumin Hong","66");
    }

    @Test
    public void addAndGetTest() throws SQLException {
        userDao.delete();
        assertThat(userDao.count(), is(0));

        userDao.add(user);
        assertThat(userDao.count(), is(1));

        User user1 = userDao.get(user.getId());
        assertThat(user1.getName(),is(user.getName()));
        assertThat(user1.getPassword(),is(user.getPassword()));
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void wrongGet() throws SQLException {
        userDao.delete();
        User user1 = userDao.get("unknown_id");
    }
}
