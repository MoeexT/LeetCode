"""
  @date_time: 2020-04-26 14:30
  @author: MoeexT
  @problem: 面试题29
  @url: https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
"""
from typing import List


class Solution:
    """
    time: 56ms 53.75%",
    mem: 13.9MB 100%
    """
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        ans = []
        while matrix:
            ans += matrix[0][::]
            matrix = list(zip(*matrix[1:]))[::-1]
        return ans


if __name__ == "__main__":
    solution = Solution()
    print(solution.spiralOrder([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]))
