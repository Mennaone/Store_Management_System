package storemanagementsystem;

public class Employees extends Users {

    private double salary;
    private String emplyee_Type;

    public Employees() {
        super.setName(null);
        super.setID();
        this.salary = 0;
        this.emplyee_Type = null;
    }

    public Employees(String Name, double salary, String emplyee_Type) {
        super(Name);
        this.salary = salary;
        this.emplyee_Type = emplyee_Type;
        super.setID();
    }

    @Override
    public void setName(String Name) {
        super.Name = Name;
    }

    @Override
    public String getName() {
        return super.Name;
    }

    @Override
    public int getID() {
        return super.ID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmplyee_Type() {
        return emplyee_Type;
    }

    public void setEmplyee_Type(String emplyee_Type) {
        this.emplyee_Type = emplyee_Type;
    }

    public void setNewSalary(double percent) {
        this.salary = salary + (salary * percent);
    }

    public boolean isManager() {
        boolean type = false;
        if (emplyee_Type.equals("Manager")) {
            type = true;
        }
        return type;
    }

    @Override
    public String toString() {
        return "Employee " + "(" + getEmplyee_Type() + ")" + getName() + " " + "(" + getID() + ")" + " has " + getSalary() + "$.";
    }

}
