import InputAndOutput.SystemInOut;
import login.WelcomePageGateway;

import java.io.IOException;

public class Main{

    public static void main(String[] args) throws IOException {
        SystemInOut inOut = new SystemInOut();
        login.WelcomePageGateway initialLogin = new login.WelcomePageGateway();
        initialLogin.userLoginDecision(inOut);

        }
    }
