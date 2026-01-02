package DbModels;

public class UserExercise {
    public int id;
    public int trainingDayId;
    public String name;
    public int sets;
    public int reps;
    public double weight;
    public String notes;

    public UserExercise(int id, int trainingDayId, String name, int sets, int reps, double weight, String notes) {
        this.id = id;
        this.trainingDayId = trainingDayId;
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.notes = notes;
    }
}
