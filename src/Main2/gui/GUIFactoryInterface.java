package gui;

import java.io.IOException;

/**
 *  All GUIMaker classes implement this interface.
 */

public interface GUIFactoryInterface {
    void createGUI() throws IOException, ClassNotFoundException;
}
