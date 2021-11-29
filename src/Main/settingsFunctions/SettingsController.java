package settingsFunctions;
import inputOutputFunctions.SystemInOut;
import optionsPackage.EnglishOptionsPresenter;
import optionsPackage.UserOptionsController;
import userFunctions.User;
import java.io.IOException;

public class SettingsController {
    User user;

    public SettingsController(User user){
        this.user = user;

    }

    public void getSettingOptions() throws IOException {
        SystemInOut input = new SystemInOut();
        input.sendOutput("What would you like to do? Input a number for " +
                "your ideal option (Not fully implemented, please try again in phase 2 :)\n *. Back to all options");

        String userDecision = input.getInput();

        try{
            //TODO phase 2: Has been started in phase 1, to be continued in phase2
            // find an efficient way to delete users and products, and change usernames
//            if(userDecision.equals("4")) {
//                // delete this account
//                DeleteUserGateway deleteUserGateway = new DeleteUserGateway();
//                UserDeletionUseCase deleteUser = new UserDeletionUseCase(this.user, deleteUserGateway);
//                // if the user has been deleted, then we delete the products that user posted
//                if (deleteUser.deleteUser().equals(true)) {
//                    // need to remove all the followers/following stuff
//                    DeleteProductsGateway deleteProductsGateway = new DeleteProductsGateway();
//                    ProductDeletionUseCase productDeletionUseCase = new ProductDeletionUseCase(this.user, deleteProductsGateway);
//                    if(productDeletionUseCase.deleteProducts()) {
//                        // need to update feed or something
//
//                    }
//                }
//                // user does not exist
//                else {
//                    input.sendOutput("This user does not exist. User deletion unsuccessful.");
//                }
//
//                // [123, 1234]
//                //0
//                //123
//
//                // product
//                //{tag:[123, 1234]}
//
//                //prodictID
//                //{123:product}
//
//
//            }
//            else if(userDecision.equals("2")) {
//                ChangeUsernameGateway changeUsernameG = new ChangeUsernameGateway(user);
//                input.sendOutput("What do you want to set as your new username?");
//                String oldUsername = user.getUsername();
//                String newUsername = input.getInput();
//                changeUsernameG.changeUsername(newUsername, input);
//                // people who follow me, want my username to change for them
//                List<String> followers = user.getListFollowers();
//                for (String person : followers) {
//                    if (person.equals(oldUsername)) {
//                        followers.remove(person);
//                        followers.add(newUsername);
//                    }
//                }
//                // people who I follow, want the username to change for thei list
//                List<String> following = user.getListFollowing();
//                for (String person : following) {
//
//                    if (person.equals(oldUsername)) {
//                        followers.remove(person);
//                        followers.add(newUsername);
//                    }
//
//                    // TODO change this username everywhere in this user's following list
//                }
//            }
//            else if(userDecision.equals("3")) {
//                // a new options gateways to make changes to your products
//            }

            if(userDecision.equals("*")) {
                UserOptionsController options = new UserOptionsController(user);
                EnglishOptionsPresenter engPresenter = new EnglishOptionsPresenter();
                options.getOption(input, engPresenter);
            }
            throw new IOException("That is not an accepted input, please try again!");
            // throws exception in case the input is not in the available options of inputs
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    }
    // delete users, reduce quantity


    // delete options
    // 5. Delete your current account
    // delete the user from the .ser file
//    DeleteUserGateway deleter = new DeleteUserGateway(user);
//                deleter.deleteUser(user.getUsername(), input);
    // modify your product quantity

