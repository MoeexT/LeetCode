''' -*- coding: utf-8 -*-
date: 2020-04-01
time: 15:00:55
author: MoeexT
problem: 118.
url: List<Integer> row = new ArrayList<>();
'''
from typing import List


class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        '''
        time: 28ms 92.81%
        mem: 13.7MB 5.12%
        '''
        if numRows == 0:
            return []
        res = [[1]]
        for i in range(1, numRows):
            row = [1]
            for j in range(1, i):
                row.append(res[-1][j-1] + res[-1][j])
            row.append(1)
            res.append(row)
        return res


if __name__ == "__main__":
    solution = Solution()
    print(solution.generate(1))
