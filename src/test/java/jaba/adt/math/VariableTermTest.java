package jaba.adt.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrador on 29/06/2017.
 */
public class VariableTermTest {
    @Test
    public void toStringTest() throws Exception {
        VariableTerm v = new VariableTerm(0,"x",0);
        assertEquals("x",v.toString());
        v=new VariableTerm(2,"y",0);
        assertEquals("2y",v.toString());
        v=new VariableTerm(2,"y",2);
        assertEquals("2y^2",v.toString());
        v=new VariableTerm(0,"z",2);
        assertEquals("z^2",v.toString());
    }
//
//    @Test
//    public void setCoefficient() throws Exception {
//    }
//
//    @Test
//    public void setLiteralPart() throws Exception {
//    }
//
//    @Test
//    public void setGrade() throws Exception {
//    }
//
//    @Test
//    public void getCoefficient() throws Exception {
//    }
//
//    @Test
//    public void getLiteralPart() throws Exception {
//    }
//
//    @Test
//    public void getGrade() throws Exception {
//    }

}