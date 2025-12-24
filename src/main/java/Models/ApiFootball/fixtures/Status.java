package Models.ApiFootball.fixtures;

import com.google.gson.annotations.SerializedName;

public class Status {
    @SerializedName("long")
    public String long_;

    @SerializedName("short")
    public String short_;

    @Override
    public String toString() {
        return "%s".formatted(
            long_ != null ? long_ : short_
        );
    }
}
