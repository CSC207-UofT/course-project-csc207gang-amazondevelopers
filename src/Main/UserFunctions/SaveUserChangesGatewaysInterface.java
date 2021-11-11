package UserFunctions;

import java.io.IOException;

public interface SaveUserChangesGatewaysInterface {
    public void save(String username, User user) throws IOException, ClassNotFoundException;
}
