package storemanagementsystem;

import java.util.ArrayList;

public class Store {

    private String Name;
    ArrayList<Customers> customers;
    ArrayList<Employees> employees;
    ArrayList<Products> products;

    public Store() {
        this.Name = null;
        customers = new ArrayList<Customers>();
        employees = new ArrayList<Employees>();
        products = new ArrayList<Products>();
    }

    public Store(String Name) {
        this.Name = Name;
        customers = new ArrayList<Customers>();
        employees = new ArrayList<Employees>();
        products = new ArrayList<Products>();
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    // IS Exist .....>> check if the choced product is already in the store
    public boolean isExist(String pro) {
        for (int i = 0; i < products.size(); i++) {
            if (pro.equals(products.get(i).getProd_Name())) {
                return true;
            }
        }
        return false;
    }

    // Add Products
    public void addProduct(Products newProduct) {
        if (products.size() == 100) {
            System.out.println("The Store is full !!!");
        } else {
            products.add(newProduct);
        }
    }

    // Remove Product
    public void removeProduct(String prod_Name) {
        if (products.isEmpty()) {
            System.out.println("The Store is empty !!!");
        } else {
            if (isExist(prod_Name)) {
                for (int i = 0; i < products.size(); i++) {
                    if (prod_Name.equals(products.get(i).getProd_Name())) {
                        products.remove(i);
                    }
                }
            } else {
                System.out.println("This Product is not exist !!!");
            }
        }
    }

    // Total Price
    public void totalPrice(int cust_ID) {
        double total = 0.0;
        double discount = 0.0;
        for (int i = 0; i < customers.size(); i++) {
            if (cust_ID == customers.get(i).getID()) {
                total = customers.get(i).getPurchases();
                if (customers.get(i).isSpecial_Cust()) {
                    discount = total * .25;
                    total -= discount;
                }
            }
        }
        System.out.printf("discount: % .2f $. \n", discount);
        System.out.printf("with total price: % .2f $. \n", total);
    }

    // Buy Products
    public void buyProducts(int cust_ID) {
        for (int i = 0; i < customers.size(); i++) {
            if (cust_ID == customers.get(i).getID()) {
                for (int j = 0; j < customers.get(i).Purchaced.size(); j++) {
                    removeProduct(customers.get(i).Purchaced.get(j).getProd_Name());
                }
            }
        }
    }

    // Print Products
    public void print_Products() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).toString());
        }
    }

    // Print Customers
    public void print_Customers() {
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i).toString());
        }
    }

    // Print Employees
    public void print_Employees() {
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).toString());
        }
    } 
    
    // Increase Salaries
    public void increase_Salaries(double perc) {
        for (int i = 0; i < employees.size(); i++) {
            employees.get(i).setNewSalary(perc);
        }
    }
      
    // Check Managers
    public boolean check_Managers(int emply_ID) {
        boolean state = false;
        for (int i = 0; i < employees.size(); i++) {
            if (emply_ID == employees.get(i).getID()) {
                if (employees.get(i).isManager()) {
                    state = true;
                }
            }
        }
        return state;
    }

    // Print Special Products
    public void print_SpecialProducts() {
        System.out.println("In IT the list of special products ");
        for (int i = 0; i < products.size(); i++) {
            if ("IT".equals(products.get(i).getKind())) {
                System.out.println(products.get(i).toString());
            }
        }
    }

}
