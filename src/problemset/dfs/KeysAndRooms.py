''' -*- coding: utf-8 -*-
@date: 2020-03-25
@time: 18:43:36
@author: MoeexT
Problem: 841.
url: https://leetcode-cn.com/problems/keys-and-rooms/
'''
from functools import reduce
from typing import List


class Solution:
    def __init__(self):
        self.flag = [];
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        '''
        @time: 104ms 31.73%
        @mem: 14.2MB 6.56%
        '''
        self.flag = [False for i in range(len(rooms))]
        self.flag[0] = True
        self.dfs(rooms, 0)
        print(self.flag)
        return reduce(lambda x, y: x and y, self.flag)
        
    def dfs(self, rooms, idx):
        for key in rooms[idx]:
            if self.flag[key]:
                continue
            self.flag[key] = True
            self.dfs(rooms, key)



if __name__ == "__main__":
    solution = Solution()
    print(solution.canVisitAllRooms([[]]))
