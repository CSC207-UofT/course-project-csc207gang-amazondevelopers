package UserFunctions;

public class SettingUserUseCase {

    // change username


    /**
     * Method that takes a String representing the new username
     * and sets it as User's username.
     * Returns true if username is successfully changed and returns false if
     * username not changed (already in use by another user)
     *
     * @param newUsername User's new username.
     * @return true if username is successfully changed and returns false if
     *         username not changed (already in use by another user)
     */
    public boolean changeUsername(String newUsername){
        // if this username is not already in use
        if (checkUsernameStatus(newUsername)){
            this.user.setUsername(newUsername);
            return true;
        }
        return false;
    }

    /**
     * Method that takes in a String representing a username.
     * Returns true if username is not taken by another user and returns
     * false if username is already in use by another user.
     *
     * @param username Username whose status is checked.
     * @return true if username is not taken by another user and returns
     *         false if username is already in use by another user.
     */

    private static boolean checkUsernameStatus(String username) {
        return masterManager.getterUser(username).equals(false);
    }

}
