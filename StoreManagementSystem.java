package storemanagementsystem;

import java.util.Scanner;

public class StoreManagementSystem {

    public static void main(String[] args) {
        Store myStore = new Store("Perfect Store");
        System.out.println("\t\t\t\t Welcome in the " + myStore.getName());
        System.out.println("------------ Select Operations From Menu ----------------- ");

        try {
            Scanner input = new Scanner(System.in);
            int choice = 0;
            do {
                System.out.println("1- Products Managements ");
                System.out.println("2- Users Managements ");
                System.out.println("3- Buy Products ");
                System.out.println("4- Show Special Products ");
                System.out.println("5- Exit ");

                System.out.print(">>>");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        int s1 = 0;
                        do {
                            System.out.println("-------------- Products Managements -------------------");
                            System.out.println("1- Add Product ");
                            System.out.println("2- Remove Product");
                            System.out.println("3- Print Products ");
                            System.out.println("4- Back to Main Menu");
                            System.out.print(">>> ");
                            s1 = input.nextInt();
                            switch (s1) {
                                case 1:
                                    System.out.println("product name: ");
                                    String prod_Name = input.next();
                                    System.out.println("product price: ");
                                    double price = input.nextDouble();
                                    System.out.println("product kind: ");
                                    String kind = input.next();
                                    Products product = new Products(prod_Name, price, kind);
                                    myStore.addProduct(product);
                                    break;
                                case 2:
                                    System.out.println("enter employee id: ");
                                    int id = input.nextInt();
                                    if (myStore.check_Managers(id)) {
                                        System.out.println("enter product name: ");
                                        prod_Name = input.next();
                                        myStore.removeProduct(prod_Name);
                                        System.out.println("Successfully Remove Operation !!!");
                                    } else {
                                        System.out.println("Employee is not a manager that can't remove products !!!");
                                    }
                                    break;
                                case 3:
                                    if (myStore.products.isEmpty()) {
                                        System.out.println("Store is Empty !!!");
                                    } else {
                                        System.out.println("Products in Store: ");
                                        myStore.print_Products();
                                    }
                                    break;
                            }

                        } while (s1 != 4);
                        break;
                    case 2:
                        int s2 = 0;
                        do {
                            System.out.println("---------- Users Managements ---------------");
                            System.out.println("1- Add Customer ");
                            System.out.println("2- Add Employee ");
                            System.out.println("3- Update Employee ");
                            System.out.println("4- Print Users");
                            System.out.println("5- Back to Main Menu ");
                            System.out.print(">>> ");
                            s2 = input.nextInt();
                            switch (s2) {
                                case 1:
                                    System.out.println("Customer name: ");
                                    String cus_Name = input.next();
                                    Customers new_Customer = new Customers(cus_Name);
                                    myStore.customers.add(new_Customer);
                                    break;
                                case 2:
                                    System.out.println("Employee name: ");
                                    String emp_Name = input.next();

                                    System.out.println("Employee Salary: ");
                                    double salary = input.nextDouble();
                                    System.out.println("Is Employee a manager? (1:yes) , (2:no)  ");
                                    int x = input.nextInt();
                                    String type;
                                    if (x == 1) {
                                        type = "Manager";
                                    } else {
                                        type = null;
                                    }
                                    Employees new_Employee = new Employees(emp_Name, salary, type);
                                    myStore.employees.add(new_Employee);
                                    break;
                                case 3:
                                    System.out.println("enter the percent of increaseing salaries: ");
                                    double per = input.nextDouble();
                                    myStore.increase_Salaries(per);
                                    break;
                                case 4:
                                    if (myStore.customers.isEmpty() && myStore.employees.isEmpty()) {
                                        System.out.println("There are no users Now !!!");
                                    } else {
                                        System.out.println("List of Users: ");
                                        myStore.print_Customers();
                                        myStore.print_Employees();
                                    }
                                    break;
                            }
                            
                        }while (s2 != 5);
                        break;
                    case 3:
                        int s3 = 0;
                        int n = 0;
                        System.out.println("enter customer id: ");
                        int cust_id = input.nextInt();
                        for (int i = 0; i < myStore.customers.size(); i++) {
                            if (cust_id == myStore.customers.get(i).getID()) {
                                System.out.println(myStore.customers.get(i).toString());
                                while (s3 != -1) {
                                    System.out.print("enter product id: ");
                                    int prod_id = input.nextInt();
                                    for (int j = 0; j < myStore.products.size(); j++) {
                                        if (prod_id == myStore.products.get(j).getID()) {
                                            System.out.println(myStore.products.get(j).toString());
                                            myStore.customers.get(i).addPurchased(myStore.products.get(j));
                                            n = i;
                                            break;
                                        } else if (prod_id != myStore.products.get(j).getID()) {
                                            System.out.println("Product is not found in the store !!!");
                                            break;
                                        }
                                    }
                                    System.out.println("enter 0 to buy another product or -1 to finish: ");
                                    s3 = input.nextInt();
                                }
                            }
                        }
                        System.out.println(myStore.customers.get(n).getTypeCustomer());
                        System.out.println(" bought : ");
                        myStore.totalPrice(cust_id);
                        myStore.buyProducts(cust_id);
                        myStore.customers.get(n).setVisits();
                        myStore.customers.get(n).Purchaced.clear();
                        break;
                    case 4:
                        System.out.println("----------- Special Products ------------");
                        myStore.print_SpecialProducts();
                        break;

                }
                System.out.println("****************************************");
            } while (choice != 5);

        } catch (Exception e) {
            System.out.println("Invalid Input !!!");
        }
        
        System.out.println("We Hope to See You Again ");
    }

}
