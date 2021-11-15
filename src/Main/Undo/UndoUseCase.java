package Undo;
import java.util.HashMap;

/**
 * Use case class to make changes to Undo entity instances
 */
public class UndoUseCase {
    /**
     * Allows a controller to undo an action
     * @param undo1
     */
    public void undo(Undo undo1){
        undo1.undo();
    }

    /**
     * Sets the states and dataHash of the undo object to be used in the CreateProductController class
     * @param undo1
     */
    public void setProductController(Undo undo1){
        undo1.addData("Name");
        undo1.addData("Price");
        undo1.addData("Category");
        undo1.addData("Quantity");
        undo1.addData("Size");
        undo1.addData("Caption");
        undo1.addData("CanComment");
        undo1.addData("CanRate");
        undo1.addState("Name");
        undo1.addState("Price");
        undo1.addState("Category");
        undo1.addState("Quantity");
        undo1.addState("Size");
        undo1.addState("Caption");
        undo1.addState("CanComment");
        undo1.addState("CanRate");
    }

    public String getState(Undo undo){
        return undo.getCurrentState();
    }

    public void addData(Undo undo,Object data){
        undo.setDataPoint(data);
    }

    public HashMap getData(Undo undo){
        return undo.get_Data();
    }

}
