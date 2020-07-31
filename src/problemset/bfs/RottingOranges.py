"""
problem 994
https://leetcode-cn.com/problems/rotting-oranges/
"""
from functools import reduce
from typing import List


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        """
        56 ms:      74.03%
        13.4 MB:    17.24%
        """
        minute = 0
        minute_flag = False

        while True:
            change = False
            for i in range(len(grid)):
                for j in range(len(grid[0])):
                    if grid[i][j] == 2:
                        if i - 1 >= 0 and grid[i - 1][j] == 1:
                            # 新感染的橘子
                            grid[i - 1][j] = 3
                            minute_flag = True
                        if i + 1 < len(grid) and grid[i + 1][j] == 1:
                            grid[i + 1][j] = 3
                            minute_flag = True
                        if j - 1 >= 0 and grid[i][j - 1] == 1:
                            grid[i][j - 1] = 3
                            minute_flag = True
                        if j + 1 < len(grid[0]) and grid[i][j + 1] == 1:
                            grid[i][j + 1] = 3
                            minute_flag = True
                        # 已经感染过其他橘子的橘子
                        grid[i][j] = 4
            if minute_flag:
                minute += 1
                minute_flag = False
                change = True
                for row in grid:
                    print(row)
                print('------------')
                for p in range(len(grid)):
                    for q in range(len(grid[0])):
                        if grid[p][q] == 3:
                            grid[p][q] = 2
                for row in grid:
                    print(row)
                print('============')
            if not change:
                break
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 4:
                    grid[i][j] = 2
        return -1 if 1 in reduce(lambda x, y: x + y, grid) else minute


if __name__ == "__main__":
    sol = Solution()
    print(sol.orangesRotting([[2, 1, 1], [1, 1, 0], [0, 1, 1]]))
