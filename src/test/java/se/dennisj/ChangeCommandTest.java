package se.dennisj;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import se.dennisj.model.SubstitutionModel;

public class ChangeCommandTest {
    String data = "AAABBB";
    SubstitutionModel SubstitutionModel = new SubstitutionModel(data);

    @Before
    public void SetUp(){
        SubstitutionModel.changeLetter('A', 'c');
    }

    @Test
    public void testUndo(){
        assertTrue("Change letter fungerar inte " + SubstitutionModel.getData(), SubstitutionModel.getData().equals("cccBBB"));
        SubstitutionModel.undo();
        assertTrue("Undo fungerar inte" + SubstitutionModel.getData(), "AAABBB" == SubstitutionModel.getData());
    }

}