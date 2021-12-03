package mementoFunctions;

public class Originator {
    private int state;//Integer refers to which question the code needs to ask the user

    /**
     * Sets the state of the item
     * @param state
     */
    public void set(int state) {
        this.state = state;
    }

    /**
     * Returns the current state
     * @return
     */
    public int getState(){
        return this.state;
    }
    public Memento saveToMemento() {
        return new Memento(this.state);
    }
    public void restoreFromMemento(Memento memento) {
        this.state = memento.getSavedState();
    }

    /**
     * Memento static subclass to allow restoration of the last state that was inputed
     */
    public static class Memento {
        private final int state;

        public Memento(int stateToSave) {
            state = stateToSave;
        }
    }
}
