"""
problem 322
https://leetcode-cn.com/problems/coin-change/
have not comeleted
"""
from typing import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        coins.sort()
        count, cursor = 0, len(coins) - 1
        lcoin = []
        while amount > 0:
            if amount < coins[0]:
                return -1
            if (rem := amount // coins[cursor]) >= 1:
                count += rem
                amount %= coins[cursor]
            else:
                cursor -= 1
        return count



if __name__ == "__main__":
    sol = Solution()
    print(sol.coinChange([3, 5], 9))
    # print(sol.coinChange([186, 419, 83, 408], 6249))
