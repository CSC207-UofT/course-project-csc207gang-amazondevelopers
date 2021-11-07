import InputAndOutput.SystemInOut;
import login.LoginGateway;

import java.io.IOException;

public class Main{

    public static void main(String[] args) throws IOException {
        SystemInOut inOut = new SystemInOut();
        LoginGateway initialLogin = new LoginGateway();
        initalLogin.userLoginDecision(inOut);
        try{
            if (loginDecision == 1){
                loginController

        }catch (IOException e){
            inOut.sendOutput("error occurred");
        }




        }
    }
}