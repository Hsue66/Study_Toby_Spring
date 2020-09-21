package spring.user.domain;

public class MessageDao {
    ConnectionMaker connectionMaker;

    MessageDao(ConnectionMaker connectionMaker){
        this.connectionMaker = connectionMaker;
    }
}
