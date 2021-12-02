package browseFunctions;

import java.io.IOException;
import java.util.HashMap;

public interface SaveUserDictGatewayInterface {
    void saveUserDict(HashMap userDict) throws IOException, ClassNotFoundException;
}
