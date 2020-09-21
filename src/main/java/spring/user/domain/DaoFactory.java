package spring.user.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao(){
        return new UserDao(new kCon());
    }

    @Bean
    public AccountDao accountDao(){
        return new AccountDao(new kCon());
    }

    @Bean
    public MessageDao messageDao(){
        return new MessageDao(new kCon());
    }
}
