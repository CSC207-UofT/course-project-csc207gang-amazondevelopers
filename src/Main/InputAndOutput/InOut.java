package InputAndOutput;

import java.io.IOException;

/**
 * An interface that interacts with user input. to be implemented by SystemInOut.
 */

public interface InOut {
    String getInput() throws IOException;
    void sendOutput(Object s);
}
