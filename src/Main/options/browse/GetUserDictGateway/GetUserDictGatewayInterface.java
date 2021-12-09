package options.browse.GetUserDictGateway;

import java.io.IOException;
import java.util.HashMap;

public interface GetUserDictGatewayInterface {

    /**
     *Interface for getting User dict
     */

    HashMap getUserDict() throws IOException, ClassNotFoundException;
}
