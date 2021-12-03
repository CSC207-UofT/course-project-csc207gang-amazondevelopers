package browse.SaveUserDictGateway;

import java.io.IOException;
import java.util.HashMap;

public interface SaveUserDictGatewayInterface {
    void saveUserDict(HashMap userDict) throws IOException, ClassNotFoundException;
}
