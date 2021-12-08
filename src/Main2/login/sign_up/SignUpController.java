package login.sign_up;


import login.GetIDandPasswordsGateway;
import login.SaveUserGateway;
import login.SetIDandPasswordsGateway;
import user.User;

import java.util.HashMap;

/**
 * Controller used by the SignUpGUI
 */
public class SignUpController {

    /** Checks wether the given userID and password is valid.
     *
     * @param userID the ID of the user
     * @param password the password of the user
     * @return wether the userID and password is valid
     */
    public boolean checkIdAndPass(String userID, String password) {
        return !(password.equals("") | userID.equals(""));
    }


    /**
     *
     * @return hashmap of username to passwords.
     */
    private HashMap<String,Object> getIdAndPass() {
        GetIDandPasswordsGateway getIDandPasswordsGateway = new GetIDandPasswordsGateway();
        return getIDandPasswordsGateway.getUsernamePasswordHash();
    }


    /**
     *
     * @param userID the ID of the user
     * @return wether the user is in the program
     */
    public boolean containsUsername(String userID){
        HashMap<String, Object> IdAndPass = this.getIdAndPass();
        return IdAndPass.containsKey(userID);
    }


    /**
     * set the user to the hashmap
     * @param userID the ID of the user
     * @param password the password of the user
     */
    public static void setNewUser(String userID, String password){
        SetIDandPasswordsGateway setNewUser = new SetIDandPasswordsGateway();
        SaveUserGateway saveUser = new SaveUserGateway();
        setNewUser.setUsernamePasswordHash(userID, password);
        saveUser.saveUser(userID, new User(userID));
    }


}
