package Models.ApiFootball.standings;

public class Standing {
    public int rank;
    public Team team;
    public int points;
    public Goals goals;
    public int played;
    public int win;
    public int draw;
    public int lose;

    @Override
    public String toString() {
        return """
        🏆 Posizione #%d
        
        %s
        📊 Partite: %d
        ✅ Vittorie: %d
        🤝 Pareggi: %d
        ❌ Sconfitte: %d
        🎯 Punti: %d
        
        %s
        """.formatted(
            rank,
            team != null ? team.toString() : "🏟️ Squadra: N/A\n",
            played,
            win,
            draw,
            lose,
            points,
            goals != null ? goals.toString() : ""
        );
    }

}
