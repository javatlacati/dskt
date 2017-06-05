package jaba.queue;

import lombok.Getter;
import lombok.Setter;
import lombok.val;

/**
 * Created by Administrador on 05/06/2017.
 */
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
            val newCapacity = queueArray.length + capacityIncrement;
            val newArray = new Object[newCapacity];
            for (int i = 0; i < queueArray.length; i++) {
                newArray[i] = queueArray[i];
            }
            queueArray = newArray;
            capacity = newCapacity;
        }
        super.enqueue(item);
    }
}
