import login.welcome_page.WelcomePageGUIMaker;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        WelcomePageGUIMaker welcomePageGUIMaker = new WelcomePageGUIMaker();
        welcomePageGUIMaker.createGUI();
    }
}
