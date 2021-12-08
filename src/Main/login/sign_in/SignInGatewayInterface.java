package login.sign_in;

import user.User;

/**
 * Interface used in Dependency Injection Design pattern for SignInGateway
 */
public interface SignInGatewayInterface {
    User getUser(String username);
}
