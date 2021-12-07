package options.browse.GetUserDictGateway;

import read_writer.DictionaryReadWriter;

import java.io.IOException;
import java.util.HashMap;

public class GetUserDictGateway implements GetUserDictGatewayInterface {
    public HashMap<String, Object> getUserDict() throws IOException, ClassNotFoundException {
        DictionaryReadWriter rw = new DictionaryReadWriter();
        return rw.readFromFile("src/Main2/user.ser");
    }
}
