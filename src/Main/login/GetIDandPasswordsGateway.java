package login;


import read_writer.DictionaryReadWriter;

import java.io.File;
import java.util.HashMap;

public class GetIDandPasswordsGateway {
    /**
     *Gateway that returns the dictionary of usernames to passwords.
     * @return the hashmap of ID and passwords
     */
    public HashMap<String, Object> getUsernamePasswordHash(){
        File file = new File("src/Main/username_password.ser");
        if (file.length() == 0){
            DictionaryReadWriter rw = new DictionaryReadWriter();
            HashMap<String, Object> newHashMap = new HashMap<>();
            rw.saveToFile("src/Main/username_password.ser", newHashMap);
            return newHashMap;
            }
        else{
            // access the serialized file for this user.
            DictionaryReadWriter rw = new DictionaryReadWriter();
            return rw.readFromFile("src/Main/username_password.ser");
            }

        }
        }



