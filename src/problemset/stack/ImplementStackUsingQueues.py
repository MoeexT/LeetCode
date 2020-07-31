'''
Problem 225
用队列实现栈
https://leetcode-cn.com/problems/implement-stack-using-queues/
'''


class MyStack:
    """
    32ms: 70.38%
    13.5MB: 26.57%
    """

    def __init__(self):
        self.__data = []

    def push(self, x: int) -> None:
        self.__data.insert(0, x)

    def pop(self) -> int:
        if len(self.__data) != 0:
            return self.__data.pop(0)

    def top(self) -> int:
        if len(self.__data) != 0:
            return self.__data[0]

    def empty(self) -> bool:
        return True if len(self.__data) == 0 else False


if __name__ == "__main__":
    # Your MyStack object will be instantiated and called as such:
    obj = MyStack()
    obj.push(1)
    obj.push(2)
    print(obj.top())
    print(obj.pop())
    print(obj.empty())
