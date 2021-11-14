package login;

import UserFunctions.User;

import java.io.IOException;

public interface GetUserGatewayInterface {
    User getUser(String username) throws IOException, ClassNotFoundException;
}
