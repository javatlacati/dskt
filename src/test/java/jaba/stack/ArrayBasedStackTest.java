package jaba.stack;

import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/** Created by Administrador on 05/06/2017. */
@Log
public class ArrayBasedStackTest {
  ArrayBasedStack<Integer> stack;
  private static final int initialCapacity = 5;

  //    @Rule
  //    public ContiPerfRule i = new ContiPerfRule();

  @Before
  public void setUp() throws Exception {
    stack = new ArrayBasedStack<>(initialCapacity);
  }

  @Test
  public void push() throws Exception {}

  @Test
  public void pop() throws Exception {}

  @Test
  public void peek() throws Exception {}

  @Test
  public void getTopPosition() throws Exception {}

  @Test
  public void idealScenario() throws Exception {
    try {
      stack.push(4);
      log.info(stack.toString());
      stack.push(8);
      log.info(stack.toString());
      stack.push(3);
      log.info(stack.toString());
      stack.push(89);
      log.info(stack.toString());
      stack.pop();
      log.info(stack.toString());
      stack.push(34);
      log.info(stack.toString());
      stack.push(45);
      log.info(stack.toString());
      stack.push(78);
      log.info(stack.toString());
    } catch (Exception e) {
      log.info(e.getMessage());
    }
    Assert.assertEquals(5, stack.getElementsCapacity());
    try {
      log.info(stack.pop().toString());
      log.info(stack.pop().toString());
      log.info(stack.pop().toString());
      log.info(stack.pop().toString());
      log.info(stack.pop().toString());
      log.info(stack.pop().toString());
      log.info(stack.pop().toString());
      log.info(stack.pop().toString());
      log.info(stack.toString());
    } catch (Exception e) {
      log.info(e.getMessage());
    }
  }

  @Test
  public void toArray() {
    stack.push(4);
    stack.push(8);
    Assert.assertArrayEquals(new Integer[] {4, 8}, stack.toArray());
    stack.push(3);
    stack.push(89);
    Assert.assertArrayEquals(new Integer[] {4, 8, 3, 89}, stack.toArray());
    stack.push(34);
    Assert.assertArrayEquals(new Integer[] {4, 8, 3, 89, 34}, stack.toArray());
  }
}
