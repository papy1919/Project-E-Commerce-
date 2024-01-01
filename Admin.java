import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class Admin implements Isearch {
    Isearch isearch=new Searchable(this);

    String e_mail;
    String password;
    String username;
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<Product> products = new ArrayList<Product>();
    ArrayList<Supplier> suppliers = new ArrayList<Supplier>();


    public Admin(String e_mail, String password, String username) {
        this.e_mail = e_mail;
        this.password = password;
        this.username = username;

    }
    void adding(Product product)
    {
        products.add(product);
    }
    void addsup(Supplier supplier)
    {
        suppliers.add(supplier);
    }

    void modifyProduct(Product product)
    {
        product.modify();
    }


    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getE_mail() {
        return e_mail;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void addUser(User user) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Do you want to add this user to the system? (Y/N)");
        String answer = Sc.nextLine();
        if (answer.equals("Y")) {
            users.add(user);
        }
    }

    public void removeUser(User user) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Do you want to remove this user from the system? (Y/N)");
        String answer = Sc.nextLine();
        if (answer.equals("Y")) {
            users.remove(user);
        }
    }

    public void addProduct(Product product) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Do you want to add this product to the system? (Y/N)");
        String answer = Sc.nextLine();
        if (answer.equals("Y")) {
            products.add(product);
        }
    }

    public void removeProduct(Product product) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Do you want to remove this product from the system? (Y/N)");
        String answer = Sc.nextLine();
        if (answer.equals("Y")) {
            products.remove(product);
        }
    }

    public void addSupplier(Supplier supplier) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Do you want to add this supplier to the system? (Y/N)");
        String answer = Sc.nextLine();
        if (answer.equals("Y")) {
            suppliers.add(supplier);
        }
    }


public void search()
{
    isearch.search();
}
    public void menuAdmin() {
        System.out.println("Welcome " + username + "!");
        request();
        System.out.println("Please choose one of the following options:");

        int answer1 = 0;
        Product product = null;

        do {
            System.out.println("1. Add product");
            System.out.println("2. Remove product");
            System.out.println("3. Add supplier");
            System.out.println("4. Search product");
            System.out.println("5. Show all products");
            System.out.println("6. Modify product");
            System.out.println("7. Exit");

            Scanner scanner1 = new Scanner(System.in);
            answer1 = scanner1.nextInt();

            if (answer1 == 1) {
                System.out.println("Enter the name of the product:");
                Scanner scanner = new Scanner(System.in);
                String name = scanner.nextLine();
                System.out.println("Enter the category of the product:");
                String category = scanner.nextLine();
                System.out.println("Enter the price of the product:");
                double price = scanner.nextDouble();
                System.out.println("Enter the ID of the product:");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter the username of supplier of the product:");
                String username = scanner.nextLine();
                Supplier productSupplier = null;

                for (Supplier supplier : suppliers) {
                    if (supplier.getUsername().equals(username)) {
                        productSupplier = supplier;
                        break;
                    }
                }

                if (productSupplier == null) {
                    productSupplier = new Supplier(username);
                }

                System.out.println("Choose the type of the product:");
                System.out.println("1. Smartphones");
                System.out.println("2. Accessories");
                System.out.println("3. Cars");
                int type = scanner.nextInt();

                if (type == 1) {
                    System.out.println("Enter the brand of the smartphone:");
                    scanner.nextLine();
                    String brand = scanner.nextLine();
                    System.out.println("Enter the model of the smartphone:");
                    String model = scanner.nextLine();
                    product = new Smartphone(name, category, price, productSupplier, id, this, brand, model);
                } else if (type == 2) {
                    System.out.println("Enter the Type of the accessory:");
                    scanner.nextLine();
                    String typeAccessory = scanner.nextLine();
                    System.out.println("Enter the size of the accessory:");
                    String size = scanner.nextLine();
                    System.out.println("Enter the color of the accessory:");
                    String color = scanner.nextLine();
                    product = new Accessories(name, category, price, productSupplier, id, this, typeAccessory, color, size);
                } else if (type == 3) {
                    System.out.println("Enter the brand of the car:");
                    scanner.nextLine();
                    String brand = scanner.nextLine();
                    System.out.println("Enter the model of the car:");
                    String model = scanner.nextLine();
                    System.out.println("Enter the color of the car:");
                    String color = scanner.nextLine();
                    System.out.println("Enter the year of the car:");
                    int year = scanner.nextInt();
                    System.out.println("Enter the km of the car:");
                    int km = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the fuel of the car:");
                    String fuel = scanner.nextLine();
                    product = new Cars(name, category, price, productSupplier, id, this, brand, model, color, year, km, fuel);
                } else {
                    System.out.println("Please enter a valid number.");
                }

                System.out.println("Enter the quantity you want to add of the product:");
                int quantity = scanner.nextInt();
                product.setQuantity(quantity);
                scanner.nextLine();
                System.out.println("Enter the description of the product:");
                String description = scanner.nextLine();
                product.setDescription(description);
                addProduct(product);
            } else if (answer1 == 2) {
                System.out.println("Enter the ID of the product:");
                Scanner scanner = new Scanner(System.in);
                int id = scanner.nextInt();

                Iterator<Product> iterator = products.iterator();
                while (iterator.hasNext()) {
                    Product p = iterator.next();
                    if (p.getId() == id) {
                        iterator.remove();
                        break;
                    }
                }
            } else if (answer1 == 3) {
                System.out.println("Enter the username of the supplier:");
                Scanner scanner = new Scanner(System.in);
                String username = scanner.nextLine();
                for (Supplier supplier : suppliers) {
                    if (supplier.getUsername().equals(username)) {
                        addSupplier(supplier);
                    }
                }
            }

        else if (answer1 == 4) {
                isearch.search();
            } else if (answer1 == 5) {
                for (Product p : products) {
                    p.showProduct();
                }
            }
            else if(answer1==6)
            {
                System.out.println("Enter the ID of the product:");
                Scanner scanner = new Scanner(System.in);
                int id = scanner.nextInt();

                Iterator<Product> iterator = products.iterator();
                while (iterator.hasNext()) {
                    Product p = iterator.next();
                    if (p.getId() == id) {
                        modifyProduct(p);

                    }
                }
            }
            else {
                if (answer1 != 7)
                    System.out.println("Please enter a valid number.");
            }

        } while (answer1 != 7);
    }




    public void request(){
        for (Product product1:products){
            if(product1.getQuantity()==0)
            {
                System.out.println("The product "+product1.getName()+" is out of stock.");
                System.out.println("Do you want to add this product to the system? (Y/N)");
                Scanner Sc = new Scanner(System.in);
                String answer = Sc.nextLine();
                if (answer.equals("Y")) {
                    System.out.println("Enter the quantity you want the supplier to add:");
                    Scanner scanner = new Scanner(System.in);
                    int quantity = scanner.nextInt();
                    product1.setQuantity(quantity);
                }
            }
        }
    }
}
