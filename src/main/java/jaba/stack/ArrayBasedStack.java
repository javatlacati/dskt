package jaba.stack;

import lombok.Getter;
import lombok.ToString;

@ToString(of = {"stackArray", "topPosition"})
public class ArrayBasedStack<Item>  { //extends Stack<Item>
    Item[] stackArray;
    @Getter
    int topPosition;

    public ArrayBasedStack(int capacity) {
        stackArray = (Item[]) new Object[capacity];
    }

    public ArrayBasedStack() {
        stackArray = (Item[]) new Object[50];
    }

    public Item push(Item item) {
        if (stackArray.length > topPosition) {
            stackArray[topPosition++] = item;
            return item;
        } else {
            throw new IndexOutOfBoundsException("Capacity overflow");
        }
    }

    public Item pop() {
        if (topPosition > 0) {
            return stackArray[--topPosition];
        } else {
            throw new IndexOutOfBoundsException("Capacity underflow");
        }
    }

    public Item peek() {
        return stackArray[topPosition];
    }

    public boolean empty() {
        return topPosition == 0;
    }

    public synchronized int search(Object o) {
        int result=-1;
        for (int i = topPosition - 1; i >= 0; i--) {
         if (stackArray[i]==o){
             return i+1;
         }
        }
        return result;
    }
}
