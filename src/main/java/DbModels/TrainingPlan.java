package DbModels;

import java.util.ArrayList;
import java.util.List;

public class TrainingPlan {
    public int id;
    public int userId;
    public String name;
    public boolean isActive;

    private List<TrainingDay> trainingDays;

    public TrainingPlan(int id, int userId, String name, boolean isActive) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.isActive = isActive;
        this.trainingDays = new ArrayList<>();
    }

    public void addTrainingDay(TrainingDay day) {
        trainingDays.add(day);
    }

    public List<TrainingDay> getTrainingDays() {
        return trainingDays;
    }
    public String toString() {
        return "🆔 %d – %s%s".formatted(id, name, isActive ? " ⭐" : " 🔒");
    }
}
