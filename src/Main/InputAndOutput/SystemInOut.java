package InputAndOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInOut implements InOut {
    BufferedReader reader;

    public SystemInOut() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    // get user input
    public String getInput() throws IOException {
        return reader.readLine();
    }

    // send user a message they can respond to
    @Override
    public void sendOutput(Object s) {
        System.out.println(s);
    }
}
