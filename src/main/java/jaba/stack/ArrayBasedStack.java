package jaba.stack;

public class ArrayBasedStack<Item> {
    Item[] stackArray;
    int topPosition;

    public ArrayBasedStack(int capacity) {
        stackArray = (Item[]) new Object[capacity];
    }

    public ArrayBasedStack() {
        stackArray = (Item[]) new Object[50];
    }

    /**
     * Adds an element on the top of the stack.
     */
    public Item push(Item item) {
        if (stackArray.length > topPosition) {
            stackArray[topPosition++] = item;
            return item;
        } else {
            throw new IndexOutOfBoundsException("Capacity overflow");
        }
    }

    /**
     * Removes the element of the top of the stack.
     */
    public Item pop() {
        if (topPosition > 0) {
            return stackArray[--topPosition];
        } else {
            throw new IndexOutOfBoundsException("Capacity underflow");
        }
    }

    /**
     * Lets us observe the top element of the stack.
     */
    public Item peek() {
        return stackArray[topPosition];
    }

    /**
     * Tells us wherter this stack is empty.
     *
     * @return true if the stack is empty false otherwise
     */
    public boolean isEmpty() {
        return topPosition == 0;
    }

    public boolean empty() {
        return isEmpty();
    }

    /**
     * Makes this stack empty.
     */
    public void makeEmpty() {
        topPosition = 0;
    }

    /**
     * @return position of the element starting from top.
     */
    public synchronized int find(Item o) {
        int result = -1;
        for (int i = topPosition - 1; i >= 0; i--) {
            if (stackArray[i] == o) {
                return i + 1;
            }
        }
        return result;
    }

    public String toString() {
        return "ArrayBasedStack(stackArray=" + java.util.Arrays.deepToString(this.stackArray) + ", topPosition=" + this.topPosition + ")";
    }

    public int getTopPosition() {
        return this.topPosition;
    }
}
