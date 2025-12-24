package Models.ApiFootball.standings;

public class Standing {
    public int rank;
    public Team team;
    public int points;
    public AllStats all;

    @Override
    public String toString() {
        return """
        Posizione: %d
        %s
        📊 Partite: %s
        ✅ Vittorie: %s
        🤝 Pareggi: %s
        ❌ Sconfitte: %s
        🎯 Punti: %d
        """.formatted(
                rank,
                team != null ? team.toString() : "🏟️ Squadra: N/A",
                all != null ? all.played : "N/A",
                all != null ? all.win : "N/A",
                all != null ? all.draw : "N/A",
                all != null ? all.lose : "N/A",
                points
        );
    }
}
