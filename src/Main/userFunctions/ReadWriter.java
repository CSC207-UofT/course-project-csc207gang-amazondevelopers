package userFunctions;
import java.io.IOException;
import java.util.HashMap;

/**
 * Code is copied from cleanArchitectureLoginDemo CSC207 Paul Gries, University of Toronto, Fall 2021
 */
public interface ReadWriter {

    /**
     * @param filepath location of ser file
     * @param o object to be serialized
     */
    void saveToFile(String filepath, Object o) throws IOException;

    /**
     * @param filepath location of ser file
     */
    HashMap<String, Object> readFromFile(String filepath) throws IOException, ClassNotFoundException;
}


