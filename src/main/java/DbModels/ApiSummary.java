package DbModels;

public class ApiSummary {
    public int totalRequests;
    public String topSport;
    public String topEntity;

    public ApiSummary(int totalRequests, String topSport, String topEntity) {
        this.totalRequests = totalRequests;
        this.topSport = topSport;
        this.topEntity = topEntity;
    }
}

