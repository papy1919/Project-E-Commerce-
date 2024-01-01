public class Accessories extends Product{
    String type;
    String color;
    String size;
    Accessories(String name, String category, double price, Supplier supplier, int id, Admin admin,String type,String color,String size) {
        super(name, category, price, supplier, id, admin);
        this.type=type;
        this.color=color;
        this.size=size;
    }
    public void showProduct(){
        System.out.println("Type: Accessories");
        System.out.println("Name: "+name);
        System.out.println("Category: "+category);
        System.out.println("Price: "+price);
        System.out.println("Supplier: "+supplier.getUsername());
        System.out.println("Quantity: "+quantity);
        System.out.println("Description: "+description);
        System.out.println("Type: "+type);
        System.out.println("Color: "+color);
        System.out.println("Size: "+size);
        System.out.println("Rating: "+rating);

    }
}
