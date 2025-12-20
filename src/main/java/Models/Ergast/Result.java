package Models.Ergast;

public class Result {
    public int position;
    public String positionText;
    public Driver Driver;
    public Constructor Constructor;
    public int grid;
    public int laps;
    public String status;
    public Time Time;
    public FastestLap FastestLap;

    @Override
    public String toString() {
        return """
        🏁 Posizione: %s
        👤 Pilota: %s %s
        🏢 Team: %s
        🏎️ Griglia: %s
        🔄 Giri completati: %s
        📌 Stato: %s
        ⏱️ Tempo: %s
        """.formatted(
                position,
                Driver != null ? Driver.givenName : "N/A",
                Driver != null ? Driver.familyName : "N/A",
                Constructor != null ? Constructor.name : "N/A",
                grid,
                laps,
                status != null ? status : "N/A",
                Time != null ? Time.toString() : "N/A"
        );
    }
}
