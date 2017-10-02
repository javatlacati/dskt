package jaba.stack;

/**
 * Created by Administrador on 05/06/2017.
 * Actually like a Vector.
 */
public class AutoGrowingArrayBasedStack<Item> extends ArrayBasedStack<Item> {
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

    public String toString() {
        return "AutoGrowingArrayBasedStack(super=" + super.toString() + ", capacityIncrement=" + this.capacityIncrement + ")";
    }

    public int getCapacityIncrement() {
        return this.capacityIncrement;
    }

    public void setCapacityIncrement(int capacityIncrement) {
        this.capacityIncrement = capacityIncrement;
    }
}
