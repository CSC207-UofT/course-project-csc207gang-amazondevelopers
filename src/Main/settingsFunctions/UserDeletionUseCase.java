package settingsFunctions;
import userFunctions.User;
import java.io.IOException;

public class UserDeletionUseCase {
    User user;
    DeleteUserGatewayInterface deleteUserGateway;

    public UserDeletionUseCase(User user, DeleteUserGatewayInterface deleteUserGateway) {
        this.user = user;
        this.deleteUserGateway = deleteUserGateway;
    }

    /**
     * Deletes this user from the user.ser file.
     *
     * @return true if user was successfully deleted and false otherwise.
     */
    public Boolean deleteUser() throws IOException, ClassNotFoundException {
        return deleteUserGateway.deleteUser(user.getUsername());
    }
}
