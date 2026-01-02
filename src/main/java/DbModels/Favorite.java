package DbModels;

public class Favorite {
    public int id;
    public int userId;
    public String category;
    public String value;

    public Favorite(int id, int userId, String category, String value) {
        this.id = id;
        this.userId = userId;
        this.category = category;
        this.value = value;
    }
}
