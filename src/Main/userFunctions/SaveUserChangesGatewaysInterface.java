package userFunctions;
import java.io.IOException;

/**
 * Used by SaveUserChangesGateways to save a user to user.ser again, replacing the user in the previous HashMap with
 * new changed user
 */
public interface SaveUserChangesGatewaysInterface {
    /**
     *
     * @param username The unique username of the user
     * @param user The user object itself
     * @throws IOException When trying read from and save to empty files
     * @throws ClassNotFoundException Trying to read from empty file and create a HashMap
     */
    void save(String username, User user) throws IOException, ClassNotFoundException;
}
