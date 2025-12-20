package Models.Ergast;

import java.util.List;

public class StandingsTable {
    public String season;
    public String round;
    public List<DriverStanding> driverStandings;

    @Override
    public String toString() {
        String output = """
        🏆 Classifica Piloti - Stagione %s, Round %s
        """.formatted(season, round);

        for (DriverStanding ds : driverStandings)
            output += "\n\n" + ds.toString();

        return output;
    }
}
