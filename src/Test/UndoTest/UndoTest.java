package UndoTest;
import Undo.Undo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UndoTest {
    private Undo undo;
    @Before
    public void setup() {
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
    public void testUndoMethod(){
        undo.setDataPoint(0);
        undo.undo();
        assertEquals("Name", undo.getCurrentState());
    }

    @Test
    public void testUndoFirstState(){
        undo.undo();
        assertEquals("Name", undo.getCurrentState());
    }

    @Test
    public void testIsComplete(){
        undo.setDataPoint(0);
        undo.setDataPoint(0);
        undo.setDataPoint(0);
        undo.setDataPoint(0);
        undo.setDataPoint(0);
        undo.setDataPoint(0);
        assertTrue(undo.isComplete());
    }
}
