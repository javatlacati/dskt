package jaba.adt.math;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;

public class MonomialTest {

  @Test public void getGrade() {
    Monomial monomial =
        new Monomial(0, Arrays.asList(new VariableTerm(2, "x", 2), new VariableTerm(5, "y", 6)));
    assertEquals(6, monomial.getGrade());
  }

  @Test public void addTerm() {
    Monomial monomial = new Monomial(0);
    monomial.addTerm(new VariableTerm(2, "x", 6));
    assertEquals(new Monomial(0, Collections.singletonList(new VariableTerm(2, "x", 6))), monomial);
  }

  @Test public void stringTest() {
    Monomial monomial = new Monomial(0, Arrays
        .asList(new VariableTerm(2, "x", 2), new VariableTerm(5, "y", 6),
            new VariableTerm(-2, "z", 2)));
    assertEquals("2x^2+5y^6-2z^2", monomial.toString());
    Monomial monomial1 = new Monomial(2, Arrays
        .asList(new VariableTerm(2, "x", 2), new VariableTerm(5, "y", 6),
            new VariableTerm(-2, "z", 2)));
    assertEquals("2(2x^2+5y^6-2z^2)", monomial1.toString());
  }
}
