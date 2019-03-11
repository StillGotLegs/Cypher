package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChangeCommandTest {
    String data = "AAABBB";
    sModel sModel = new sModel(data);

    @Before
    public void SetUp(){
        sModel.changeLetter('A', 'c');
    }

    @Test
    public void testUndo(){
        assertTrue("Change letter fungerar inte " + sModel.getData(), sModel.getData().equals("cccBBB"));
        sModel.undo();
        assertTrue("Undo fungerar inte" + sModel.getData(), "AAABBB" == sModel.getData());
    }

}