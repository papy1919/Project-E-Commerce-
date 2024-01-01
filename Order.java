import java.util.ArrayList;
public class Order {
    static int i=0;
    int id;
    Order(){
        i++;
        id=i;

    }
    ArrayList<Product> products = new ArrayList<Product>();


    public void addProduct(Product product) {
        products.add(product);
    }


}
