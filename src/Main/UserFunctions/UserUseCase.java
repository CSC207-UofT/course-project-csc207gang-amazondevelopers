package UserFunctions;

import java.awt.*;

public class UserUseCase {
    User user;

    public List getListFollowing(){
        return (List) user.getListFollowing();
    }
}
