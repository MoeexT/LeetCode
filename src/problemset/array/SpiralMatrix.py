''' -*- coding: utf-8 -*-
date: 2020-03-26
time: 21:15:58
author: MoeexT
problem: 54.
url: https://leetcode-cn.com/problems/spiral-matrix/
'''
from typing import List


class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        '''
        from: https://leetcode-cn.com/problems/spiral-matrix/solution/luo-xuan-ju-zhen-by-leetcode/130844
        time: 40ms 41.84%
        mem: 13.7MB 5.15%
        '''
        res = []
        while matrix:
            res += matrix.pop(0)
            matrix = list(map(list, zip(*matrix)))[::-1] # map(list, zip(*matrix[::-1]))
        return res


if __name__ == "__main__":
    solution = Solution()
    print(solution.spiralOrder([
        [1,2,3],
        [4,5,6],
        [7,8,9]
        ]))
