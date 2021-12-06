package options.browse.EmptyFeedPresenter;

public class EnglishEmptyFeedPresenter implements EmptyFeedPresenterInterface {
    @Override
    public String presentEmpty() {
        return "<html>Your Feed Is Empty. <br>Please Follow Another User And Return Here:</html>";
    }

    @Override
    public String presentReturn() {
        return "Back";
    }
}
