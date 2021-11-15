package UserFunctions;
import java.io.IOException;
import java.util.HashMap;

public class SaveUserChangesGateways implements SaveUserChangesGatewaysInterface{
    /**
     * Save the user changes to the .ser file
     * @param username the string username of the user
     * @param user the user to be saved
     * @throws IOException error occured during reading a file
     * @throws ClassNotFoundException when you try to load a class at run time using Class
     */

    @Override
    public void save(String username, User user) throws IOException, ClassNotFoundException {
        // save the changed, new user.
        UserReadWriter rw = new UserReadWriter();
        HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
        usersSavedDict.put(username, user);
        rw.saveToFile("src/Main/user.ser", usersSavedDict);
    }
}
