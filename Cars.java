public class Cars extends Product {
    String brand;
    String model;
    String color;
    int year;
    int km;
    String fuel;

    Cars(String name, String category, double price, Supplier supplier, int id, Admin admin, String marque, String model, String color, int year, int km, String fuel) {
        super(name, category, price, supplier, id, admin);
        this.brand = marque;
        this.model = model;
        this.color = color;
        this.year = year;
        this.km = km;
        this.fuel = fuel;
    }

    public void showProduct() {
        System.out.println("Type: Cars");
        System.out.println("Name: " + name);
        System.out.println("Category: " + category);
        System.out.println("Price: " + price);
        System.out.println("Supplier: " + supplier.getUsername());
        System.out.println("Quantity: " + quantity);
        System.out.println("Description: " + description);
        System.out.println("Marque: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Year: " + year);
        System.out.println("Km: " + km);
        System.out.println("Fuel: " + fuel);
        System.out.println("Rating: " + rating);

    }
}