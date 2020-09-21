package spring.user.domain;

public class AccountDao {
    ConnectionMaker connectionMaker;

    AccountDao(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }
}
