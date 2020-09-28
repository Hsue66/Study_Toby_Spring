package spring.user.domain;

import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserDaoTest {
    UserDao userDao;
    User user1;
    User user2;
    User user3;

    @Before
    public void setup(){
        this.userDao = new UserDao();
        DataSource dataSource = new SingleConnectionDataSource("jdbc:mysql://localhost/springbook?serverTimezone=UTC","root","1234",true);
        userDao.setDataSource(dataSource);
        this.user1 = new User("hsue","Sumin Hong","66");
        this.user2 = new User("hsue2","Sumin Hong2","66");
        this.user3 = new User("hsue3","Sumin Hong3","66");
    }

    @Test
    public void addAndGetTest() throws SQLException {
        userDao.delete();
        assertThat(userDao.count(), is(0));

        userDao.add(user1);
        assertThat(userDao.count(), is(1));

        User user = userDao.get(user1.getId());
        assertThat(user.getName(),is(user1.getName()));
        assertThat(user.getPassword(),is(user1.getPassword()));
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void wrongGet() throws SQLException {
        userDao.delete();
        User user = userDao.get("unknown_id");
    }

    @Test
    public void getAllTest(){
        userDao.delete();

        userDao.add(user1);
        List<User> users1 = userDao.getAll();
        assertThat(users1.size(), is(1));
        checkSameUser(user1,users1.get(0));

        userDao.add(user2);
        List<User> users2 = userDao.getAll();
        assertThat(users2.size(), is(2));
        checkSameUser(user1,users2.get(0));
        checkSameUser(user2,users2.get(1));

        userDao.add(user3);
        List<User> users3 = userDao.getAll();
        assertThat(users3.size(), is(3));
        checkSameUser(user1,users3.get(0));
        checkSameUser(user2,users3.get(1));
        checkSameUser(user3,users3.get(2));
    }

    private void checkSameUser(User u1, User u2){
        assertThat(u1.getId(), is(u2.getId()));
        assertThat(u1.getName(), is(u2.getName()));
        assertThat(u1.getPassword(), is(u2.getPassword()));
    }
}
