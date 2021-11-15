package UndoTest;
import Undo.Undo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UndoTest {
    private Undo undo;
    @Before
    void setup() throws Exception{
        undo = new Undo();
        undo.addData("Name");
        undo.addData("ID");
        undo.addData("Price");
        undo.addData("Category");
        undo.addData("Quantity");
        undo.addData("Size");
        undo.addState("Name");
        undo.addState("ID");
        undo.addState("Price");
        undo.addState("Category");
        undo.addState("Quantity");
        undo.addState("Size");
    }

    @Test
    void testUndoMethod(){
        undo.setDataPoint(0);
        undo.undo();
        assertTrue(undo.getCurrentState().equals("Name"));
    }

    @Test
    void testUndoFirstState(){
        undo.undo();
        assertTrue(undo.getCurrentState().equals("Name"));
    }

    @Test
    void testIsComplete(){
        undo.setDataPoint(0);
        undo.setDataPoint(0);
        undo.setDataPoint(0);
        undo.setDataPoint(0);
        undo.setDataPoint(0);
        undo.setDataPoint(0);
        assertTrue(undo.isComplete());
    }
}
