package Models.ApiFootball.players;

public class Games {
    public int appearances;
    public int minutes;
    public String position;
    public String rating;

    @Override
    public String toString() {
        return """
        🧢 Partite giocate: %d
        ⏱️ Minuti: %d
        📍 Ruolo: %s
        ⭐ Rating: %s
        """.formatted(
            appearances,
            minutes,
            position != null ? position : "N/A",
            rating != null ? rating : "N/A"
        );
    }
}
