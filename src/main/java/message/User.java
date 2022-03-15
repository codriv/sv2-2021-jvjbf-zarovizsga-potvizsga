package message;

public class User {

    private long id;
    private String username;

    public User(String userName) {
        this.username = userName;
    }

    public User(long id, String userName) {
        this.id = id;
        this.username = userName;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
