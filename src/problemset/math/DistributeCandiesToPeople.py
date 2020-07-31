"""
problem 1103
https://leetcode-cn.com/problems/distribute-candies-to-people/
"""
from typing import List
from utils.performance import time


class Solution:
    @time(times=100000)
    def distributeCandies1(self, candies: int, num_people: int) -> List[int]:
        # result = [0 for i in range(num_people)]
        result = {}
        idx = 0
        candy = 1
        while candies > 0:
            if candies > candy - 1:
                result.update({idx % num_people: result.get(idx % num_people, 0) + candy})
            else:
                result.update({idx % num_people: result.get(idx % num_people, 0) + candies})
            candies -= candy
            idx += 1
            candy += 1
        return (l := list(result.values())) + [0 for i in range(num_people-len(l))]

    @time(times=100000)
    def distributeCandies2(self, candies: int, num_people: int) -> List[int]:
        """
        52ms: 35.09%
        13.5MB: 23.58%
        :param candies:
        :param num_people:
        :return:
        """
        result = {}
        idx = 0
        candy = 1
        while candies > 0:
            if candies > candy - 1:
                result[idx % num_people] = result.get(idx % num_people, 0) + candy
            else:
                result[idx % num_people] = result.get(idx % num_people, 0) + candies
            candies -= candy
            idx += 1
            candy += 1
        return (l := list(result.values())) + [0 for i in range(num_people - len(l))]

    @time(times=100000)
    def distributeCandies3(self, candies: int, num_people: int) -> List[int]:
        # result = [0 for i in range(num_people)]
        result = dict.fromkeys([i for i in range(num_people)], 0)
        idx = 0
        candy = 1
        while candies > 0:
            if candies > candy - 1:
                result[idx % num_people] = result[idx % num_people] + candy
            else:
                result[idx % num_people] = result[idx % num_people] + candies
            candies -= candy
            idx += 1
            candy += 1
        return (l := list(result.values())) + [0 for i in range(num_people - len(l))]

    @time(times=100000)
    def distributeCandies4(self, candies: int, num_people: int) -> List[int]:
        """
        40ms:   77.64%
        13.5MB: 23.58%
        :param candies:
        :param num_people:
        :return:
        """
        result = [0 for i in range(num_people)]
        idx = 0
        candy = 1
        while candies > 0:
            if candies > candy - 1:
                result[idx % num_people] = result[idx % num_people] + candy
            else:
                result[idx % num_people] = result[idx % num_people] + candies
            candies -= candy
            idx += 1
            candy += 1
        return result


if __name__ == "__main__":
    sol = Solution()
    print(sol.distributeCandies1(80, 11))
    print(sol.distributeCandies2(80, 11))
    print(sol.distributeCandies3(80, 11))
    print(sol.distributeCandies4(80, 11))

