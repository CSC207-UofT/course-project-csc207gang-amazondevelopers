package login.sign_in;

import user.User;

import java.io.IOException;

/**
 * Interface used in Dependency Injection Design pattern for SignInGateway
 */
public interface SignInGatewayInterface {
    User getUser(String username) throws IOException, ClassNotFoundException;
}
