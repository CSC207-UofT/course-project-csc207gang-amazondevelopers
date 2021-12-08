package login.sign_in;

import login.GetIDandPasswordsGateway;
import java.util.HashMap;

/**
 * Controller with methods relating to the user signing in to the program
 */
public class SignInController {
    /**
     * Retrives our user to password info from a file, and checks if the given username and password match the combination given.
     * or if the username exists at all
     * @param userID Username inputed when signing in
     * @param password Password given when signing in
     * @return returns true if the userId and password exist and match, false if they dont.
     */
    public boolean checkPassMatch(String userID, String password){
        GetIDandPasswordsGateway getIDandPasswordsGateway = new GetIDandPasswordsGateway();
        HashMap<String, Object> IdAndPass = getIDandPasswordsGateway.getUsernamePasswordHash();
        if (IdAndPass.containsKey(userID)){
            return IdAndPass.get(userID).equals(password);
        }return false;

    }
}
