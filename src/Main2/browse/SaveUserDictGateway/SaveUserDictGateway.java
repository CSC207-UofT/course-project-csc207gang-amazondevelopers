package browse.SaveUserDictGateway;

import inputOutputFunctions.SystemInOut;
import serializationFunctions.DictionaryReadWriter;

import java.io.IOException;
import java.util.HashMap;

public class SaveUserDictGateway implements SaveUserDictGatewayInterface {
    public void saveUserDict(HashMap userDict) throws IOException, ClassNotFoundException {
        SystemInOut inOut = new SystemInOut();
        DictionaryReadWriter rw = new DictionaryReadWriter();
        rw.saveToFile("src/Main/user.ser", userDict);
    }
}
