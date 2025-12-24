package Models.ApiFootball.fixtures;

public class Teams {
    public Team home;
    public Team away;

    @Override
    public String toString() {
        return """
        🏠 Squadra di casa: %s
        🛣️ Squadra ospite: %s
        """.formatted(
            home != null ? home.toString() : "N/A",
            away != null ? away.toString() : "N/A"
        );
    }

}
