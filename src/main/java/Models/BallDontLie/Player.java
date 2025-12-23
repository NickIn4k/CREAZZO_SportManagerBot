package Models.BallDontLie;

public class Player {
    public int id;
    public String first_name;
    public String last_name;
    public String position;
    public Team team;

    @Override
    public String toString() {
        return """
        👤 %s %s
        🏀 Ruolo: %s
        🏷 Team: %s
        """.formatted(
                first_name,
                last_name,
                position != null && !position.isEmpty() ? position : "N/A",
                team != null ? team.full_name : "N/A"
        );
    }
}
