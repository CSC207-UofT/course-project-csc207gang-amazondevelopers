package login;

import InputAndOutput.SystemInOut;

public class SignUpPresenter {

    public void presentSignUp(){
        /*
         * asks user what they want their username to be
         */
        SystemInOut inOut = new SystemInOut();
        inOut.sendOutput("What would you like to put as your username? " +
                "(please do not leave this field empty and do not put * as your username)");
    }

    /**
     * failed input, either left blank or * was inputted by user
     */
    public void failedSignUp(){
        SystemInOut inOut = new SystemInOut();

        inOut.sendOutput("Your previous attempt failed! What would you like to put as your username? " +
                "(please do not leave this field empty and do not put * as your username)");
    }

}
