package jaba.stack;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Administrador on 05/06/2017.
 * Actually like a Vector.
 */
@ToString(callSuper = true,of = {"capacityIncrement"})
public class AutoGrowingArrayBasedStack<Item> extends ArrayBasedStack<Item> {
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
    public Item push(Item item) {
        if (stackArray.length <= topPosition) {
            int newCapacity = stackArray.length + capacityIncrement;
            Object[] newArray=new Object[newCapacity];
            for (int i = 0; i < stackArray.length; i++) {
                newArray[i]=stackArray[i];
            }
            stackArray= (Item[]) newArray;
        }
        return super.push(item);
    }
}
