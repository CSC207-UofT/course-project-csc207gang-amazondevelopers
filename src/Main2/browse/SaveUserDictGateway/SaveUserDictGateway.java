package browse.SaveUserDictGateway;

import login_functions.DictionaryReadWriter;

import java.io.IOException;
import java.util.HashMap;

public class SaveUserDictGateway implements SaveUserDictGatewayInterface {
    public void saveUserDict(HashMap userDict) throws IOException, ClassNotFoundException {
        DictionaryReadWriter rw = new DictionaryReadWriter();
        rw.saveToFile("src/Main2/user.ser", userDict);
    }
}
