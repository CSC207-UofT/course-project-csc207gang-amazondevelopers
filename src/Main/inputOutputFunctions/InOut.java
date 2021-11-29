package inputOutputFunctions;

import java.io.IOException;

/**
 * An interface that interacts with user input. to be implemented by SystemInOut.
 */

public interface InOut {
    /**
     *
     * @return returns a string
     * @throws IOException exception is thrown if no input is given
     */
    String getInput() throws IOException;

    /**
     *
     * @param s display s to the user
     */
    void sendOutput(Object s);
}
