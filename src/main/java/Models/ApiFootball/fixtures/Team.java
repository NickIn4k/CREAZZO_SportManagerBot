package Models.ApiFootball.fixtures;

public class Team {
    public int id;
    public String name;
    public String logo;

    @Override
    public String toString() {
        return "%s".formatted(
            name != null ? name : "N/A"
        );
    }

}
