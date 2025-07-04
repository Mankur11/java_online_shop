import java.util.Scanner;

public class MenuController {
    private Scanner scanner;
    private LoginManager loginManager = LoginManager.getInstance();
    private RegistrationManager regManager = RegistrationManager.getInstance();

    public MenuController() {
        this.scanner = new Scanner(System.in);
    }

    public void startApplicationFlow() {
        MainMenu mainMenu = new MainMenu();

        while (true) {
            mainMenu.start();
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) break;
            if("menu".equalsIgnoreCase(input)) continue;

            handleMainMenuChoice(input);

            System.out.println();
        }
        scanner.close();
    }

    private void handleMainMenuChoice(String choice) {
        try {
            int option = Integer.parseInt(choice.trim());
            boolean isLoggedIn = loginManager.isLoggedIn();

            switch (option) {
                case 1:
                    if (isLoggedIn) {
                        System.out.println("Already signed in.");
                    } else {
                        new SignUpMenu().start();
                    }
                    break;
                case 2:
                    if (isLoggedIn) {
                        System.out.println("Have a nice day! Look forward to welcoming back!");
                        loginManager.logout();
                    } else {
                        handleLogin();
                    }
                    break;
                case 3:
                    new ProductCatalogMenu().start();
                    break;
                default:
                    System.out.println("Wrong option. Try one more time.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Only 1, 2, 3, 4, 5 is allowed. Try one more time.");
        }
    }

    private void handleLogin() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();

        if (loginManager.login(email, password)) {
        User user =  regManager.getUserByEmail(email);
            System.out.println("Glad to see you back " + user.getFirstName() + " " + user.getLastName());
        } else {
            System.out.println("Unfortunately, such login and password doesn’t exist’");
        }
    }
}
