package main

import "fmt"

// problem: 167
// url: https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/

func twoSum(nums []int, target int) []int {
	low, high := 0, len(nums)-1;

	for low < high {
		if nums[low] + nums[high] == target {
			return []int{low+1, high+1}
		} else if nums[low] + nums[high] < target {
			low++
		} else {
			high--
		}
	}
	return []int{}
}


func main() {
	fmt.Println(twoSum([]int{2,7,11,15}, 9))
}
