package DbModels;

public class TrainingPlan {
    public int id;
    public int userId;
    public String name;
    public boolean isActive;

    public TrainingPlan(int id, int userId, String name, boolean isActive) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.isActive = isActive;
    }
}

