package login;

import InputAndOutput.SystemInOut;

import java.io.IOException;

public interface SignUpGatewayInterface {
    public void allowSignUp(String username) throws IOException, ClassNotFoundException;
}
