package Models.ApiFootball.standings;

import java.util.List;

public class League {
    public List<List<Standing>> standings;

    @Override
    public String toString() {
        String result = "📊 <b>Classifica</b>\n\n";

        for (int g = 0; g < standings.size(); g++) {
            List<Standing> group = standings.get(g);

            result = result.concat("🏆 <b>Gruppo %d</b>\n\n".formatted(g + 1));

            for (Standing s : group)
                result = result.concat("%s\n".formatted(s.toString()));

            result = result.concat("\n");
        }
        return result.trim();
    }
}
