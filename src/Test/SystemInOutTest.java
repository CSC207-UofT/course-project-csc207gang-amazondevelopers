import InputAndOutput.InOut;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class SystemInOutTest implements InOut {
    
    private final Scanner reader;

    /**
     *
     * @param fileName
     * @throws FileNotFoundException
     */
    public SystemInOutTest(String fileName) throws FileNotFoundException {
        File fileToRead = new File(fileName);
        this.reader = new Scanner(fileToRead);
    }

    @Override
    public String getInput() throws IOException {
        if (reader.hasNextLine()) {
            return this.reader.nextLine();
        }
        else{
            return "";
        }
    }

    @Override
    public void sendOutput(Object s) {
        System.out.println(s);

    }

}
