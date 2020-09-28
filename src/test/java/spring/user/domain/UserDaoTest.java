package spring.user.domain;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserDaoTest {
    UserDao userDao;
    User user;

    @Before
    public void setup(){
        //this.userDao = new UserDao();
        DataSource dataSource = new SingleConnectionDataSource("jdbc:mysql://localhost/springbook?serverTimezone=UTC","root","1234",true);
        userDao.setDataSource(dataSource);
        this.user = new User("hsue","Sumin Hong","66");
    }

    @Test
    public void deleteTest() throws SQLException {
        this.userDao = new UserDaoDeleteAll();
        userDao.delete();
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
