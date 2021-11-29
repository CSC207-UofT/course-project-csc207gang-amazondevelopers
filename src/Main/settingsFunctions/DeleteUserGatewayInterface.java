package settingsFunctions;
import java.io.IOException;

/**
 * Used by DeleteUserGateway to help in deleting a user from the HashMap in user.ser
 */
public interface DeleteUserGatewayInterface {
    /**
     *
     * @param username the username associated with this user
     * @return true or false if the user was deleted or not
     * @throws IOException reading from and saving to file that is empty
     * @throws ClassNotFoundException reading from empty file to produce a HashMap
     */
    public boolean deleteUser(String username) throws IOException, ClassNotFoundException;
    }
