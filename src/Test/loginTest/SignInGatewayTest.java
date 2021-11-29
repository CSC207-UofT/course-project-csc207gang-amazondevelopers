package loginTest;

import settingsFunctions.DeleteUserGateway;
import userFunctions.User;
import loginFunctions.GetUserGateway;
import loginFunctions.SignUpGateway;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SignInGatewayTest {

    GetUserGateway getUserGateway = new GetUserGateway();
    SignUpGateway signUpGateway = new SignUpGateway();
    DeleteUserGateway deleteUserGateway = new DeleteUserGateway();

    @Test
    public void getUserBasicTest() throws IOException, ClassNotFoundException {
        User newUser = new User("albert");
        signUpGateway.allowSignUp(newUser.getUsername(), newUser);

        User expectedUser = getUserGateway.getUser("albert");
        assertEquals(newUser.getUsername(), expectedUser.getUsername());
        deleteUserGateway.deleteUser("albert");

    }

}
