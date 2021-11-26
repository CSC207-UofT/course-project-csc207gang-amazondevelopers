package MementoFunctions;

public class Originator {
    private int state;//Integer refers to which question the code needs to ask the user

    /**
     * Sets the state of the item
     * @param state
     */
    public void set(int state) {
        this.state = state;
        System.out.println("Originator: Setting state to " + state);
    }

    /**
     * Returns the current state
     * @return
     */
    public int getState(){
        return this.state;
    }
    public Memento saveToMemento() {
        System.out.println("Originator: Saving to Memento.");
        return new Memento(this.state);
    }
    public void restoreFromMemento(Memento memento) {
        this.state = memento.getSavedState();
        System.out.println("Originator: State after restoring from Memento: " + state);
    }

    /**
     * Memento static subclass to allow restoration of the last state that was inputed
     */
    public static class Memento {
        private final int state;

        public Memento(int stateToSave) {
            state = stateToSave;
        }
        private int getSavedState() {
            return state;
        }
    }
}
