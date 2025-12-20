package Models.Ergast;

public class MRData<T> {
    public String xmlns;
    public String series;
    public String url;
    public String limit;
    public String offset;
    public String total;
    public T RaceTable;  // T perchè può essere RaceTable, DriverTable, ConstructorTable
}
