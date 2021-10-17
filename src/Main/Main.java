import InputAndOutput.SystemInOut;

public class Main {

    public static void main(String[] args) {
        SystemInOut inOut = new SystemInOut();
        // we need to give user the option to either login or signup, then give them the option to browse etc
        userOptionsController options = new userOptionsController();
        try {
            options.userInput();
        } catch(Exception e){
            inOut.sendOutput("error occurred");
        }

    }
}
