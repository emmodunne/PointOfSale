public class Employee {
    private String Id;
    private String employeeName;

    public Employee (String Id, String employeeName){
        this.Id = Id;
        this.employeeName = employeeName;
    }

    public String getId() {
        return Id;
    }

    @Override
    public String toString()
    {
        return employeeName;
    }
}
