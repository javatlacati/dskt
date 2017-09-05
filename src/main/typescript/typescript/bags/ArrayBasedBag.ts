class ArrayBasedBag {
    private _capacity: Number;

    constructor(capacity: Number) {
        this._capacity = capacity;
    }

    get capacity(): Number {
        return this._capacity;
    }

    set capacity(value: Number) {
        this._capacity = value;
    }
}