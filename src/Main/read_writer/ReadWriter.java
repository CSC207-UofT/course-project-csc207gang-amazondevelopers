package read_writer;
import java.util.HashMap;

/**
 * Code is copied from cleanArchitectureLoginDemo CSC207 Paul Gries, University of Toronto, Fall 2021
 */
public interface ReadWriter {

    /**
     * @param filepath location of ser file
     * @param o object to be serialized
     */
    void saveToFile(String filepath, Object o);

    /**
     * @param filepath location of ser file
     */
    HashMap<String, Object> readFromFile(String filepath);
}
