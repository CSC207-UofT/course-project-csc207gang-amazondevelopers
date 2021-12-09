package login.sign_in.SignInPresenter;

/**
 * Presenter Interface that is implemented to present different types of output to users (for SignIn package)
 */

public interface SignInPresenterInterface {
    String presentInputUsername();
    String presentWrongPasswordUsername();
    String presentLogin();
    String presentReset();
    String presentBack();
    String presentUserID();
    String presentPassword();
}
