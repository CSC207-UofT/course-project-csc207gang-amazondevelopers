package userFunctions;
import java.io.*;
import java.util.HashMap;

public class UserReadWriter implements ReadWriter{

    /**
     * Writes the users to file at filePath.
     *
     * @param filePath the file to write the records to
     * @param usersDict    stores the list of users to be serialized
     * @throws IOException error occured during reading a file, when there is an input / output error
     */
    @Override
    public void saveToFile(String filePath, Object usersDict) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(usersDict);
        output.close();
    }

    /**
     * Store the users to file at filePath.
     *
     * @param filePath file where the user list is stored
     * @return Dictionary of the user
     * @throws IOException error occured during reading a file, when there is an input / output error
     */
    @Override
    public HashMap<String, Object> readFromFile(String filePath) throws IOException, ClassNotFoundException {

        InputStream file = new FileInputStream(filePath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        // serialize the Map
        HashMap<String, Object> usersDict = (HashMap<String, Object>) input.readObject();
        input.close();
        return usersDict;

    }
}
