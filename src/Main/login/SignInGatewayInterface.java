package login;
import UserFunctions.User;
import java.io.IOException;

public interface SignInGatewayInterface {
    User getUser(String username) throws IOException, ClassNotFoundException;
}
