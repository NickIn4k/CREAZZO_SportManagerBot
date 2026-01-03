package DbModels;

public class SportMeme {
    public int id;
    public String sport;
    public String title;
    public String imageUrl;

    public SportMeme(int id, String sport, String title, String imageUrl) {
        this.id = id;
        this.sport = sport;
        this.title = title;
        this.imageUrl = imageUrl;
    }
}
