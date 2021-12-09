package options.browse.GetUserDictGateway;

import read_writer.DictionaryReadWriter;

import java.io.IOException;
import java.util.HashMap;


public class GetUserDictGateway implements GetUserDictGatewayInterface {

    /** gets user dictionary from user.ser file
     *
     * @return Dictionary Read writer of serialized user file
     */
    public HashMap<String, Object> getUserDict(){
        DictionaryReadWriter rw = new DictionaryReadWriter();
        return rw.readFromFile("src/Main/user.ser");
    }
}
