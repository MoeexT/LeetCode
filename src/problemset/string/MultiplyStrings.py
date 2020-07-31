# problem 43


class Solution:
    def __init__(self):
        self._num = {'0': 0, '1': 1, '2': 2, '3': 3, '4': 4,
                     '5': 5, '6': 6, '7': 7, '8': 8, '9': 9}

    def multiply(self, num1: str, num2: str) -> str:
        '''
        56ms
        12.9MB
        '''
        result = 0
        if num1 == '0' or num2 == '0':
            return '0'

        N1 = self._parseInt(num1)
        for s in num2:
            result = result * 10 + N1 * self._num[s]

        return str(result)

    def _parseInt(self, numstr):
        num = 0
        for s in numstr:
            num = self._num[s] + num * 10
        return num


if __name__ == "__main__":
    solution = Solution()
    print(solution.multiply('9133', '0'))
