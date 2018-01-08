package jaba.stack;

import lombok.extern.java.Log;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrador on 06/06/2017.
 */
@Log
public class AutoGrowingArrayBasedStackTest {
    private ArrayBasedStack<Integer> stack;
    @Before
    public void setUp() throws Exception {
        stack =new AutoGrowingArrayBasedStack<>(2,2);
    }

    @Test
    public void push() throws Exception {
    }

    @Test
    public void setCapacityIncrement() throws Exception {
    }

    @Test
    public void getCapacityIncrement() throws Exception {
    }

    @Test
    public void push1() throws Exception {
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
    public void happyPath() throws Exception {
        System.out.println(stack);
        for(int i=1;i<10;i++){
            stack.push(i);
            System.out.println(stack);
        }
        System.out.println(stack);
        for(int i=1;i<12;i++){
            try {
                stack.pop();
                System.out.println(stack);
            } catch (Exception e) {
                log.info("test dind't poped as expected");
            }
        }
    }

}