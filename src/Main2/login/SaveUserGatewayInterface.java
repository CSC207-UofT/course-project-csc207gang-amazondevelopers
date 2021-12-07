package login;

import user.User;

import java.io.IOException;

/**
 * Interface used for Dependency
 */
public interface SaveUserGatewayInterface {
    void saveUser(String username, User userToBeSaved);
}
