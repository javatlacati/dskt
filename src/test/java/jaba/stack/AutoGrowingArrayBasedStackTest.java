package jaba.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by Administrador on 06/06/2017.
 */
public class AutoGrowingArrayBasedStackTest {
    private static final Logger log = Logger.getLogger(AutoGrowingArrayBasedStackTest.class.getName());
    private ArrayBasedStack<Integer> stack;

    @Before
    public void setUp() throws Exception {
        stack = new AutoGrowingArrayBasedStack<>(2, 2);
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

    @DisplayName("Escenario complejo")
    @Test
    public void happyPath() throws Exception {
        log.info(stack.toString());
        for (int i = 1; i < 10; i++) {
            stack.push(i);
            log.info(stack.toString());
        }
        Assert.assertEquals(10, stack.getElementsCapacity());
        log.info(stack.toString());
        for(int i=1;i<12;i++){
                if(i>9){
                    assertThrows(IndexOutOfBoundsException.class, ()-> stack.pop(),"test dind't poped as expected");
                    log.info("test dind't poped as expected");
                }else{
                    stack.pop();
                    log.info(stack.toString());
                }
        }
    }

}