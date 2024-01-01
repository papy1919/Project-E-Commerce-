
import java.util.Scanner;
public class Menu {
    public static void menu() {
        System.out.println("Welcome to the online shopping system!");
        System.out.println("Please choose one of the following options:");
        System.out.println("1. Admin");
        System.out.println("2. Supplier");
        System.out.println("3. User");
        Scanner Sc = new Scanner(System.in);
        int answer = Sc.nextInt();
        if (answer == 1) {
            ILogin ilogin= new Loging();
            ilogin.login();
            String username = ((Loging) ilogin).data.get(0);
            String password = ((Loging) ilogin).data.get(1);
            String e_mail = ((Loging) ilogin).data.get(2);


            Admin admin = new Admin(username, password, e_mail);
            Supplier supplier = new Supplier("supplier");
            supplier.setE_mail("supplier");
            supplier.setPassword("supplier");
            Supplier supplier1 = new Supplier("supplier1");
            supplier1.setE_mail("supplier1");
            supplier1.setPassword("supplier1");

            Smartphone product1 = new Smartphone("product1", "category1",  100, supplier ,10, admin,"Samsung","A14");
            product1.setQuantity(10);
            Smartphone product2 = new Smartphone("product2", "category2", 200, supplier1 , 20, admin,"Apple","Iphone 12");

            admin.addsup(supplier);
            admin.addsup(supplier1);
            admin.adding(product1);
            admin.adding(product2);

            admin.menuAdmin();
        }
        if (answer==2)
        {

            Admin admin=new Admin("admin","admin","admin");

            System.out.println("Do you want to login or sign in?");
            System.out.println("1- Login");
            System.out.println("2- Sign in");
            Scanner scanner = new Scanner(System.in);
            int answer2 = scanner.nextInt();
            if (answer2==1)
            {
                ILogin ilogin = new Loging();
                ilogin.login();
                String username = ((Loging) ilogin).data.get(0);
                String password = ((Loging) ilogin).data.get(1);
                String e_mail = ((Loging) ilogin).data.get(2);
                Supplier supplier = new Supplier(username);
                supplier.setE_mail(e_mail);
                supplier.setPassword(password);
                Smartphone product1 = new Smartphone("product1", "category1",  100, supplier ,10, admin,"Samsung","A14");
                Smartphone product2 = new Smartphone("product2", "category1",  1040, supplier ,12, admin,"Samsung","A50");
                Smartphone product3 = new Smartphone("product3", "category1",  1200, supplier ,104, admin,"Iphone","13 Pro");
                Smartphone product4 = new Smartphone("product4", "category1",  120, supplier ,150, admin,"Samsung","s30");
                supplier.addProduct(product1);
                supplier.addProduct(product2);
                supplier.addProduct(product3);
                supplier.addProduct(product4);
                supplier.menuSupplier();
            }
            else if (answer2==2)
            {
                ISignUp isignup = new Signing();
                isignup.signUp();
                String username = ((Signing) isignup).data.get(0);
                String password = ((Signing) isignup).data.get(1);
                String e_mail = ((Signing) isignup).data.get(2);
                Supplier supplier = new Supplier(username);
                supplier.setE_mail(e_mail);
                supplier.setPassword(password);
                supplier.menuSupplier();
            }

        }
        else if (answer==3)
        {


            Admin admin=new Admin("admin","admin","admin");
            Supplier supplier = new Supplier("supplier");
            supplier.setE_mail("supplier");
            supplier.setPassword("supplier");
            Supplier supplier1 = new Supplier("supplier1");
            supplier1.setE_mail("supplier1");
            supplier1.setPassword("supplier1");

            Smartphone product1 = new Smartphone("product1", "category1",  100,  supplier ,10, admin,"Samsung","A14");
            product1.setQuantity(10);
            Smartphone product2 = new Smartphone("product2", "category2", 200, supplier , 20, admin,"Apple","Iphone 12");
            product2.setQuantity(70);
            Cars product3 = new Cars("product3", "category3", 300,supplier1, 30, admin,"BMW","X5","Black",2020,40000,"Automatic");
            product3.setQuantity(140);
            Cars product4 = new Cars("product4", "category4",  400, supplier1, 40, admin,"Mercedes","S500","White",2019,50000,"Manual");
            Accessories product5 = new Accessories("product5", "category5",  500, supplier, 50, admin,"Headphones","white","normal");
            product5.setQuantity(10);
           Accessories product6 = new Accessories("product6", "category6",  600, supplier1, 60, admin,"Earrings","black","normal");
            admin.addsup(supplier);
            admin.addsup(supplier1);
            admin.adding(product1);
            admin.adding(product2);
            admin.adding(product3);
            admin.adding(product4);
            admin.adding(product5);
            admin.adding(product6);
            System.out.println("Do you want to login or sign in?");
            System.out.println("1- Login");
            System.out.println("2- Sign in");
            Scanner scanner = new Scanner(System.in);
            int answer2 = scanner.nextInt();
            if (answer2==1)
            {
                Isearch isearch=new Searchable(admin);
                ILogin ilogin = new Loging();
                ilogin.login();
                String username = ((Loging) ilogin).data.get(0);
                String password = ((Loging) ilogin).data.get(1);
                String e_mail = ((Loging) ilogin).data.get(2);
                User user = new User (e_mail,password,username,11585622,11,"udzehufh",admin,isearch);


                user.menuUser();
            }
            else if (answer2==2)
            {

                ISignUp isignup = new Signing();
                isignup.signUp();
                String username = ((Signing) isignup).data.get(0);
                String password = ((Signing) isignup).data.get(1);
                String e_mail = ((Signing) isignup).data.get(2);
                System.out.println("Enter your address:");
                Scanner scanner1 = new Scanner(System.in);
                String address = scanner1.nextLine();
                System.out.println("Enter your balance:");
                Scanner scanner2 = new Scanner(System.in);
                double balance = scanner2.nextDouble();
                System.out.println("Enter your id:");
                Scanner scanner3 = new Scanner(System.in);
                int id = scanner3.nextInt();
                Isearch isearch=new Searchable(admin);
                User user = new User (e_mail,password,username,balance,id,address,admin,isearch);

                user.menuUser();
            }
        }
    }
}