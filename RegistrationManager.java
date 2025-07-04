import java.util.HashMap;
import java.util.Map;

public class RegistrationManager {
    private static RegistrationManager instance;
    
    private Map<String, User> registeredUsers = new HashMap<>();

    private RegistrationManager() {
        // private constructor to prevent instantiation
    }

    public static synchronized RegistrationManager getInstance() {
        if (instance == null) {
            instance = new RegistrationManager();
        }
        return instance;
    }

    public boolean register(String firstName, String lastName, String email, String password) {
        if (registeredUsers.containsKey(email)) {
            return false;
        }
        User newUser = new User(firstName, lastName, email, password);
        registeredUsers.put(email, newUser);
        return true;
    }

    public boolean isUserExists(String email) {
        return registeredUsers.containsKey(email);
    }

    public boolean validateCredentials(String email, String password) {
        User user = registeredUsers.get(email);
        return user != null && password.equals(user.getPassword());
    }

    public User getUserByEmail(String email) {
        return registeredUsers.get(email);
    }
}
