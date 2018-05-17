#include <iostream>

using namespace std;

template <class Item>
class ArrayBasedBag :public Bag {
     protected:

     /**
     * Array that contains the bag elements.
     */
    Item* internalArray;
    /**
     * Number of max 0 based index of used slots in the array.
     */
       int topPosition;


}
