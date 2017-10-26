import {ArrayBasedBag} from "../bags/ArrayBasedBag";

export class ArrayBasedSet<Item> extends ArrayBasedBag<Item> {

    constructor(capacity: number) {
        super(capacity);
    }

    /**
     * {@inheritDoc}
     */
    contains(item: Item): boolean {
        let index = this.internalArray.indexOf(item);
        return index !== -1;
    }

    /**
     * {@inheritDoc}
     */
    public add(item: Item): void {
        if (!this.contains(item)) {
            super.add(item);
        }
    }
}
