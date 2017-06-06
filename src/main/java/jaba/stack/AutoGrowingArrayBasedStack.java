package jaba.stack;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.val;

/**
 * Created by Administrador on 05/06/2017.
 */
@ToString(callSuper = true,of = {"capacityIncrement"})
public class AutoGrowingArrayBasedStack extends ArrayBasedStack {
    @Getter
    @Setter
    int capacityIncrement=10;

    public AutoGrowingArrayBasedStack(int capacity) {
        super(capacity);
    }

    public AutoGrowingArrayBasedStack(int capacity, int capacityIncrement) {
        super(capacity);
        this.capacityIncrement = capacityIncrement;
    }

    @Override
    public void push(Object item) {
        if (stackArray.length <= topPosition) {
            val newCapacity = stackArray.length + capacityIncrement;
            val newArray=new Object[newCapacity];
            for (int i = 0; i < stackArray.length; i++) {
                newArray[i]=stackArray[i];
            }
            stackArray=newArray;
        }
        super.push(item);
    }
}
