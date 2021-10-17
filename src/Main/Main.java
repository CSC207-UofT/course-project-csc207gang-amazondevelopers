import InputAndOutput.SystemInOut;

public class Main {

    public static void main(String[] args) {
        SystemInOut inOut = new SystemInOut();
        userOptionsController options = new userOptionsController();
        try {
            options.userInput();
        } catch(Exception e){
            inOut.sendOutput("error occurred");
        }

    }
}
