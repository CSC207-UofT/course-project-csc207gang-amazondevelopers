package login_functions;

import user.User;

import java.io.IOException;

public interface SaveUserGatewayInterface {
    void saveUser(String username, User userToBeSaved) throws IOException, ClassNotFoundException;
}
