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
}
