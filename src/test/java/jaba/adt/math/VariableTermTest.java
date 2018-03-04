package jaba.adt.math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrador on 29/06/2017.
 */
public class VariableTermTest {
  @Test public void toStringTest() throws Exception {
    VariableTerm v = new VariableTerm(0, "x", 0);
    assertEquals("x", v.toString());
    v = new VariableTerm(2, "y", 0);
    assertEquals("2y", v.toString());
    v = new VariableTerm(2, "y", 2);
    assertEquals("2y^2", v.toString());
    v = new VariableTerm(0, "z", 2);
    assertEquals("z^2", v.toString());
  }

  @Test public void sum1() {
    VariableTerm v = new VariableTerm(1, "x", 0);
    VariableTerm v1 = new VariableTerm(1, "x", 0);
    assertEquals(new VariableTerm(2, "x", 0), v.sum1(v1));
  }
}
