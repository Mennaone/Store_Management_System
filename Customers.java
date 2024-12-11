package storemanagementsystem;

import java.util.ArrayList;

public class Customers extends Users {

    private int num_visits;
    private boolean special_cust;
    public ArrayList<Products> Purchaced;

    public Customers() {
        super(null);
        super.setID();
        num_visits = 0;
        special_cust = false;
        Purchaced = new ArrayList();
    }

    public Customers(String Name) {
        super(Name);
        super.setID();
        num_visits = 0;
        special_cust = false;
        Purchaced = new ArrayList();
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

    public void setVisits() {
        num_visits++;
    }

    public int getVisits() {
        return this.num_visits;
    }

    public boolean isSpecial_Cust() {
        if (num_visits > 2) {
            this.special_cust = true;
        }
        return this.special_cust;
    }

    public String getTypeCustomer() {
        if (isSpecial_Cust()) {
            return "Special Customer";
        }
        return "New Customer";
    }

    public void addPurchased(Products purch) {
        Purchaced.add(purch);
    }

    public double getPurchases() {
        double total = 0;
        for (int i = 0; i < Purchaced.size(); i++) {
            System.out.println(Purchaced.get(i).toString());
            total += Purchaced.get(i).getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return getTypeCustomer() + " : " + getName() + " (" + getID() + ") visits " + getVisits();
    }

}
