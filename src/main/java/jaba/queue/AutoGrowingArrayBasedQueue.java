package jaba.queue;

/**
 * Created by Administrador on 05/06/2017.
 */
public class AutoGrowingArrayBasedQueue extends ArrayBasedQueue {
    int capacityIncrement = 10;

    public AutoGrowingArrayBasedQueue(int queueSize) {
        super(queueSize);
    }

    public AutoGrowingArrayBasedQueue(int queueSize, int capacityIncrement) {
        super(queueSize);
        this.capacityIncrement = capacityIncrement;
    }

    @Override
    public synchronized boolean enqueue(Object item) {
        if (isFull()) {
            int newCapacity = queueArray.length + capacityIncrement;
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(queueArray, 0, newArray, 0, queueArray.length);
            queueArray = newArray;
            capacity = newCapacity;
        }
        return super.enqueue(item);
    }

    public String toString() {
        return "AutoGrowingArrayBasedQueue(super=" + super.toString() + ", capacityIncrement=" + this.capacityIncrement + ")";
    }

    public int getCapacityIncrement() {
        return this.capacityIncrement;
    }

    public void setCapacityIncrement(int capacityIncrement) {
        this.capacityIncrement = capacityIncrement;
    }
}
