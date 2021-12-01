package login_functions;

import serializationFunctions.DictionaryReadWriter;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;


public class GetIDandPasswords {
    /**
     *
     * @return the hashmap of ID and passwords
     * @throws IOException thrown if incorrect error
     * @throws ClassNotFoundException thrown if class is not found
     */
    public HashMap<String, Object> getUsernamePasswordHash() throws IOException, ClassNotFoundException {
        File file = new File("src/Main2/username_password.ser");
        if (file.length() == 0){
            DictionaryReadWriter rw = new DictionaryReadWriter();
            HashMap<String, Object> newHashMap = new HashMap<>();
            rw.saveToFile("src/Main2/username_password.ser", newHashMap);
            return newHashMap;
            }
        else{
            // access the serialized file for this user.
            DictionaryReadWriter rw = new DictionaryReadWriter();
            return rw.readFromFile("src/Main2/username_password.ser");
            }

        }
        }



