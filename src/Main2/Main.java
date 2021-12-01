public class Main {
    public static void main(String[] args) {
        IDandPasswords iDandPasswords = new IDandPasswords();

        WelcomePageController welcomePageController = new WelcomePageController(iDandPasswords.getLoginInfo());

    }
}
