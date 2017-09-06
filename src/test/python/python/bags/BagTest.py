import unittest

from jaba.bags import ArrayBasedBag


class BagTest(unittest.TestCase):
    def test_is_empty(self):
        bag=ArrayBasedBag(50)
        self.assertTrue(bag.isEmpty())