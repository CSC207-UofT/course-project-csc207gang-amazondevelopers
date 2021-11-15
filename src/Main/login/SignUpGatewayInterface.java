package login;
import UserFunctions.User;
import java.io.IOException;

public interface SignUpGatewayInterface {
    void allowSignUp(String username, User user) throws IOException, ClassNotFoundException;
}


