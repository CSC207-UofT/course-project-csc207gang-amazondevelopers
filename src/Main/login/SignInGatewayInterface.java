package login;

import InputAndOutput.SystemInOut;
import UserFunctions.User;

import java.io.IOException;

public interface SignInGatewayInterface {
    public User getUser(String username) throws IOException, ClassNotFoundException;
}
