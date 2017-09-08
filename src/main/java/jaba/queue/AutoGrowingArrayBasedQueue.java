package jaba.queue;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Administrador on 05/06/2017.
 */
@ToString(callSuper = true,of = {"capacityIncrement"})
public class AutoGrowingArrayBasedQueue extends ArrayBasedQueue {
    @Getter
    @Setter
    int capacityIncrement = 10;

    public AutoGrowingArrayBasedQueue(int queueSize) {
        super(queueSize);
    }

    public AutoGrowingArrayBasedQueue(int queueSize, int capacityIncrement) {
        super(queueSize);
        this.capacityIncrement = capacityIncrement;
    }

    @Override
    public synchronized void enqueue(Object item) {
        if (isFull()) {
            int newCapacity = queueArray.length + capacityIncrement;
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(queueArray, 0, newArray, 0, queueArray.length);
            queueArray = newArray;
            capacity = newCapacity;
        }
        super.enqueue(item);
    }
}
