"""
  @date_time: 2020-04-07 17:03
  @author: MoeexT
  @problem: 154
  @url: https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/comments/
"""


class Solution:
    """
    time: 48ms 14%",
    mem: 52.52MB 6.25%
    """
    def findMin(self, nums) -> int:
        l, r = 0, len(nums) - 1
        while l < r:
            mid = l + (r - l) // 2
            if nums[mid] < nums[r]:
                r = mid
            elif nums[mid] > nums[r]:
                l = mid + 1
            else:
                r -= 1

        return nums[l]


if __name__ == "__main__":
    solution = Solution()
    print(solution.findMin([3, 4, 5, 1, 2]))
