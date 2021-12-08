package options.browse.GetUserDictGateway;

import java.io.IOException;
import java.util.HashMap;

public interface GetUserDictGatewayInterface {
    HashMap<String,Object> getUserDict() throws IOException, ClassNotFoundException;
}
