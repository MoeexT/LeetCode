"""
problem interview 57-II
https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
"""
from typing import List
# import numba


class Solution:
    def findContinuousSequence(self, target: int) -> List[List[int]]:
        """
        36ms: 98.38%
        13.4MB: 100.00%
        优化来自 https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/comments/252768
        """
        div = 1
        res = []

        while target > 0:
            target -= div
            div += 1
            if target > 0 and target % div == 0:
                res.append(list(range((y := target // div), y + div)))
                # if (x := target - sum([i for i in range(div)])) % div == 0 and x > 0:
                #     res.append( r := list(range((y := x // div), y + div)))

        return res[::-1]


if __name__ == "__main__":
    sol = Solution()
    print(sol.findContinuousSequence(50252))
