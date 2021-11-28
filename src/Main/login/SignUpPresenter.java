package login;

import InputAndOutput.SystemInOut;

public class SignUpPresenter {

    public void presentSignUp(){
        SystemInOut inOut = new SystemInOut();
        inOut.sendOutput("What would you like to put as your username? " +
                "(please do not leave this field empty and do not put * as your username)");
    }

    public void failedSignUp(){
        SystemInOut inOut = new SystemInOut();

        inOut.sendOutput("YOur previous attempt failed! What would you like to put as your username? " +
                "(please do not leave this field empty and do not put * as your username)");
    }

}
