package gui;
import java.io.IOException;

/**
 *  All GUI classes implement this interface.
 */

public interface GUIFactoryInterface {
    GUI createGUI() throws IOException, ClassNotFoundException;
}
