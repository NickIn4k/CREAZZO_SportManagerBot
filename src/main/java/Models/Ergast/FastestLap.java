package Models.Ergast;

public class FastestLap {
    public int rank;
    public String lap;
    public Time Time;
    public AverageSpeed AverageSpeed;

    @Override
    public String toString() {
        return """
        Posizione giro veloce: %s
        Giro: %s
        Tempo: %s
        Velocità media: %s
        """.formatted(
                rank,
                lap != null ? lap : "N/A",
                Time != null ? Time.toString() : "N/A",
                AverageSpeed != null ? AverageSpeed.toString() : "N/A"
        );
    }
}
