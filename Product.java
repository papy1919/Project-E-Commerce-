
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Product {
    String name;
    String category;
    String description;
    double price;
    Supplier supplier;
    int quantity;
    int id;
    int rating;
    int UsersRating0;
    int UsersRating1;
    int UsersRating2;
    int UsersRating3;
    int UsersRating4;
    int UsersRating5;
    Admin admin;

    public Product(String name, String category, double price, Supplier supplier, int id, Admin admin) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.supplier = supplier;
        this.quantity = quantity;
        this.id = id;
        this.admin = admin;
        this.rating = 0;
        this.UsersRating0 = 0;
        this.UsersRating1 = 0;
        this.UsersRating2 = 0;
        this.UsersRating3 = 0;
        this.UsersRating4 = 0;
        this.UsersRating5 = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public Supplier getSupplier() {
        return this.supplier;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getId() {
        return this.id;
    }

    public int getRating() {
        return this.rating;
    }

    public void updateRating() {
        (this.rating) = ((this.UsersRating1) + 2 * (this.UsersRating2) + 3 * (this.UsersRating3) + 4 * (this.UsersRating4) + 5 * (this.UsersRating5)) / (this.UsersRating0 + this.UsersRating1 + this.UsersRating2 + this.UsersRating3 + this.UsersRating4 + this.UsersRating5);
    }

    public void addRating(int rating) {
        if (rating == 0) {
            (this.UsersRating0) += 1;
        } else if (rating == 1) {
            (this.UsersRating1) += 1;
        } else if (rating == 2) {
            (this.UsersRating2) += 1;
        } else if (rating == 3) {
            (this.UsersRating3) += 1;
        } else if (rating == 4) {
            (this.UsersRating4) += 1;
        } else if (rating == 5) {
            (this.UsersRating5) += 1;
        }
        updateRating();
    }

    public void informAdmin(Admin admin) {
        System.out.println("The product " + this.name + " is out of stock.");

    }

    public boolean productBought() {
        if (this.quantity > 0) {
            this.quantity -= 1;
            return true;
        } else {
            informAdmin(admin);
            return false;
        }
    }

    public void modify()
    {
        System.out.println("Select what you want to modify:");
        System.out.println("1. Name");
        System.out.println("2. Category");
        System.out.println("3. Description");
        System.out.println("4. Price");
        System.out.println("5. Quantity");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter the new name:");
                scanner.nextLine();
                String name = scanner.nextLine();
                setName(name);
                break;
            case 2:
                System.out.println("Enter the new category:");
                scanner.nextLine();
                String category = scanner.nextLine();
                setCategory(category);
                break;
            case 3:
                System.out.println("Enter the new description:");
                scanner.nextLine();
                String description = scanner.nextLine();
                setDescription(description);
                break;
            case 4:
                System.out.println("Enter the new price:");
                double price = scanner.nextDouble();
                setPrice(price);
                break;
            case 5:
                System.out.println("Enter the new quantity:");
                int quantity = scanner.nextInt();
                setQuantity(quantity);
                break;
            default:
                System.out.println("Invalid input");
                modify();
                break;
        }
    }
    public void prouctReturned() {
        this.quantity += 1;
    }

    public abstract void showProduct();
}