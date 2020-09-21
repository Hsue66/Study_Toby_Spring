package spring.user.domain;

public class DaoFactory {
    public UserDao userDao(){
        return new UserDao(new kCon());
    }

    public AccountDao accountDao(){
        return new AccountDao(new kCon());
    }

    public MessageDao messageDao(){
        return new MessageDao(new kCon());
    }
}
