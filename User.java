import java.util.ArrayList;
import java.util.Scanner;

public class User implements Isearch {
    Isearch isearch;
    String e_mail;
    String password;
    String username;
    String address;
    Admin admin;
    ArrayList<Product> cart = new ArrayList <Product>();
    ArrayList<Order> ordersHistory = new ArrayList <Order>();
    double balance;
    double total;
    int id;

    public User(String e_mail, String password, String username, double balance, int id, String address, Admin admin, Isearch isearch) {
        this.e_mail = e_mail;
        this.password = password;
        this.username = username;
        this.balance = balance;
        this.id = id;
        this.total = 0;
        this.address = address;
        this.admin = admin;
        this.isearch = isearch;

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
        if (product.productBought() == true) {
            cart.add(product);
            System.out.println("This product is added to the cart.");
            updateTotalPlus(product.price);
        } else
            System.out.println("This product is not available.");
    }

    public void removeProduct(Product product) {
        if ((cart.contains(product)) == true) {
            cart.remove(product);
            updateTotalMinus(product.price);
            product.prouctReturned();
            System.out.println("This product is removed from the cart.");
        } else
            System.out.println("This product is not in the cart.");
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void updateTotalPlus(double price) {
        this.total += price;
    }

    public void updateTotalMinus(double price) {
        this.total -= price;
    }

    public void buyProducts() {
        if (cart.size() == 0)
            System.out.println("Your cart is empty.");
        else {
            if (this.balance >= this.total) {
                Order order = new Order();
                paymentMethod();
                this.balance -= this.total;


                for (int i = cart.size() - 1; i >= 0; i--) {
                    Product product = cart.get(i);
                    order.addProduct(product);
                    cart.remove(i);
                }

                ordersHistory.add(order);
            } else {
                System.out.println("You don't have enough money to buy the products.");
            }
        }
    }

    public void addRating(Product product, int rating) {
        product.addRating(rating);
    }
    public void rate(int id, int rating)
    {
        for (Product product : admin.products) {
            if (product.getId() == id) {
                addRating(product,rating);
            }
        }
    }

    public void showHistory() {
        int i = 0;
        for (Order order : ordersHistory) {
            System.out.println("Order " + i + ":");
            for (Product product : order.products) {
                product.showProduct();
            }
            i += 1;
        }
    }

    public void paymentMethod() {
        System.out.println("Choose your payment method:");
        System.out.println("1- Cash");
        System.out.println("2- Credit Card");
        Scanner Sc = new Scanner(System.in);
        int answer = Sc.nextInt();
        if (answer == 1) {
            System.out.println("You have chosen Cash.");
            System.out.println("Your order will be delivered in 3 days.");
            System.out.println("do you want to continue shopping (Y/N)");
            String answer2 = Sc.nextLine();
            if (answer2.equals("Y")) {
                menuUser();
            } else if (answer2.equals("N")) {
                System.out.println("Goodbye!");
            }

        } else if (answer == 2) {
            System.out.println("You have chosen Credit Card.");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your credit card number:");
            String creditCardNumber = scanner.nextLine();
            System.out.println("Enter your credit card password:");
            String creditCardPassword = scanner.nextLine();
            System.out.println("Enter your credit card CVV:");
            String creditCardCVV = scanner.nextLine();
            System.out.println("Enter your credit card expiration date:");
            String creditCardExpirationDate = scanner.nextLine();
            System.out.println("Enter your credit card owner name:");
            String creditCardOwnerName = scanner.nextLine();
            System.out.println("Enter your credit card owner surname:");
            String creditCardOwnerSurname = scanner.nextLine();
            System.out.println("Your credit card information is saved.");
            System.out.println("do you want to confirm the payment? (Y/N)");
            String answer2 = scanner.nextLine();
            if (answer2.equals("Y")) {
                System.out.println("Your payment is confirmed.");
                System.out.println("Your order will be delivered in 3 days.");
                Order order = new Order();
                for (int i = cart.size() - 1; i >= 0; i--) {
                    Product product = cart.get(i);
                    order.addProduct(product);
                    cart.remove(i);
                }
                ordersHistory.add(order);
                System.out.println("Your order"+order.id+" is saved in your history.");
                System.out.println("do you want to continue shopping (Y/N)");
                Sc.nextLine();
                String answer3 = Sc.nextLine();
                if (answer3.equals("Y")) {
                    menuUser();
                } else if (answer3.equals("N")) {
                    System.out.println("Goodbye!");
                }
            } else if (answer2.equals("N")) {
                System.out.println("Your payment is canceled.");
                System.out.println("do you want to continue shopping (Y/N)");
                Sc.nextLine();
                String answer3 = Sc.nextLine();
                if (answer3.equals("Y")) {
                    menuUser();
                } else if (answer3.equals("N")) {
                    System.out.println("Goodbye!");
                }
            }

        }
    }

    public void search() {
        isearch.search();
    }

    public void chooseProduct() {
        System.out.println("Enter the ID of the product you want to choose:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        int i = 0;
        for (Product product : admin.products) {
            i += 1;
            if (product.getId() == id) {
                addProduct(product);
            }
        }
        if (i == cart.size())
            System.out.println("This product is not in the system.");
    }


    public void menuUser() {
        System.out.println("Welcome " + username + "!");
        System.out.println("Please choose one of the following options:");
        int answer1 = 0;
        do {
            System.out.println("1. Search product");
            System.out.println("2. Choose product");
            System.out.println("3. Remove product");
            System.out.println("4. Buy products");
            System.out.println("5. Show history");
            System.out.println("6. See suggestions");
            System.out.println("7. Report a problem");
            System.out.println("8. Rate a product");
            System.out.println("9. Exit");
            Scanner scanner1 = new Scanner(System.in);
            answer1 = scanner1.nextInt();
            if (answer1 == 1) {
                search();
            } else if (answer1 == 2) {
                chooseProduct();
            } else if (answer1 == 3) {
                System.out.println("Enter the ID of the product you want to remove:");
                Scanner scanner = new Scanner(System.in);
                int id = scanner.nextInt();
                int i = 0;
                for (Product product : cart) {
                    i += 1;
                    if (product.getId() == id) {
                        removeProduct(product);
                    }
                }
                if (i == cart.size())
                    System.out.println("This product is not in the cart.");
            } else if (answer1 == 4) {
                buyProducts();
            } else if (answer1 == 5) {
                showHistory();
            } else if (answer1 == 6) {
                suggestions();
            } else if (answer1 == 7) {
                report();
            }
            else if (answer1==8)
            {
                System.out.println("Enter the ID of the product you want to rate:");
                Scanner scanner = new Scanner(System.in);
                int id = scanner.nextInt();
                System.out.println("Enter your rating:");
                int rating = scanner.nextInt();
                rate(id,rating);
            }
                else
            {if (answer1!=9)
                System.out.println("Please enter a valid number.");
                else
                System.out.println("Goodbye!");
            }
        } while (answer1 != 9);

    }


    public void suggestions() {
        ArrayList<Product> suggestions = new ArrayList<Product>();
        ArrayList<String> categories = new ArrayList<String>();
        for (Order order : ordersHistory) {
            for (Product product : order.products) {
                if (categories.contains(product.getCategory()) == false) {
                    categories.add(product.getCategory());
                }
            }
        }
        for (Product product : admin.products) {
            if (categories.contains(product.getCategory()) == true) {
                suggestions.add(product);
            }
        }
        System.out.println("Your suggestions:");
        for (Product product : suggestions) {
            product.showProduct();
        }
    }

    public void report()
    {
        System.out.println("What problem do you want to report?");
        System.out.println("1-Late Order");
        System.out.println("2-Product not delivered");
        System.out.println("3-Product not as described");
        System.out.println("4-Other");
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        if(answer==1)
        {System.out.println("Please enter your order ID");
        int orderID = scanner.nextInt();
        System.out.println("We are sorry for the inconvenience. Your order will be delivered as soon as possible.");
        }
        else if(answer==2)
        {System.out.println("Please enter your order ID");
            int orderID = scanner.nextInt();
            System.out.println("Please enter the product ID");
            int productID = scanner.nextInt();
            System.out.println("We are sorry for the inconvenience. Your Product will be delivered as soon as possible.");
        }
        else if(answer==3)
        {
            System.out.println("Please enter the product ID");
            int productID = scanner.nextInt();
            System.out.println("Please enter the problem");
            scanner.nextLine();
            String problem = scanner.nextLine();
            System.out.println("your complaint is being investigated.");
        }
        else if(answer==4)
        {
            System.out.println("Please enter the problem");
            scanner.nextLine();
            String problem = scanner.nextLine();
            System.out.println("your complaint is being investigated.");
        }

    }

}
