# problem 13
# https://leetcode-cn.com/problems/roman-to-integer/


class Solution:
    def __init__(self):
        super().__init__()
        self.roman = {'I': 1, 'V': 5, 'X': 10, 'L': 50,
                      'C': 100, 'D': 500, 'M': 1000}

    def romanToInt(self, s: str) -> int:
        '''
        52ms: 72.87%
        13.3MB: 51.09%
        '''
        result = 0
        for i in range(len(s)-1):
            if self.roman[s[i]] < self.roman[s[i+1]]:
                result -= self.roman[s[i]]
            else:
                result += self.roman[s[i]]
        result += self.roman[s[-1]]
        print(result)
        return result


if __name__ == "__main__":
    solution = Solution()
    solution.romanToInt('MCMXCIV')
