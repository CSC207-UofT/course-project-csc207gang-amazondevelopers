package InputAndOutput;

import java.io.IOException;

public interface InOut {
    String getInput() throws IOException;

    void sendOutput(Object s);
}
