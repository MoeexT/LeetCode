package main

// url: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
// problem: 26

// Time: O(n); 0ms, 100%
// Space: O(1); 4.6MB, 100%
func removeDuplicates(nums []int) int {
	cursor := 1

	for i := 1; i < len(nums); i++ {
		if nums[i-1] != nums[i] {
			nums[cursor] = nums[i]
			cursor++
		}
	}
	return cursor
}
