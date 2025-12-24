package Models.ApiFootball.fixtures;

public class FixtureResponse {
    public Fixture fixture;
    public Teams teams;
    public Goals goals;

    @Override
    public String toString() {
        return """
        🏟 <b>Partita</b>
        %s
        %s
        %s
        """.formatted(
                fixture != null ? fixture.toString() : "",
                teams != null ? teams.toString() : "",
                goals != null ? goals.toString() : ""
        ).trim();
    }

}
