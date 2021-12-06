package login.sign_in;

import login.GetIDandPasswordsGateway;
import login.GetUserGateway;
import user.User;

import java.io.IOException;
import java.util.HashMap;

public class SignInController {

    private HashMap<String,Object> getIdAndPass() throws IOException, ClassNotFoundException {
        GetIDandPasswordsGateway getIDandPasswordsGateway = new GetIDandPasswordsGateway();
        HashMap<String, Object> loginInfo = getIDandPasswordsGateway.getUsernamePasswordHash();
        return loginInfo;
    }

    public boolean checkPassMatch(String userID, String password) throws IOException, ClassNotFoundException {
        HashMap<String, Object> IdAndPass = this.getIdAndPass();
        if (IdAndPass.containsKey(userID)){
            if (IdAndPass.get(userID).equals(password)){
            return true;}
        }return false;

    }

    public static User getUser(String userID) throws IOException, ClassNotFoundException {
        GetUserGateway getUserGateway = new GetUserGateway();
        User user = getUserGateway.getUser(userID);
        return user;
    }
}
