package spring.user.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountingDaoFactory {
    @Bean
    public UserDao userDao(){
        return new UserDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker(){
        return new CountingCon(realConnectionMaker());
    }

    @Bean
    public ConnectionMaker realConnectionMaker(){
        return new kCon();
    }
}
