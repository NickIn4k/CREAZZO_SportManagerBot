package Services;

import Models.ApiFootball.fixtures.FixturesResponse;
import Models.ApiFootball.players.PlayersResponse;
import com.google.gson.Gson;
import Models.ApiFootball.standings.StandingsResponse;
import Models.ApiFootball.teams.TeamsResponse;
import org.example.ApiClient;
import org.example.StandardConfig;

import java.net.http.HttpRequest;

public class FootballApi {
    private static final String base_url = "https://v3.football.api-sports.io";

    private final ApiClient apiClient = new ApiClient();
    private final Gson gson = new Gson();

    private String get(String endpoint) {
        String url = base_url + endpoint;
        HttpRequest req = getRequest(url, "GET", null, StandardConfig.getInstance().getProps("APIFOOTBALL_API_KEY"));
        return apiClient.sendRequest(req).body();
    }

    public HttpRequest getRequest(String url, String method, String body, String apiKey) {
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(java.net.URI.create(url))
                .header("User-Agent", "SportManagerBot/1.0")
                .header("Accept", "application/json");

        if (body == null || body.isEmpty())
            builder.method(method, HttpRequest.BodyPublishers.noBody());
        else
            builder.method(method, HttpRequest.BodyPublishers.ofString(body));

        if (apiKey != null && !apiKey.isEmpty())
            builder.header("x-apisports-key", apiKey);

        return builder.build();
    }

    public TeamsResponse getTeams(int leagueId, int season) {
        String json = get("/teams?league=" + leagueId + "&season=" + season);
        return gson.fromJson(json, TeamsResponse.class);
    }

    public PlayersResponse getPlayersByTeamId(int teamId, int year) {
        String json = get("/players?team=" + teamId + "&season=" + year + "&page=1");
        return gson.fromJson(json, PlayersResponse.class);
    }

    public PlayersResponse getPlayerById(int playerId, int season) {
        String json = get("/players?id=" + playerId + "&season=" + season + "&page=1");
        return gson.fromJson(json, PlayersResponse.class);
    }

    public FixturesResponse getFixturesByLeague(int leagueId, int season) {
        String json = get("/fixtures?league=" + leagueId + "&season=" + season);
        return gson.fromJson(json, FixturesResponse.class);
    }

    public StandingsResponse getStandings(int leagueId, int season) {
        String json = get("/standings?league=" + leagueId + "&season=" + season);
        return gson.fromJson(json, StandingsResponse.class);
    }

    /* IL PIANO GRATUITO NON PERMETTE L'UTILIZZO DI NEXT E LAST
    public FixtureResponse getNextFixture(int leagueId, int season) {
        String json = get("/fixtures?league=" + leagueId + "&season=" + season + "&next=1");
        return gson.fromJson(json, FixtureResponse.class);
    }

    public FixtureResponse getLastFixture(int leagueId, int season) {
        String json = get("/fixtures?league=" + leagueId + "&season=" + season + "&last=1");
        return gson.fromJson(json, FixtureResponse.class);
    }
     */
}
