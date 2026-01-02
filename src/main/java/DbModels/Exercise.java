package DbModels;

public class Exercise {
    public int id;
    public String name;
    public String muscleGroup;
    public String description;

    public Exercise(int id, String name, String muscleGroup, String description) {
        this.id = id;
        this.name = name;
        this.muscleGroup = muscleGroup;
        this.description = description;
    }
}

