package serializationFunctions;
import userFunctions.ReadWriter;
import java.io.*;
import java.util.HashMap;

public class DictionaryReadWriter implements userFunctions.ReadWriter {
    /**
     * Writes the users to file at filePath.
     *
     * @param filePath the file to write the records to
     * @param inputDict    stores the list of users to be serialized
     * @throws IOException
     */
    @Override
    public void saveToFile(String filePath, Object inputDict) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(inputDict);
        output.close();
    }

    /**
     * Store the users to file at filePath.
     *
     * @param filePath file where the user list is stored
     * @return Dictionary of the products
     * @throws IOException
     */
    @Override
    public HashMap<String, Object> readFromFile(String filePath) throws IOException, ClassNotFoundException {

        InputStream file = new FileInputStream(filePath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        // serialize the Map
        Object productDict = input.readObject();
        input.close();
        return (HashMap<String, Object>) productDict;

    }
}
