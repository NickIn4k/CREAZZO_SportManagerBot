package Models.ApiFootball.teams;

public class Venue {
    public int id;
    public String name;
    public String city;
    public int capacity;

    @Override
    public String toString() {
        return """
        🏷️ Nome: %s
        📍 Città: %s
        👥 Capacità: %s
        """.formatted(
            name != null ? name : "N/A",
            city != null ? city : "N/A",
            capacity
        );
    }
}
