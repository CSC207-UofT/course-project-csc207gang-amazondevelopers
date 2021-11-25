package login;
import UserFunctions.User;
import java.io.IOException;

/**
 * An interface used by SaveUserGateway to help save items to user.ser file
 */
public interface SaveUserGatewayInterface {
    /**
     *
     * @param username the username String to be saved
     * @param userToBeSaved the user object to be saved
     * @throws IOException nothing was in user.ser file or wrong input was put in for options
     * @throws ClassNotFoundException HashMap not found in user.ser
     */
    void saveUser(String username, User userToBeSaved) throws IOException, ClassNotFoundException;
}
