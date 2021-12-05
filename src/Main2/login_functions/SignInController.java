package login_functions;

import user.User;

import java.io.IOException;
import java.util.HashMap;

public class SignInController {

    private HashMap<String,Object> getIdAndPass() throws IOException, ClassNotFoundException {
        GetIDandPasswords getIDandPasswords = new GetIDandPasswords();
        HashMap<String, Object> loginInfo = getIDandPasswords.getUsernamePasswordHash();
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
