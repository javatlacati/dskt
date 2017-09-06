from python.bags import Bag
from python.datastuctureutils.interface_cls import implements

@implements(Bag)
class ArrayBasedBag():
    def __init__(self,capacity):
        self.capacity=capacity