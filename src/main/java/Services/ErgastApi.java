package Services;

import Models.Ergast.ErgastResponse;
import Models.Ergast.MRData;
import com.google.gson.Gson;
import org.example.ApiClient;

import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

public class ErgastApi {
    private static final String f1_url = "https://api.jolpi.ca/ergast/f1";
    private final ApiClient apiClient = new ApiClient();
    private final Gson gson = new Gson();

    public ErgastApi() {}

    private String getString(String endpoint) {
        String url = f1_url + endpoint + ".json"; // tutti gli URL finiscono con .json
        HttpRequest req = apiClient.getRequest(url, "GET", null, null);
        return apiClient.sendRequest(req).body();
    }

    // Prossima gara
    public MRData getNextRace() {
        String json = getString("/current/next");
        ErgastResponse resp = gson.fromJson(json, ErgastResponse.class);
        return resp.MRData;
    }

    // Ultima gara
    public MRData getLastRace() {
        String json = getString("/current/last");
        ErgastResponse resp = gson.fromJson(json, ErgastResponse.class);
        return resp.MRData;
    }

    // Classifica piloti aggiornata
    public MRData getDriverStandings() {
        String json = getString("/current/driverStandings");
        ErgastResponse resp = gson.fromJson(json, ErgastResponse.class);

        if(resp.MRData == null || resp.MRData.StandingsTable == null || resp.MRData.StandingsTable.round == null){
            int lastYear = java.time.Year.now().getValue() - 1;
            json = getString("/" + lastYear + "/driverStandings");
            resp = gson.fromJson(json, ErgastResponse.class);
        }
        return resp.MRData;
    }

    // Classifica costruttori aggiornata
    public MRData getConstructorStandings() {
        String json = getString("/current/constructorStandings");
        ErgastResponse resp = gson.fromJson(json, ErgastResponse.class);

        if(resp.MRData == null || resp.MRData.StandingsTable == null || resp.MRData.StandingsTable.round == null){
            int lastYear = java.time.Year.now().getValue() - 1;
            json = getString("/" + lastYear + "/constructorStandings");
            resp = gson.fromJson(json, ErgastResponse.class);
        }
        return resp.MRData;
    }

    // Calendario stagione per anno specifico
    public MRData getCalendar(int year) {
        String newUrl = (year == java.time.Year.now().getValue()) ? "/current" : "/" + year;
        String json = getString(newUrl);
        ErgastResponse resp = gson.fromJson(json, ErgastResponse.class);
        return resp.MRData;
    }

    // Dati pilota specifico
    public MRData getDriver(String driverId) {
        String json = getString("/drivers/" + driverId);
        ErgastResponse resp = gson.fromJson(json, ErgastResponse.class);
        return resp.MRData;
    }

    // Lista team
    public MRData getConstructors() {
        String json = getString("/constructors/?limit=100&offset=0");
        ErgastResponse resp = gson.fromJson(json, ErgastResponse.class);
        return resp.MRData;
    }

    // Team specifico
    public MRData getSpecificTeam(String name) {
        String encoded = URLEncoder.encode(name, StandardCharsets.UTF_8);
        String json = getString("/constructors/" + encoded);
        ErgastResponse resp = gson.fromJson(json, ErgastResponse.class);
        return resp.MRData;
    }

    // Classifica ultima gara
    public MRData getLastRaceResults() {
        String json = getString("/current/last/results");
        ErgastResponse resp = gson.fromJson(json, ErgastResponse.class);

        if(resp.MRData == null || resp.MRData.RaceTable == null || resp.MRData.RaceTable.Races.isEmpty()){
            int lastYear = java.time.Year.now().getValue() - 1;
            json = getString("/" + lastYear + "/last/results");
            resp = gson.fromJson(json, ErgastResponse.class);
        }
        return resp.MRData;
    }
}
