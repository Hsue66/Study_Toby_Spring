package spring.user.domain;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserDaoTest {
    @Test
    public void addAndGetTest() throws SQLException, ClassNotFoundException {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao userDao = context.getBean("userDao",UserDao.class);

        User user = new User();
        user.setId("hsue");
        user.setName("Sumin Hong");
        user.setPassword("66");

        userDao.add(user);

        User user1 = userDao.get(user.getId());
        assertThat(user1.getName(),is(user.getName()));
        assertThat(user1.getPassword(),is(user.getPassword()));
    }
}
