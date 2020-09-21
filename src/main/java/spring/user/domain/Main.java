package spring.user.domain;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new DaoFactory().userDao();

        User user = new User();
        user.setId("hsue");
        user.setName("Sumin Hong");
        user.setPassword("66");

        userDao.add(user);
        System.out.println(user.getId() +" added!");

        User user1 = userDao.get(user.getId());
        System.out.println(user1.getId()+" "+user1.getName()+" "+user1.getPassword());
    }
}
