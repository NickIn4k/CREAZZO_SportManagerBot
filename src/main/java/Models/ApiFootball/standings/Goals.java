package Models.ApiFootball.standings;

import com.google.gson.annotations.SerializedName;

public class Goals {
    public int against;

    @SerializedName("for")
    public int for_;

    @Override
    public String toString() {
        return """
        ➕ Fatti: %d
        ➖ Subiti: %d
        """.formatted(
            for_,
            against
        );
    }
}
