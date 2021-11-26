package login;
import InputAndOutput.InOut;
import UserFunctions.User;
import java.io.IOException;

/**
 *
 */
public interface SignInGatewayInterface {
    /**
     *
     * @param username the String username
     * @return the User who has this username
     * @throws IOException username not inputted properly
     * @throws ClassNotFoundException
     */
    User getUser(String username) throws IOException, ClassNotFoundException;
}
