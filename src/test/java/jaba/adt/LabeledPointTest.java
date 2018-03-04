package jaba.adt;

import static org.junit.Assert.*;

import org.junit.Test;

public class LabeledPointTest {

  @Test public void stringTest() {
    LabeledPoint labeledPoint = new LabeledPoint();
    labeledPoint.setLabel("x");
    assertEquals("x(",labeledPoint.toString().substring(0,2));
  }

  @Test public void getLabel() {
    LabeledPoint labeledPoint = new LabeledPoint();
    labeledPoint.setLabel("x");
    assertEquals("x",labeledPoint.getLabel());
  }
}
