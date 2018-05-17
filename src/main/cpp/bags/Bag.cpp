template <class Item>
class Bag{
    public:
        void add(Item item);
        virtual boolean isEmpty() = true;
        virtual int size() = 0;
        virtual Item find(Item target) = null;
        void disposeItems();
        Item[] toArray();
}