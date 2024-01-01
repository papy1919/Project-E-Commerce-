public class Smartphone extends Product{
    String brand;
    String model;

    public Smartphone(String name, String category, double price, Supplier supplier, int id, Admin admin,String brand,String model) {
        super(name, category, price, supplier, id, admin);
        this.brand=brand;
        this.model=model;
    }
    public void showProduct(){
        System.out.println("Type: Smartphone");
        System.out.println("Name: "+name);
        System.out.println("Category: "+category);
        System.out.println("Price: "+price);
        System.out.println("Supplier: "+supplier.getUsername());
        System.out.println("Quantity: "+quantity);
        System.out.println("Description: "+description);
        System.out.println("Marque: "+brand);
        System.out.println("Model: "+model);
        System.out.println("Rating: "+rating);

    }
}
