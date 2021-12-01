package loginFunctionsTest;

import settingsFunctions.DeleteUserGateway;
import userFunctions.User;
import loginFunctions.GetUserGateway;
import loginFunctions.SignUpGateway;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SignUpGatewayTest {

    SignUpGateway signUpGateway = new SignUpGateway();
    DeleteUserGateway deleteUserGateway = new DeleteUserGateway();
    GetUserGateway getUserGateway = new GetUserGateway();

    @Test
    public void allowSignUpBasicTest() throws IOException, ClassNotFoundException {
        User newUser = new User("Person");
        signUpGateway.allowSignUp(newUser.getUsername(), newUser);

        User expectedUser = getUserGateway.getUser("Person");
        assertEquals(newUser.getUsername(), expectedUser.getUsername());
        deleteUserGateway.deleteUser("Person");

    }

}
