package login;
import InputAndOutput.InOut;
import UserFunctions.User;
import java.io.IOException;

/**
 *
 */
public interface SignUpGatewayInterface {
    /**
     *
     * @param username the username of the user
     * @param user the user object
     * @throws IOException when saving to user.ser, reading from empty user.ser, calling signUpController to get
     * new username but something incorrect given
     * @throws ClassNotFoundException When you try reading from empty user.ser file to get HashMap or calling
     * signUpController to get new username but incorrect type given
     */
    void allowSignUp(String username, User user) throws IOException, ClassNotFoundException;
}


