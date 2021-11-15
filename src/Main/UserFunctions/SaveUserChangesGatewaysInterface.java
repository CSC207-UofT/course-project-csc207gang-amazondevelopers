package UserFunctions;
import java.io.IOException;

public interface SaveUserChangesGatewaysInterface {
    void save(String username, User user) throws IOException, ClassNotFoundException;
}
