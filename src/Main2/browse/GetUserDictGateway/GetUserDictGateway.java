package browse.GetUserDictGateway;

import login_functions.DictionaryReadWriter;

import java.io.IOException;
import java.util.HashMap;

public class GetUserDictGateway implements GetUserDictGatewayInterface {
    public HashMap<String, Object> getUserDict() throws IOException, ClassNotFoundException {
        DictionaryReadWriter rw = new DictionaryReadWriter();
        HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main2/user.ser");
        return usersSavedDict;
    }
}
