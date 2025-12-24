package Models.ApiFootball.players;

public class League {
    public int id;
    public String name;
    public String season;

    @Override
    public String toString() {
        return """
        🏷️ Nome: %s
        📅 Stagione: %s
        """.formatted(
            name != null ? name : "N/A",
            season != null ? season : "N/A"
        );
    }

}
