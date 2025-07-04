public class MainMenu implements Menu {

    private LoginManager loginManager = LoginManager.getInstance();
    private static final String MAIN_MENU_HEADER_TEXT = "***** MAIN MENU *****";

	private static final String MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER = "Please, enter number in console to proceed." + System.lineSeparator()
			+ "1. Sign Up" + System.lineSeparator() + "2. Sign In"
			+ System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
			+ "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() + 
			"6. Customer List";

	private static final String MAIN_MENU_TEXT_FOR_LOGGED_IN_USER = "Please, enter number in console to proceed." + System.lineSeparator()
			+ "1. Sign Up" + System.lineSeparator() + "2. Sign Out"
			+ System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
			+ "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() + 
			"6. Customer List";;

	@Override
	public void start() {
        printMenuHeader();
      if (loginManager.isLoggedIn()) {
            System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_IN_USER);
        } else {
            System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER);
        }
	}

	@Override
	public void printMenuHeader() {
		System.out.println(MAIN_MENU_HEADER_TEXT);
	}

    
}
