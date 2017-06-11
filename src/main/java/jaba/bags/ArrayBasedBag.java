package jaba.bags;

public class ArrayBasedBag implements Bag {

    private Object[] internalArray;
    private int topPosition;

    public ArrayBasedBag(int capacity) {
        internalArray = new Object[capacity];
        topPosition = 0;
    }

    @Override
    public void add(Object item) {
        if (internalArray.length > topPosition) {
            internalArray[topPosition++] = item;
        } else {
            throw new IndexOutOfBoundsException("Capacity overflow");
        }
    }

    @Override
    public boolean isEmpty() {
        return topPosition == 0;
    }

    @Override
    public int size() {
        return topPosition;
    }
}
