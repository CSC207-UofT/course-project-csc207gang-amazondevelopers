package browseFunctions;

import inputOutputFunctions.SystemInOut;
import serializationFunctions.DictionaryReadWriter;
import java.io.IOException;
import java.util.HashMap;

public class GetUserDictGateway {

    public HashMap getUserDict() throws IOException, ClassNotFoundException {
        SystemInOut inOut = new SystemInOut();
        DictionaryReadWriter rw = new DictionaryReadWriter();
        HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
        return usersSavedDict;
    }
}
