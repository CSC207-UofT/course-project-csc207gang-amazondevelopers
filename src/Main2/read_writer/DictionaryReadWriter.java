package read_writer;


import java.io.*;
import java.util.HashMap;

public class DictionaryReadWriter implements ReadWriter {
    /**
     * Writes the users to file at filePath.
     *
     * @param filePath the file to write the records to
     * @param inputDict    stores the list of users to be serialized
     */
    @Override
    public void saveToFile(String filePath, Object inputDict){
        try {
            OutputStream file = new FileOutputStream(filePath);
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);

            // serialize the Map
            output.writeObject(inputDict);
            output.close();
        } catch(IOException ignored){
        }
    }

    /**
     * Store the users to file at filePath.
     *
     * @param filePath file where the user list is stored
     * @return Dictionary of the products
     */
    @Override
    public HashMap<String, Object> readFromFile(String filePath){
        try {
            InputStream file = new FileInputStream(filePath);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            // serialize the Map
            HashMap<String, Object> productDict = (HashMap<String, Object>) input.readObject();
            input.close();
            return productDict;
        } catch (IOException | ClassNotFoundException ioException) {
            return new HashMap<String, Object>();
        }
    }
}
