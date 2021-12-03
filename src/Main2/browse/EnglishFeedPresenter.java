package browse;
public class EnglishFeedPresenter implements FeedPresenterInterface {
        @Override
        public String presentNext() {
            return "Next";
        }

        @Override
        public String presentBack() {
            return "Back";
        }

        @Override
        public String presentBuy() {
            return "Add to Cart";
        }

    @Override
    public String presentProductName() {
        return "Product Name: ";
    }
    @Override
    public String presentPostedBy() {
            return "Posted By: ";
        }

    @Override
    public String presentCaption() {
        return "Caption: ";
    }
}
