package Services;

import Models.ApiFootball.teams.TeamResponse;
import com.google.gson.Gson;
import Models.ApiFootball.fixtures.FixtureResponse;
import Models.ApiFootball.players.PlayerResponse;
import Models.ApiFootball.standings.StandingsResponse;
import Models.ApiFootball.teams.TeamsResponse;
import org.example.ApiClient;
import org.example.StandardConfig;

import java.net.http.HttpRequest;

public class FootballApi {

    private static final String BASE_URL = "https://v3.football.api-football.com";

    private final ApiClient apiClient = new ApiClient();
    private final Gson gson = new Gson();

    private String get(String endpoint) {
        String url = BASE_URL + endpoint;
        HttpRequest req = apiClient.getRequest(url, "GET", null,
                StandardConfig.getInstance().getProps("APIFOOTBAL_API_KEY"));
        return apiClient.sendRequest(req).body();
    }

    // Info Tutti i team in base alla lega e alla stagione
    public TeamsResponse getTeams(int leagueId, int season) {
        String json = get("/teams?league=" + leagueId + "&season=" + season);
        return gson.fromJson(json, TeamsResponse.class);
    }

    // Giocatori di un team cercando il team per nome in base alla stagione
    public PlayerResponse getPlayersByTeamName(String teamName, int season) {
        // Cerca il team
        String teamJson = get("/teams?search=" + teamName);
        TeamsResponse teamResp = gson.fromJson(teamJson, TeamsResponse.class);

        if (teamResp.response == null || teamResp.response.isEmpty())
            return null;

        int teamId = teamResp.response.getFirst().team.id;

        // Cerca i giocatori
        String playerJson = get("/players?team=" + teamId + "&season=" + season);
        return gson.fromJson(playerJson, PlayerResponse.class);
    }

    // Informazioni giocatore per nome
    public PlayerResponse searchPlayerByName(String name) {
        String json = get("/players?search=" + name);
        return gson.fromJson(json, PlayerResponse.class);
    }

    // Partite in base alla lega e alla stagione
    public FixtureResponse getFixturesByLeague(int leagueId, int season) {
        String json = get("/fixtures?league=" + leagueId + "&season=" + season);
        return gson.fromJson(json, FixtureResponse.class);
    }

    // Partite in base alla data
    public FixtureResponse getFixturesByDate(String date) {
        String json = get("/fixtures?date=" + date);
        return gson.fromJson(json, FixtureResponse.class);
    }

    // Prossima partita
    public FixtureResponse getNextFixture(int leagueId, int season) {
        String json = get("/fixtures?league=" + leagueId + "&season=" + season + "&next=1");
        return gson.fromJson(json, FixtureResponse.class);
    }

    // Ultima partita
    public FixtureResponse getLastFixture(int leagueId, int season) {
        String json = get("/fixtures?league=" + leagueId + "&season=" + season + "&last=1");
        return gson.fromJson(json, FixtureResponse.class);
    }

    // Classifica aggiornata
    public StandingsResponse getStandings(int leagueId, int season) {
        String json = get("/standings?league=" + leagueId + "&season=" + season);
        return gson.fromJson(json, StandingsResponse.class);
    }
}
