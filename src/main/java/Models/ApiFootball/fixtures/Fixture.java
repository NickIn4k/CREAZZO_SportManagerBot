package Models.ApiFootball.fixtures;

public class Fixture {
    public int id;
    public String date;
    public Status status;

    @Override
    public String toString() {
        return """        
        📅 Data: %s
        🟢 Stato: %s
        """.formatted(
            date != null ? date : "N/A",
            status != null ? status.toString() : "N/A"
        );
    }

}
