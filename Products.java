
package storemanagementsystem;


public class Products {
    private String prod_Name;
    private double price;
    static int ID_Product = 0;
    private int ID;
    private String kind;
    
    public Products(){
        this.prod_Name =null;
        this.price =0;
        this.kind = null;
        setID();      
    }

    public Products(String prod_Name, double price, String kind) {
        this.prod_Name = prod_Name;
        this.price = price;
        this.kind = kind;
        setID();
    }

    public String getProd_Name() {
        return prod_Name;
    }

    public void setProd_Name(String prod_Name) {
        this.prod_Name = prod_Name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
    
    public void setID(){
        this.ID = ID_Product++;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Products "+"("+getID()+")"+ getProd_Name()+" costs "+ getPrice()+"$." ;
    }
    
    
}
