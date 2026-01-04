package DbModels;

public class SportMeme {
    public int id;
    public String sport;
    public String imageUrl;

    public SportMeme(int id, String sport, String imageUrl) {
        this.id = id;
        this.sport = sport;
        this.imageUrl = imageUrl;
    }
}
