package loginFunctions;

import userFunctions.User;

import java.util.Base64;


public class PasswordController {

    Base64.Encoder encrypted = Base64.getEncoder();

    public void setUserPassword(User user, String password){
        String coded = encrypted.encodeToString(password.getBytes());
        user.setPassword(coded);
    }

    public boolean verifyPasswordsMatch(String pass1, String pass2){
        return pass1.equals(pass2);
    }

    public boolean verifyPassword(User user, String passAttempt){
        return (user.getPassword()).equals(encrypted.encodeToString(passAttempt.getBytes()));
    }
}