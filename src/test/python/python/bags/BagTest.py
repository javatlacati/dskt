from jaba.bags import ArrayBasedBag


class BagTest():
    def test_is_empty(self):
        bag=ArrayBasedBag(50)
        assert bag.isEmpty() == True