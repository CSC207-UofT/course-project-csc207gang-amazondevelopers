package Settings;
import UserFunctions.User;
import java.io.IOException;

public class UserDeletionUseCase {
    User user;
    DeleteUserGateway deleteUserGateway;

    public UserDeletionUseCase(User user, DeleteUserGateway deleteUserGateway) {
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
