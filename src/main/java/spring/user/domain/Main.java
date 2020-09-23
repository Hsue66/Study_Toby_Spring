package spring.user.domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        CountingCon con = context.getBean("connectionMaker",CountingCon.class);
        UserDao userDao = context.getBean("userDao",UserDao.class);

        System.out.println("connection attempt : "+con.getCount());
        User user = new User();
        user.setId("hsue");
        user.setName("Sumin Hong");
        user.setPassword("66");

        userDao.add(user);
        System.out.println(user.getId() +" added!");
        System.out.println("connection attempt : "+con.getCount());

        User user1 = userDao.get(user.getId());
        System.out.println(user1.getId()+" "+user1.getName()+" "+user1.getPassword());
        System.out.println("connection attempt : "+con.getCount());
    }
}
