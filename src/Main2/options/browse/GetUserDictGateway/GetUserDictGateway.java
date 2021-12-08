package options.browse.GetUserDictGateway;

import read_writer.DictionaryReadWriter;

import java.util.HashMap;

public class GetUserDictGateway implements GetUserDictGatewayInterface {
    public HashMap<String, Object> getUserDict(){
        DictionaryReadWriter rw = new DictionaryReadWriter();
        return rw.readFromFile("src/Main2/user.ser");
    }
}
