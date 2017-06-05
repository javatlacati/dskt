package jaba.stack;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrador on 05/06/2017.
 */
public class ArrayBasedStackTest {
    ArrayBasedStack stack;
    private static final int initialCapacity = 5;

//    @Rule
//    public ContiPerfRule i = new ContiPerfRule();

    @Before
    public void setUp() throws Exception {
        stack = new ArrayBasedStack(initialCapacity);
    }

    @Test
    public void push() throws Exception {
    }

    @Test
    public void pop() throws Exception {
    }

    @Test
    public void peek() throws Exception {
    }

    @Test
    public void getTopPosition() throws Exception {
    }

    @Test
    public void idealScenario() throws Exception {
        try {
            stack.push(4);
            System.out.println(stack);
            stack.push(8);
            System.out.println(stack);
            stack.push(3);
            System.out.println(stack);
            stack.push(89);
            System.out.println(stack);
            stack.pop();
            System.out.println(stack);
            stack.push(34);
            System.out.println(stack);
            stack.push(45);
            System.out.println(stack);
            stack.push(78);
            System.out.println(stack);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}