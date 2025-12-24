package Models.ApiFootball.teams;

public class Team {
    public int id;
    public String name;
    public String code;
    public String country;
    public int founded;
    public boolean national;
    public String logo;

    @Override
    public String toString() {
        return """     
            🏟️ Nome: %s
            🌍 Nazione: %s
            📅 Fondazione: %d""".formatted(
                name != null ? name : "N/A",
                country != null ? country : "N/A",
                founded
            );
    }
}
