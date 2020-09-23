package spring.user.domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        DaoFactory daoFactory = new DaoFactory();
        UserDao userDao1 = daoFactory.userDao();
        UserDao userDao2 = daoFactory.userDao();

        System.out.println(userDao1);
        System.out.println(userDao2);

        System.out.println(context.getBean("userDao",UserDao.class));
        System.out.println(context.getBean("userDao",UserDao.class));


        /*
        UserDao userDao = context.getBean("userDao",UserDao.class);
        User user = new User();
        user.setId("hsue");
        user.setName("Sumin Hong");
        user.setPassword("66");

        userDao.add(user);
        System.out.println(user.getId() +" added!");

        User user1 = userDao.get(user.getId());
        System.out.println(user1.getId()+" "+user1.getName()+" "+user1.getPassword());*/
    }
}
