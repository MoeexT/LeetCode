"""
problem interview 59-II
https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
"""


class MaxQueue:
    """
    280ms: 57.73%
    16.9MB: 100%
    """
    def __init__(self):
        self.__len = 0
        self.__data = []

    def max_value(self) -> int:
        return max(self.__data) if self.__len != 0 else -1

    def push_back(self, value: int) -> None:
        self.__data.append(value)
        self.__len += 1

    def pop_front(self) -> int:
        if self.__len != 0:
            v = self.__data[0]
            self.__data = self.__data[1:]
            self.__len -= 1
            return v
        else:
            return -1


if __name__ == "__main__":
    obj = MaxQueue()
    print(obj.push_back(1))
    print(obj.push_back(2))
    print(obj.max_value())
    print(obj.pop_front())
    print(obj.max_value())
