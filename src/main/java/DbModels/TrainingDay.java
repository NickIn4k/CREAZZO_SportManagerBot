package DbModels;

public class TrainingDay {
    public int id;
    public int planId;
    public int dayOfWeek;
    public String focus;

    public TrainingDay(int id, int planId, int dayOfWeek, String focus) {
        this.id = id;
        this.planId = planId;
        this.dayOfWeek = dayOfWeek;
        this.focus = focus;
    }
}
