import java.util.Scanner;

public class Searchable implements Isearch{
    Admin admin;
    public Searchable(Admin admin) {
        this.admin=admin;
    }
    public void search()
    {
            System.out.println("choose your filter:");
            System.out.println("1- Type");
            System.out.println("2- Name");
            System.out.println("3- Category");
            System.out.println("4- Supplier");
            System.out.println("5- Price");
            System.out.println("6- Rating");
            Scanner Sc = new Scanner(System.in);
            int answer = Sc.nextInt();
            if(answer==1) {
                System.out.println("Choose the type of the product:");
                System.out.println("1-Smartphones");
                System.out.println("2-Accessories");
                System.out.println("3-Cars");
                Scanner scanner = new Scanner(System.in);
                int type = scanner.nextInt();
                if (type == 1) {
                    for (Product product : admin.products) {
                        if (product instanceof Smartphone) {
                            product.showProduct();
                        }
                    }
                }
                else if (type == 2) {
                    for (Product product : admin.products) {
                        if (product instanceof Accessories ) {
                            product.showProduct();
                        }
                    }
                }
                else if (type == 3) {
                    for (Product product : admin.products) {
                        if (product instanceof Cars) {
                            product.showProduct();
                        }
                    }
                }
            }
            else if (answer == 2) {
                System.out.println("Enter the name of the product:");
                Scanner scanner = new Scanner(System.in);
                String name = scanner.nextLine();
                for (Product product : admin.products) {
                    if (product.getName().contains(name)) {
                        product.showProduct();
                    }
                }
            } else if (answer == 3) {
                System.out.println("Enter the category of the product:");
                Scanner scanner = new Scanner(System.in);
                String category = scanner.nextLine();
                for (Product product : admin.products) {
                    if (product.getCategory().contains(category)) {
                        product.showProduct();
                    }
                }
            } else if (answer == 4) {
                System.out.println("Enter the supplier of the product:");
                Scanner scanner = new Scanner(System.in);
                String supplier = scanner.nextLine();
                for (Product product : admin.products) {
                    if ((product.getSupplier()).getUsername().contains(supplier)) {
                        product.showProduct();
                    }
                }
            } else if (answer == 5) {
                System.out.println("Enter the maximum price of the product:");
                Scanner scanner = new Scanner(System.in);
                double pricemax = scanner.nextDouble();
                System.out.println("Enter the minimum price of the product:");
                double pricemin = scanner.nextDouble();
                for (Product product : admin.products) {
                    if ((pricemin<=product.getPrice()) && (product.getPrice() <= pricemax)) {
                        product.showProduct();
                    }

                }

            }

        }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}

