package DbModels;

public class ApiRequest {
    public int id;
    public int userId;
    public String sport;
    public String entity;
    public String endpoint;
    public String requestedAt;

    public ApiRequest(int id, int userId, String sport, String entity, String endpoint, String requestedAt) {
        this.id = id;
        this.userId = userId;
        this.sport = sport;
        this.entity = entity;
        this.endpoint = endpoint;
        this.requestedAt = requestedAt;
    }
}
