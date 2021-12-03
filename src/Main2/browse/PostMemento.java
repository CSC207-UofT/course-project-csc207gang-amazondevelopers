package browse;

import mementoFunctions.Originator;
import postFunctions.Post;

import java.util.ArrayList;

/**
 * Entity class to represent a post in the feed of a user, implements the memento design pattern.
 */
public class PostMemento {
    private Post state; //current state
    /**
     * Sets the state of the item
     * @param givenState,
     */
    public void setState(Post givenState) {
        this.state = givenState;
    }

    /**
     * Returns the current state
     * @return
     */
    public Post getState(){
        return this.state;
    }
    public PostMemento.Memento saveToMemento() {
        return new PostMemento.Memento(this.state);
    }
    public void restoreFromMemento(PostMemento.Memento memento) {
        this.state = memento.getSavedState();
    }

    /**
     * Memento static subclass to allow restoration of the last state that was inputed
     */
    public static class Memento {
        private final Post state;

        public Memento(Post stateToSave) {
            state = stateToSave;
        }
        public Post getSavedState() {
            return state;
        }
    }
}
