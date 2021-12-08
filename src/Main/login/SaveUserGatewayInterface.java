package login;

import user.User;


/**
 * Interface used for Dependency
 */
public interface SaveUserGatewayInterface {
    void saveUser(String username, User userToBeSaved);
}
