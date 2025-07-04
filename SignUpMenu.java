import java.util.Scanner;

public class SignUpMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private RegistrationManager regManager = RegistrationManager.getInstance();
    private LoginManager loginManager = LoginManager.getInstance();

    @Override
    public void start() {
        printMenuHeader();
        
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine().trim();
        
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine().trim();
        
        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim();
        
        if (regManager.isUserExists(email)) {
            System.out.println("This email is already used by another user. Please, use another email");
            return;
        }

        if(email.length() == 0) {
            System.out.println("You have to input email to register. Please, try one more time");
            return;
        }
        
        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();
        
        if (regManager.register(firstName, lastName, email, password)) {
            System.out.println("New user is created");
            
            // Auto-login after registration
            if (loginManager.login(email, password)) {
                System.out.println("You're now logged in as " + email);
            }
        } else {
            System.out.println("Registration failed.");
        }
    }
    
    @Override
    public void printMenuHeader() {
        System.out.println("***** SIGN UP *****");
    }
}
