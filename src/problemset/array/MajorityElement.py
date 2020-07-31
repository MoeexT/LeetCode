# https://leetcode-cn.com/problems/majority-element/
from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        """
        84ms: 77.80%
        15.1MB: 5.04%
        """
        dic = {}
        for num in nums:
            dic.update({num: dic.get(num, 0) + 1})
        
        for key, value in dic.items():
            if value > len(nums) >> 1:
                return key


if __name__ == "__main__":
    sol = Solution()
    print(sol.majorityElement([]))
