import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Signing implements ISignUp {


    ArrayList<String> data = new ArrayList<String>();

    public static boolean isValidEmail(String email) {
        // I used chatgpt to generate this code
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
public void signUp() {
    System.out.println("Enter your username:");
    Scanner scanner = new Scanner(System.in);
    String username = scanner.nextLine();
    String e_mail;

    boolean isValidEmail = false;

    do {
        System.out.println("Enter your e-mail:");
        e_mail = scanner.nextLine();

        if (!isValidEmail(e_mail)) {
            System.out.println("Invalid email address");
        } else {
            isValidEmail = true;
        }
    } while (!isValidEmail);

    System.out.println("Enter your password:");
    String password = scanner.nextLine();

    data.add(username);
    data.add(password);
    data.add(e_mail);
}


}
