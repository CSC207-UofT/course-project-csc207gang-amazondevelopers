public class createUserUseCase {

    /**
     * Creates a new User object.
     * Method takes in a String for the User's username.
     * Returns true if user is created and false if user is not created.

     * @param username User's username.
     * @return true if user is created and false if user not created
     */
    public static boolean createUser(String username){
        User newUser = new User(username);
        // this username does not exist
        if (checkUsernameStatus(username)){
            // this username not already in use
            // Add user to Hashmap that keeps track of all users
            masterManager.setterUser(username, newUser);
            return true;
        }
        // user not added, username already in use
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
