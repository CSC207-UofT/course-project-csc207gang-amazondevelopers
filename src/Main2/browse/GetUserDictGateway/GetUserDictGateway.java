package browse.GetUserDictGateway;

import serializationFunctions.DictionaryReadWriter;
import java.io.IOException;
import java.util.HashMap;

public class GetUserDictGateway implements GetUserDictGatewayInterface {
    public HashMap getUserDict() throws IOException, ClassNotFoundException {
        DictionaryReadWriter rw = new DictionaryReadWriter();
        HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main2/user.ser");
        return usersSavedDict;
    }
}
