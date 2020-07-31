import time
import unittest


class Test_test1(unittest.TestCase):
    def test_A(self):
        self.fail("not implemented")


def test_main1():
    t1 = time.clock()
    for i in range(10000):
        print(1024/2, end='\r')
    t2 = time.clock()
    print(t2 - t1)


def test_main2():
    t1 = time.clock()
    for i in range(10000):
        print(1024//2, end='\r')
    t2 = time.clock()
    print(t2 - t1)


def test_main3():
    t1 = time.clock()
    for i in range(10000):
        print(1024 >> 1, end='\r')
    t2 = time.clock()
    print(t2 - t1)


def test_test():
    pass


if __name__ == "__main__":
    unittest.main()
