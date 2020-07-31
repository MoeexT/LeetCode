# problem 34.
from typing import List


class Solution:
    def searchRange_(self, nums: List[int], target: int) -> List[int]:
        '''
        先找出目标的位置，然后向两边扩展
        复杂度的话，比log(n)高
        112ms
        14.6MB
        '''
        result = [-1, -1]
        pos1 = self.__binarySearch(nums, target)
        if len(nums) == 0 or pos1 == -1:
            return result

        pos2 = pos1

        while nums[pos2] == target:
            pos2 -= 1
            if pos2 == -1:
                break
        result[0] = pos2 + 1

        while nums[pos1] == target:
            pos1 += 1
            if pos1 == len(nums):
                break
        result[1] = pos1 - 1

        return result

    def __binarySearch(self, array: List[int], tgt: int) -> int:
        low, high = 0, len(array) - 1
        while low <= high:
            mid = (low + high) >> 1
            if array[mid] == tgt:
                return mid
            elif array[mid] < tgt:
                low = mid + 1
            else:
                high = mid - 1
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        '''
        力扣题解
        '''
        left_idx = self.extreme_insertion_index(nums, target, True)
        if left_idx == len(nums) or nums[left_idx] != target:
            return [-1, -1]

        return [left_idx, self.extreme_insertion_index(nums, target, False)-1]

    def extreme_insertion_index(self, nums, target, left):
        lo, hi = 0, len(nums)

        while lo < hi:
            mid = (lo + hi) >> 1
            if nums[mid] > target or (left and target == nums[mid]):
                hi = mid
            else:
                lo = mid + 1

        return lo


if __name__ == "__main__":
    solution = Solution()
    print(solution.searchRange([5, 7, 7, 8, 8, 8, 8, 8, 8, 10], 8))
    print(solution.searchRange([8, 8, 8, 8, 8, 8], 8))
    print(solution.searchRange([8, 8], 8))
    print(solution.searchRange([8], 8))
    print(solution.searchRange([], 8))
    print(solution.searchRange([1, 2, 3, 4, 5], 8))
    print(solution.searchRange([1, 2], 8))
    print(solution.searchRange([1], 8))
