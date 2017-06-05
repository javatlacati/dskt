package jaba.stack;

import lombok.Getter;
import lombok.ToString;

@ToString(of = "stackArray")
public class ArrayBasedStack {
    Object[] stackArray;
    @Getter
    int topPosition;

    public ArrayBasedStack(int capacity) {
        stackArray = new Object[capacity];
    }

    public void push(Object item) {
        if (stackArray.length > topPosition) {
            stackArray[topPosition++] = item;
        } else {
            throw new IndexOutOfBoundsException("Capacity overflow");
        }
    }

    public Object pop() {
        if(topPosition>0) {
            return stackArray[--topPosition];
        }else{
            throw new IndexOutOfBoundsException("Capacity underflow");
        }
    }

    public Object peek() {
        return stackArray[topPosition];
    }


}
