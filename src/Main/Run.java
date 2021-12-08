import gui.GUIFactory;
import gui.GUIFactoryInterface;

public class Run {
    public static void main(String[] args){
        GUIFactory guiFactory = new GUIFactory();
        GUIFactoryInterface guiFrame = guiFactory.getFrame("WELCOME");
        guiFrame.createGUI();
    }
}
