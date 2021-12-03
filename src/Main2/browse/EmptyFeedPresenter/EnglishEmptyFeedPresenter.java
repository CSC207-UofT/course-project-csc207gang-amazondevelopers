package browse.EmptyFeedPresenter;

public class EnglishEmptyFeedPresenter implements EmptyFeedPresenterInterface {
    @Override
    public String presentEmpty() {
        return "Your Feed Is Empty, \n Please Follow Another User And Return Here: ";
    }

    @Override
    public String presentReturn() {
        return "Back";
    }
}
