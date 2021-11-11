package UserFunctions;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class SaveUserChangesGateways implements SaveUserChangesGatewaysInterface{

    @Override
    public void save(String username, User user) throws IOException, ClassNotFoundException {
        // save the changed, new user.
        UserReadWriter rw = new UserReadWriter();
        HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
        usersSavedDict.put(username, user);
        rw.saveToFile("src/Main/user.ser", usersSavedDict);
    }
}
