package Models.ApiFootball.players;

public class Player {
    public int id;
    public String name;
    public String firstname;
    public String lastname;
    public int age;
    public String nationality;
    public String height;
    public String weight;
    public String photo;

    @Override
    public String toString() {
        return """
        🏷️ Nome: %s %s
        🎂 Età: %d
        🌍 Nazionalità: %s
        📏 Altezza: %s
        ⚖️ Peso: %s
        """.formatted(
            firstname != null ? firstname : "",
            lastname != null ? lastname : name != null ? name : "N/A",
            age,
            nationality != null ? nationality : "N/A",
            height != null ? height : "N/A",
            weight != null ? weight : "N/A"
        );
    }

}
