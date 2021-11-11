package login;

import InputAndOutput.SystemInOut;

import java.io.IOException;

public interface SignInControllerInterface {

    String getUsername(SystemInOut inOut) throws IOException;
}
