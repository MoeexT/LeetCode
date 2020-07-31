"""
problem 31.
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

链接：https://leetcode-cn.com/problems/next-permutation
"""
from typing import List
import sys


class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        '''
        44ms: 81.73%
        13MB: 52.73%
        '''
        for i in range(len(nums)-2, -1, -1):
            maxidx = self._max_idx(nums, i)
            if maxidx[0] != sys.maxsize and nums[i] < maxidx[0]:
                nums[i], nums[maxidx[1]] = nums[maxidx[1]], nums[i]
                # self._quick_sort(nums, i+1, len(nums)-1)
                nums_bhd_hf = nums[i+1:]
                nums_bhd_hf.sort()
                # nums = nums[:i+1] + nums_bhd_hf
                for n in range(len(nums_bhd_hf)):
                    nums[i+1+n] = nums_bhd_hf[n]
                break
        else:
            nums.sort()
        print(nums)

    def _max_idx(self, array: List[int], end: int) -> List[int]:
        '''
        从后向前搜索 array[end:] 内大于 array[end] 的最小值及其索引
        array: 目标列表，索引以0开始
        end: 搜索到何处
        res: 最小值 & 索引，不存在返回[-1, -1]
        '''
        res = [sys.maxsize, -1]
        guard = array[end]
        for i in range(len(array)-1, end-1, -1):
            if array[i] > guard and array[i] < res[0]:
                res[0] = array[i]
                res[1] = i
        print(res)
        return res
    """
    def _quick_sort(self, array, low, high):
        if low < high:
            mid = self._quick_pass(array, low, high)
            self._quick_sort(array, low, mid - 1)
            self._quick_sort(array, mid + 1, high)

    def _quick_pass(self, array, low, high):
        guard = array[low]
        i, j = low + 1, high
        while True:
            while array[i] < guard and i < high:
                i += 1
            while array[j] > guard:
                j -= 1
            if i >= j:
                break
            array[i], array[j] = array[j], array[i]
        array[low] = array[j]
        array[j] = guard
        return j
    """


if __name__ == "__main__":
    solution = Solution()
    solution.nextPermutation([1, 3, 2])
    # solution._max_idx([0, 1], 0)
