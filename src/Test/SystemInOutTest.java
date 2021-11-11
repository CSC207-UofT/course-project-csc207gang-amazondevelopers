import InputAndOutput.InOut;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class SystemInOutTest implements InOut {
    /**
     *
     * @param fileName
     * @throws FileNotFoundException
     */

    public SystemInOutTest(String fileName) throws FileNotFoundException {
    }


    public void scan(){}

    File newfile = new File("src/Test/getUsername.txt");
    Scanner myReader = new Scanner(newfile);

    @Override
    public String getInput() throws IOException {
        String data = myReader.nextLine();
        return data;

    }

    @Override
    public void sendOutput(Object s) {
        System.out.println(s);

    }

}//
