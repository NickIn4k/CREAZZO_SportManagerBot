package DbModels;

public class User {
    public int id;
    public long telegramId;
    public String username;
    public String firstName;

    public User(int id, long telegramId, String username, String firstName) {
        this.id = id;
        this.telegramId = telegramId;
        this.username = username;
        this.firstName = firstName;
    }
}
