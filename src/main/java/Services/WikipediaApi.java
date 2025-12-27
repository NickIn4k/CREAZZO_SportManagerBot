package Services;

import Models.Wiki.WikipediaSearchResponse;
import Models.Wiki.WikipediaSummaryResponse;
import com.google.gson.Gson;
import org.example.ApiClient;

import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;

public class WikipediaApi {
    private final ApiClient apiClient = new ApiClient();
    private final Gson gson = new Gson();

    private String get(String url) {
        HttpRequest req = apiClient.getRequest(url, "GET", null, null);
        return apiClient.sendRequest(req).body();
    }

    public WikipediaSummaryResponse getSummary(String title) {
        String encoded = URLEncoder.encode(title, StandardCharsets.UTF_8);
        String url = "https://it.wikipedia.org/api/rest_v1/page/summary/" + encoded;
        String json = get(url);
        return gson.fromJson(json, WikipediaSummaryResponse.class);
    }

    public WikipediaSearchResponse search(String query) {
        String encoded = URLEncoder.encode(query, StandardCharsets.UTF_8);
        String url = "https://en.wikipedia.org/w/rest.php/v1/search/title?q=" + encoded + "&limit=5";
        String json = get(url);
        return gson.fromJson(json, WikipediaSearchResponse.class);
    }
}
