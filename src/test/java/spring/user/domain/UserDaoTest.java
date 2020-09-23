package spring.user.domain;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserDaoTest {
    UserDao userDao;

    @Before
    public void setup(){
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        this.userDao = context.getBean("userDao",UserDao.class);
    }

    @Test
    public void addAndGetTest() throws SQLException, ClassNotFoundException {
        userDao.delete();
        assertThat(userDao.count(), is(0));

        User user = new User();
        user.setId("hsue");
        user.setName("Sumin Hong");
        user.setPassword("66");

        userDao.add(user);
        assertThat(userDao.count(), is(1));

        User user1 = userDao.get(user.getId());
        assertThat(user1.getName(),is(user.getName()));
        assertThat(user1.getPassword(),is(user.getPassword()));
    }
}
