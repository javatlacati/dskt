import {Bag} from './bag';

export class ArrayBasedBag<Item> implements Bag<Item> {
    /**
     * Array that contains the bag elements.
     */
    protected internalArray:Item[];
    /**
     * Number of max 0 based index of used slots in the array.
     */
    protected topPosition: number;

    /**
     * Constructs instances of bag class.
     *
     * @param capacity number of elements that this bag can hold.
     */
    constructor(capacity: number) {
        this.internalArray = new Array<Item>(capacity);
        this.topPosition = 0;
    }
    
    /**
     * {@inheritDoc}
     */
    public add(item:Item):void {
        if (this.internalArray.length > this.topPosition) {
            this.internalArray[this.topPosition++] = item;
        } else {
            throw new RangeError("Capacity overflow");
        }
    }

    /**
     * indexes are 0 based
     */
    getAtIndex(index:number):Item {
        return this.internalArray[index];
    }

    /**
     * {@inheritDoc}
     */
    public isEmpty():boolean {
        return this.topPosition == 0;
    }

    /**
     * {@inheritDoc}
     */
    public disposeItems():void {
        this.internalArray = this.internalArray = new Array<Item>(this.internalArray.length);
        this.topPosition = 0;
    }

    /**
     * {@inheritDoc}
     */
    public size():number {
        return this.topPosition;
    }

    /**
     * {@inheritDoc}
     * This method performs a lineal search.
     */
    public find(target:Item):Item {
        let index=this.internalArray.indexOf(target);
        return index === -1 ? null : this.internalArray[index];
    }

//    get capacity(): Number {
//        return this._capacity;
//    }
//
//    set capacity(value: Number) {
//        this._capacity = value;
//    }
}