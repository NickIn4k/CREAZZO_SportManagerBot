package Models.ApiFootball.fixtures;

import com.google.gson.annotations.SerializedName;

public class Status {
    @SerializedName("long")
    public String long_;

    @SerializedName("long")
    public String short_;

    @Override
    public String toString() {
        return """
        ⏱️ Stato partita
        
        📖 Completo: %s
        🔖 Breve: %s
        """.formatted(
            long_ != null ? long_ : "N/A",
            short_ != null ? short_ : "N/A"
        );
    }
}
