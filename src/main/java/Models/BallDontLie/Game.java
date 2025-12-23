package Models.BallDontLie;

public class Game {
    public String date;
    public Team home_team;
    public Team visitor_team;
    public int home_team_score;
    public int visitor_team_score;

    @Override
    public String toString() {
        return """
        🏀 %s vs %s
        📊 %d - %d
        """.formatted(
                home_team.full_name,
                visitor_team.full_name,
                home_team_score,
                visitor_team_score
        );
    }
}
