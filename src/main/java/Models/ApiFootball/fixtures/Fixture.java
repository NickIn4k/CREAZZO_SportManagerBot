package Models.ApiFootball.fixtures;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

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
            date != null ? formatDate(date) : "N/A",
            status != null ? status.toString() : "N/A"
        );
    }

    // Metodo per formattare la data (più leggibile)
    private String formatDate(String isoDate) {
        // Parse di una data in formato ISO "yyyy-MM-ddTHH:mm:ss+nn:nn"
        OffsetDateTime odt = OffsetDateTime.parse(isoDate);

        // Definisco il pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return odt.format(formatter);
    }
}
