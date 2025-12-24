package Models.ApiFootball.fixtures;

public class Goals {
    public Integer home;
    public Integer away;

    @Override
    public String toString() {
        return """
        ⚽ Risultati (goal fatti)
        🏠 Squadra di casa: %s
        🛣️ Squadra ospite: %s
        """.formatted(
            home != null ? home.toString() : "N/A",
            away != null ? away.toString() : "N/A"
        );
    }

}
