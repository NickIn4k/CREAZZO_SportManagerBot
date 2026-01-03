package DbModels;

public class ApiTopStat {
    public String sport;
    public String entity;
    public String endpoint;
    public int total;

    public ApiTopStat(String sport, String entity, String endpoint, int total) {
        this.sport = sport;
        this.entity = entity;
        this.endpoint = endpoint;
        this.total = total;
    }
}

