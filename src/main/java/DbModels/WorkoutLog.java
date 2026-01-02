package DbModels;

public class WorkoutLog {
    public int id;
    public int trainingDayId;
    public String executionDate;
    public boolean completed;

    public WorkoutLog(int id, int trainingDayId, String executionDate, boolean completed) {
        this.id = id;
        this.trainingDayId = trainingDayId;
        this.executionDate = executionDate;
        this.completed = completed;
    }
}

