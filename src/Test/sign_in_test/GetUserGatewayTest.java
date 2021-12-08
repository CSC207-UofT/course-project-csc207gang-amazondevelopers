package sign_in_test;

import delete_gateways.DeleteUserGateway;
import login.GetUserGateway;
import login.SaveUserGateway;
import org.junit.Test;
import user.User;

import static org.junit.Assert.assertEquals;

public class GetUserGatewayTest {

    GetUserGateway getUserGateway = new GetUserGateway();
    SaveUserGateway saveUserGateway = new SaveUserGateway();
    DeleteUserGateway deleteUserGateway = new DeleteUserGateway();

    @Test
    public void getUserBasicTest() {
        User newUser = new User("albert");
        saveUserGateway.saveUser("albert", newUser);

        User expectedUser = getUserGateway.getUser("albert");
        assertEquals(newUser.getUsername(), expectedUser.getUsername());
        deleteUserGateway.deleteUser("albert");
    }

}
