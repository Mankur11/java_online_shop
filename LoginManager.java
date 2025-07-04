public class LoginManager {
    private static LoginManager instance;
    private UserSession activeSession = null;

    private LoginManager() {}

    public static synchronized LoginManager getInstance() {
        if (instance == null) {
            instance = new LoginManager();
        }
        return instance;
    }

    public boolean login(String email, String password) {
        if (activeSession != null) return false;
        
        RegistrationManager regManager = RegistrationManager.getInstance();
        if (regManager.validateCredentials(email, password)) {
            activeSession = new UserSession(email);
            return true;
        }
        return false;
    }

    public void logout() {
        activeSession = null;
    }

    public boolean isLoggedIn() {
        return activeSession != null;
    }
    
    public String getCurrentUserEmail() {
        return activeSession != null ? activeSession.getEmail() : null;
    }
}
