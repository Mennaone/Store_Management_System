package storemanagementsystem;

public class Users {

    protected String Name;
    protected static int ID_Start = 100;
    protected int ID;

    public Users() {
        this.Name = null;
    }

    public Users(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setID() {
        ID = ID_Start++;
    }

    public int getID() {
        return ID;
    }

}
