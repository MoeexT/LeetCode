'''
-*- coding: utf-8 -*-
Problem : 365
https://leetcode-cn.com/problems/water-and-jug-problem/
'''


class Solution:
    def canMeasureWater(self, x, y, z):
        """
        6569ms 5.32%
        165.7MB 6.25%
        """
        stack = [(0, 0)]
        self.seen = set()
        while stack:
            remain_x, remain_y = stack.pop()
            if remain_x == z or remain_y == z or remain_x + remain_y == z:
                return True
            if (remain_x, remain_y) in self.seen:
                continue
            self.seen.add((remain_x, remain_y))
            stack.append((x, remain_y))
            stack.append((remain_x, y))
            stack.append((0, remain_y))
            stack.append((remain_x, 0))
            stack.append((remain_x - min(remain_x, y - remain_y),
                          remain_y + min(remain_x, y - remain_y)))
            stack.append((remain_x + min(remain_y, x - remain_x),
                          remain_y - min(remain_y, x - remain_x)))
        return None


if __name__ == "__main__":
    solotion = Solution()
    print(solotion.canMeasureWater(3, 5, 4))
