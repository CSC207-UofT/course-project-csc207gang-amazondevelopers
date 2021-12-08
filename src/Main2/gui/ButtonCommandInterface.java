package gui;

import java.io.IOException;

/**
 * Interface that represents a button pressed by a user in our swing GUI.
 */
public interface ButtonCommandInterface {
    void apply() throws IOException, ClassNotFoundException;
}
