package DbModels;

import java.time.LocalDateTime;

public class WorkoutSession {
    public int id;
    public int trainingDayId;
    public LocalDateTime executionDate;
    public boolean completed;

    // Costruttore per lettura da DB
    public WorkoutSession(int id, int trainingDayId, LocalDateTime executionDate, boolean completed) {
        this.id = id;
        this.trainingDayId = trainingDayId;
        this.executionDate = executionDate;
        this.completed = completed;
    }

    // Costruttore per inserimento
    public WorkoutSession(int trainingDayId) {
        this.trainingDayId = trainingDayId;
        this.completed = true;
        this.executionDate = LocalDateTime.now();
    }
}
