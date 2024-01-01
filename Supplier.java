
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Supplier {
    String e_mail;
    Admin admin;
    String password;
    String username;
    ArrayList<Product> products = new ArrayList<Product>();
    float payment = 0;

    public Supplier(String username) {
        this.username = username;
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

    public void addProduct(Product product) {
        products.add(product);
    }
    void modifyProduct(Product product)
    {
        product.modify();
    }


    public void removeProduct(Product product) {
        if ((products.contains(product)) == false)
            products.remove(product);
        else
            System.out.println("This product is already in the system.");
    }


    public void menuSupplier() {
        System.out.println("Welcome to the online shopping system!");


        int answer;
        do {
            System.out.println("Please choose one of the following options:");
            System.out.println("1- add product");
            System.out.println("2. check requests");
            System.out.println("3- check your products");
            System.out.println("4- Exit");

            Scanner Sc = new Scanner(System.in);
            answer = Sc.nextInt();
            if(answer==1) {
                Product product= null;
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
                    product = new Smartphone(name, category, price, this, id, admin, brand, model);
                } else if (type == 2) {
                    System.out.println("Enter the Type of the accessory:");
                    scanner.nextLine();
                    String typeAccessory = scanner.nextLine();
                    System.out.println("Enter the size of the accessory:");
                    String size = scanner.nextLine();
                    System.out.println("Enter the color of the accessory:");
                    String color = scanner.nextLine();
                     product = new Accessories(name, category, price, this, id, admin, typeAccessory, color, size);
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
                     product = new Cars(name, category, price, this, id, admin, brand, model, color, year, km, fuel);
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
            }

            else if (answer == 2) {
                if (products.isEmpty())
                    System.out.println("You don't have any products.");
                else {
                    for (Product product : products) {
                        if (product.getQuantity() == 0) {
                            System.out.println("The product " + product.getName() + " is out of stock");
                            System.out.println("Do you want to add more of this product? (Y/N)");
                            Sc.nextLine();
                            String answer2 = Sc.nextLine();

                            if (answer2.equalsIgnoreCase("Y")) {
                                System.out.println("Enter the quantity you want to add for " + product.getName() + ":");
                                int quantity = Sc.nextInt();

                                product.setQuantity(quantity);
                                payment += quantity * product.getPrice();
                            }
                        }
                    }

                    System.out.println("Do you want to proceed to payment? (Y/N)");
                    Sc.nextLine();
                    String answer3 = Sc.nextLine();

                    if (answer3.equalsIgnoreCase("Y")) {
                        System.out.println("Your payment is " + payment);
                        System.out.println("Enter your credit card number:");
                        String creditcard = Sc.nextLine();
                        System.out.println("Enter your credit card password:");
                        String creditcardpassword = Sc.nextLine();
                        System.out.println("Your payment is done successfully");
                    }
                }
            }
            else if ((answer) == 3) {
                for (Product product : products) {
                    product.showProduct();
                }
            }

            else if(answer==6)
                System.out.println("Thank you for using our online shopping system.");
            else{
                if(answer!=4)
                    System.out.println("Please enter a valid number.");
            }
        }
        while (answer != 4);
    }
}
