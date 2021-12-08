package options.browse.EmptyFeedPresenter;

public class EnglishEmptyFeedPresenter implements EmptyFeedPresenterInterface {

    /** Presenter for empty feed
     *
     * @return String notifies user feed is empty
     */

    @Override
    public String presentEmpty() {
        return "<html>Your Feed Is Empty. <br>Please Follow Another User And Return Here:</html>";
    }

    /**Presenter for returning to options menu
     *
     * @return String "Back"
     */

    @Override
    public String presentReturn() {
        return "Back";
    }
}
