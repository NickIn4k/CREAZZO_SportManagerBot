package Models.Ergast;

import com.google.gson.annotations.SerializedName;

public class Location {
    public String lat;

    // Non posso usare il nome "long"
    @SerializedName("long")
    public String long_;

    public String locality;
    public String country;

    @Override
    public String toString() {
        return """
        %s, %s (Lat: %s, Long: %s)
        """.formatted(locality, country, lat, long_);
    }
}
