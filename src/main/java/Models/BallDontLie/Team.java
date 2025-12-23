package Models.BallDontLie;

public class Team {
    public int id;
    public String abbreviation;
    public String city;
    public String full_name;
    public String conference;

    @Override
    public String toString() {
        return """
        🏀 %s
        📍 %s
        🏟 Conference: %s
        """.formatted(full_name, city, conference);
    }
}
