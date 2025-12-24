package Models.ApiFootball.players;

import Models.ApiFootball.teams.Team;

public class PlayerStatistics {
    public Team team;
    public League league;
    public Games games;

    @Override
    public String toString() {
        return """
        📊 Statistiche Giocatore
        
        %s
        %s
        %s
        """.formatted(
            team != null ? team.toString() : "🏟️ Squadra: N/A\n",
            league != null ? league.toString() : "",
            games != null ? games.toString() : ""
        );
    }

}
